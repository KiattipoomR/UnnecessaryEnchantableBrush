package kiattipoomr.unnecessaryenchantablebrush.datagen;

import kiattipoomr.unnecessaryenchantablebrush.registry.EnchantmentRegistry;
import kiattipoomr.unnecessaryenchantablebrush.registry.TagRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.*;

import java.util.concurrent.CompletableFuture;

public class EnchantmentProvider extends FabricDynamicRegistryProvider {
    public EnchantmentProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void bootstrap(Registerable<Enchantment> registry) {
        RegistryEntryLookup<Item> itemRegistryLookup = registry.getRegistryLookup(RegistryKeys.ITEM);

        register(registry, EnchantmentRegistry.SWIFT_HAND, Enchantment.builder(
                Enchantment.definition(
                        itemRegistryLookup.getOrThrow(TagRegistry.BRUSH_ENCHANTABLE),
                        5,
                        4,
                        Enchantment.leveledCost(1, 10),
                        Enchantment.leveledCost(41, 10),
                        2,
                        AttributeModifierSlot.MAINHAND
                )
        ));
        register(registry, EnchantmentRegistry.LUCKY_FINDS, Enchantment.builder(
                Enchantment.definition(
                        itemRegistryLookup.getOrThrow(TagRegistry.BRUSH_ENCHANTABLE),
                        2,
                        4,
                        Enchantment.leveledCost(10, 8),
                        Enchantment.leveledCost(45, 8),
                        4,
                        AttributeModifierSlot.MAINHAND
                )
        ));
    }

    private static void register(Registerable<Enchantment> registry,
                                 RegistryKey<Enchantment> enchantmentRegistryKey, Enchantment.Builder builder) {
        registry.register(enchantmentRegistryKey, builder.build(enchantmentRegistryKey.getValue()));
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getOrThrow(RegistryKeys.ENCHANTMENT));
    }

    @Override
    public String getName() {
        return "ModEnchantmentGenerator";
    }
}
