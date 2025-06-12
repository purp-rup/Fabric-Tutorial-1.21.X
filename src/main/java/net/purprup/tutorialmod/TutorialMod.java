package net.purprup.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Vec3d;
import net.purprup.tutorialmod.block.ModBlocks;
import net.purprup.tutorialmod.component.ModDataComponentTypes;
import net.purprup.tutorialmod.item.ModArmorMaterials;
import net.purprup.tutorialmod.item.ModItemGroups;
import net.purprup.tutorialmod.item.ModItems;
import net.purprup.tutorialmod.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer
{
	public static final String MOD_ID = "tutorial-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModDataComponentTypes.registerDataComponentTypes();
		ModArmorMaterials.registerModArmorMaterials();
		ModSounds.registerSounds();

		// Use end rod on sheep :)
		UseEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
			if(entity instanceof SheepEntity sheepEntity)
			{
				if(playerEntity.getMainHandStack().getItem() == Items.END_ROD)
				{
					playerEntity.sendMessage(Text.literal("Bro..."), true);
					playerEntity.getMainHandStack().decrement(1);
					sheepEntity.setVelocity(0, 5, 0);

					return ActionResult.SUCCESS;
				}
			}
			return ActionResult.PASS;
		});
	}
}