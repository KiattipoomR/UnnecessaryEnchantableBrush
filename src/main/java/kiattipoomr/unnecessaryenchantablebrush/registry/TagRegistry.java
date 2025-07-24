package kiattipoomr.unnecessaryenchantablebrush.registry;

import kiattipoomr.unnecessaryenchantablebrush.util.ModConstant;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagRegistry {
    public static final TagKey<Item> BRUSH_ENCHANTABLE = registerItemTagKey("enchantable/brush");

    private static TagKey<Item> registerItemTagKey(String name) {
        Identifier identifier = ModConstant.Identifier(name);

        ModConstant.LOGGER.info("Registering mod item tag {} ...", identifier);
        return TagKey.of(RegistryKeys.ITEM, identifier);
    }
}
