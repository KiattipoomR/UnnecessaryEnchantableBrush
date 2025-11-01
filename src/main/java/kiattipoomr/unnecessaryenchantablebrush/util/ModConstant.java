package kiattipoomr.unnecessaryenchantablebrush.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class ModConstant {
    public static final String MOD_ID = "unnecessaryenchantablebrush";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier Identifier(String name) {
        return Identifier.of(MOD_ID, name);
    }

    public static int getEnchantmentLevelFromItem(ItemStack item, RegistryKey<Enchantment> enchantmentRegistryKey) {
        if (item == ItemStack.EMPTY) {
            return 0;
        }

        for (RegistryEntry<Enchantment> entry : item.getEnchantments().getEnchantments()) {
            Optional<RegistryKey<Enchantment>> itemEnchantmentRegistryKey = entry.getKey();
            // If the registry key is empty, do nothing
            if (itemEnchantmentRegistryKey.isEmpty()) {
                continue;
            }

            // If not the enchantment we're looking for, do nothing
            if (!itemEnchantmentRegistryKey.get().equals(enchantmentRegistryKey)) {
                continue;
            }

            return item.getEnchantments().getLevel(entry);
        }

        return 0;
    }
}
