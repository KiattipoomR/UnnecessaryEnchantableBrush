package kiattipoomr.unnecessaryenchantablebrush.mixin;

import kiattipoomr.unnecessaryenchantablebrush.registry.EnchantmentRegistry;
import kiattipoomr.unnecessaryenchantablebrush.util.ModConstant;
import net.minecraft.block.entity.BrushableBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrushableBlockEntity.class)
public abstract class BrushableBlockEntityMixin {
    @Shadow
    public abstract ItemStack getItem();

    @Inject(
            method = "spawnItem(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/entity/BrushableBlockEntity;generateItem(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;)V",
                    shift = At.Shift.AFTER
            )
    )
    private void injectSpawnItem(ServerWorld world, LivingEntity brusher, ItemStack brush, CallbackInfo ci) {
        int enchantmentLevel = ModConstant.getEnchantmentLevelFromItem(brush, EnchantmentRegistry.LUCKY_FINDS);
        float randomNumber = world.random.nextFloat();
        if (randomNumber < enchantmentLevel * 0.25) {
            ItemStack item = this.getItem();
            item.setCount(item.getCount() + 1);
        }
    }
}
