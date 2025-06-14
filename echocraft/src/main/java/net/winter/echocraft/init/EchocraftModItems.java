
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.winter.echocraft.init;

import net.winter.echocraft.item.GuideBookItem;
import net.winter.echocraft.EchocraftMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

public class EchocraftModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(EchocraftMod.MODID);
	public static final DeferredItem<Item> GUIDE_BOOK = REGISTRY.register("guide_book", GuideBookItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
