package net.purprup.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.purprup.tutorialmod.entity.ModEntities;
import net.purprup.tutorialmod.entity.client.MessageEntityModel;
import net.purprup.tutorialmod.entity.client.MessageRenderer;
import net.purprup.tutorialmod.entity.client.MichaelModel;
import net.purprup.tutorialmod.entity.client.MichaelRenderer;
import net.purprup.tutorialmod.gui.MessageScreen;

public class TutorialModClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityModelLayerRegistry.registerModelLayer(MichaelModel.MICHAEL, MichaelModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MICHAEL, MichaelRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MessageEntityModel.MESSAGE, MessageEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MESSAGE, MessageRenderer::new);

        openScreenCommand();
    }

    public void openScreenCommand()
    {
        ClientCommandRegistrationCallback.EVENT.register(((commandDispatcher, commandRegistryAccess) ->
                commandDispatcher.register(ClientCommandManager.literal("message-screen")
                        .executes(commandContext -> {
                            MinecraftClient client = commandContext.getSource().getClient();
                            client.send(() -> client.setScreen(new MessageScreen(Text.of("Message Screen"))));
                            return 1;
                        })
                )
        ));
    }
}
