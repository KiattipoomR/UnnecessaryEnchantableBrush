package kiattipoomr.unnecessaryenchantablebrush.mixin;

import net.minecraft.item.BrushItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BrushItem.class)
public class BrushItemMixin {
    @ModifyArg(
            method = "<init>(Lnet/minecraft/item/Item$Settings;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/Item;<init>(Lnet/minecraft/item/Item$Settings;)V"),
            index = 0
    )
    private static Item.Settings modifyBrushItemSettings(Item.Settings settings) {
        // Make BrushItem enchantable
        return settings.enchantable(1);
    }
}
