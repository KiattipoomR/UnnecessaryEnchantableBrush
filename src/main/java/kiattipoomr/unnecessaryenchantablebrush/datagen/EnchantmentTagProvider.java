package kiattipoomr.unnecessaryenchantablebrush.datagen;

import kiattipoomr.unnecessaryenchantablebrush.registry.EnchantmentRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;

import java.util.concurrent.CompletableFuture;

public class EnchantmentTagProvider extends FabricTagProvider<Enchantment> {
    public EnchantmentTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ENCHANTMENT, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(EnchantmentTags.NON_TREASURE)
                .add(EnchantmentRegistry.SWIFT_HAND.getValue())
                .add(EnchantmentRegistry.LUCKY_FINDS.getValue());
    }
}
