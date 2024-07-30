package net.Byebye007x.firstprotomod.item;

import net.Byebye007x.firstprotomod.ProtoMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeMode {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProtoMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CUSTOM_TAB = CREATIVE_MODE_TABS.register("custom_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Moditems.RUBY.get()))
                    .title(Component.translatable("creativetab.custom_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.RUBY.get());
                        output.accept(Moditems.RAW_RUBY.get());
                        output.accept(Items.DIAMOND);
                    })
                    .build() );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
