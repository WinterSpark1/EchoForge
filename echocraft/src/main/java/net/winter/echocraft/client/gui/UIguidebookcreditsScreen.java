package net.winter.echocraft.client.gui;

import net.winter.echocraft.world.inventory.UIguidebookcreditsMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class UIguidebookcreditsScreen extends AbstractContainerScreen<UIguidebookcreditsMenu> {
	private final static HashMap<String, Object> guistate = UIguidebookcreditsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_prev;
	Button button_next;

	public UIguidebookcreditsScreen(UIguidebookcreditsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 256;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("echocraft:textures/screens/u_iguidebookcredits.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 7 && mouseX < leftPos + 31 && mouseY > topPos + 22 && mouseY < topPos + 46) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.echocraft.u_iguidebookcredits.tooltip_crea"), mouseX, mouseY);
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("echocraft:textures/screens/winter2.png"), this.leftPos + 4, this.topPos + 99, 0, 0, 64, 64, 64, 64);

		guiGraphics.blit(ResourceLocation.parse("echocraft:textures/screens/guide_book.png"), this.leftPos + 11, this.topPos + 26, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.echocraft.u_iguidebookcredits.label_winterspark"), 192, 128, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.echocraft.u_iguidebookcredits.label_programmer"), 5, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_prev = Button.builder(Component.translatable("gui.echocraft.u_iguidebookcredits.button_prev"), e -> {
		}).bounds(this.leftPos + 157, this.topPos + 141, 46, 20).build();
		guistate.put("button:button_prev", button_prev);
		this.addRenderableWidget(button_prev);
		button_next = Button.builder(Component.translatable("gui.echocraft.u_iguidebookcredits.button_next"), e -> {
		}).bounds(this.leftPos + 205, this.topPos + 141, 46, 20).build();
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
	}
}
