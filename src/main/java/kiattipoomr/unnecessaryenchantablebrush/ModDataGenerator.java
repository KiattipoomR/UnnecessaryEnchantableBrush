package kiattipoomr.unnecessaryenchantablebrush;

import kiattipoomr.unnecessaryenchantablebrush.datagen.EnchantmentProvider;
import kiattipoomr.unnecessaryenchantablebrush.datagen.EnchantmentTagProvider;
import kiattipoomr.unnecessaryenchantablebrush.datagen.ItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ItemTagProvider::new);
        pack.addProvider(EnchantmentTagProvider::new);
        pack.addProvider(EnchantmentProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, EnchantmentProvider::bootstrap);
    }
}
