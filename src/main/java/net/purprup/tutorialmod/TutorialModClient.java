package net.purprup.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.purprup.tutorialmod.entity.ModEntities;
import net.purprup.tutorialmod.entity.client.MichaelModel;
import net.purprup.tutorialmod.entity.client.MichaelRenderer;

public class TutorialModClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityModelLayerRegistry.registerModelLayer(MichaelModel.MICHAEL, MichaelModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MICHAEL, MichaelRenderer::new);
    }
}
