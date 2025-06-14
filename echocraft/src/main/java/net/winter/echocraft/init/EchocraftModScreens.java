
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.winter.echocraft.init;

import net.winter.echocraft.client.gui.UiguidebookScreen;
import net.winter.echocraft.client.gui.UIguidebookcreditsScreen;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EchocraftModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(EchocraftModMenus.UIGUIDEBOOK.get(), UiguidebookScreen::new);
		event.register(EchocraftModMenus.U_IGUIDEBOOKCREDITS.get(), UIguidebookcreditsScreen::new);
	}
}
