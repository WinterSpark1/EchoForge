
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.winter.echocraft.init;

import net.winter.echocraft.world.inventory.UiguidebookMenu;
import net.winter.echocraft.world.inventory.UIguidebookcreditsMenu;
import net.winter.echocraft.EchocraftMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

public class EchocraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, EchocraftMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<UiguidebookMenu>> UIGUIDEBOOK = REGISTRY.register("uiguidebook", () -> IMenuTypeExtension.create(UiguidebookMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UIguidebookcreditsMenu>> U_IGUIDEBOOKCREDITS = REGISTRY.register("u_iguidebookcredits", () -> IMenuTypeExtension.create(UIguidebookcreditsMenu::new));
}
