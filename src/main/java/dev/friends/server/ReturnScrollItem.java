package dev.friends.server;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ReturnScrollItem extends Item {
    public ReturnScrollItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient && user instanceof ServerPlayerEntity player) {
            ServerWorld overworld = player.getServer().getOverworld();
            BlockPos spawn = overworld.getSpawnPos();
            player.teleport(overworld, spawn.getX() + 0.5, spawn.getY(), spawn.getZ() + 0.5,
                    java.util.Set.of(), player.getYaw(), player.getPitch());
            stack.decrement(1);
        }
        return TypedActionResult.success(stack, world.isClient);
    }
}