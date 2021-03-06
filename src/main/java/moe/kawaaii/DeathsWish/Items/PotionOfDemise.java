package moe.kawaaii.DeathsWish.Items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class PotionOfDemise extends DemiseItem {
    public PotionOfDemise(String path, int maxCount, ItemGroup group) {
        super(path, maxCount, group);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient()) ((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE, user.getX(), user.getY(), user.getZ(), 25, 0, 0, 0, 0.1);
        super.usageTick(world, user, stack, remainingUseTicks);
    }
}
