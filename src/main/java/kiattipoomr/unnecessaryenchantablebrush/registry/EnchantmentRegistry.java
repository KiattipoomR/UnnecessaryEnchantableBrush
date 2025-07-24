package kiattipoomr.unnecessaryenchantablebrush.registry;

import kiattipoomr.unnecessaryenchantablebrush.util.ModConstant;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class EnchantmentRegistry {
    public static final RegistryKey<Enchantment> SWIFT_HAND = RegistryKey.of(
            RegistryKeys.ENCHANTMENT, ModConstant.Identifier("swift_hand"));
    public static final RegistryKey<Enchantment> LUCKY_FINDS = RegistryKey.of(
            RegistryKeys.ENCHANTMENT, ModConstant.Identifier("lucky_finds"));
}
