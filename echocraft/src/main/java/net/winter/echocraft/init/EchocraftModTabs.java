
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.winter.echocraft.init;

import net.winter.echocraft.EchocraftMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class EchocraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EchocraftMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ECHO_CRAFT = REGISTRY.register("echo_craft",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.echocraft.echo_craft")).icon(() -> new ItemStack(EchocraftModItems.GUIDE_BOOK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(EchocraftModItems.GUIDE_BOOK.get());
			}).withSearchBar().build());
}
