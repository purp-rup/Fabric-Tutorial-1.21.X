package net.purprup.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PinkGarnetLampBlock extends Block
{
    // Makes it unique to this specific lamp
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    public PinkGarnetLampBlock(Settings settings)
    {
        super(settings);
        //this.setDefaultState(this.stateManager.getDefaultState().with(CLICKED, false));
        setDefaultState(this.getDefaultState().with(CLICKED, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit)
    {
        if(!world.isClient)
        {
            world.setBlockState(pos, state.cycle(CLICKED));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(CLICKED);
    }
}
