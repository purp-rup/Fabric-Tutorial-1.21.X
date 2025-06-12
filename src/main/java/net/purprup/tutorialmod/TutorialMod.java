package net.purprup.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.purprup.tutorialmod.block.ModBlocks;
import net.purprup.tutorialmod.item.ModArmorMaterials;
import net.purprup.tutorialmod.item.ModItemGroups;
import net.purprup.tutorialmod.item.ModItems;
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
		ModArmorMaterials.registerModArmorMaterials();
	}
}