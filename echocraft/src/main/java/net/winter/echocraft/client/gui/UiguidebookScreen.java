package net.winter.echocraft.client.gui;

import net.winter.echocraft.world.inventory.UiguidebookMenu;
import net.winter.echocraft.network.UiguidebookButtonMessage;

import net.neoforged.neoforge.network.PacketDistributor;

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

public class UiguidebookScreen extends AbstractContainerScreen<UiguidebookMenu> {
	private final static HashMap<String, Object> guistate = UiguidebookMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_crafting;
	Button button_item;
	Button button_tips;
	Button button_credit;

	public UiguidebookScreen(UiguidebookMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("echocraft:textures/screens/uiguidebook.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	}

	@Override
	public void init() {
		super.init();
		button_crafting = Button.builder(Component.translatable("gui.echocraft.uiguidebook.button_crafting"), e -> {
		}).bounds(this.leftPos + 5, this.topPos + 6, 67, 20).build();
		guistate.put("button:button_crafting", button_crafting);
		this.addRenderableWidget(button_crafting);
		button_item = Button.builder(Component.translatable("gui.echocraft.uiguidebook.button_item"), e -> {
		}).bounds(this.leftPos + 5, this.topPos + 30, 46, 20).build();
		guistate.put("button:button_item", button_item);
		this.addRenderableWidget(button_item);
		button_tips = Button.builder(Component.translatable("gui.echocraft.uiguidebook.button_tips"), e -> {
		}).bounds(this.leftPos + 5, this.topPos + 54, 46, 20).build();
		guistate.put("button:button_tips", button_tips);
		this.addRenderableWidget(button_tips);
		button_credit = Button.builder(Component.translatable("gui.echocraft.uiguidebook.button_credit"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new UiguidebookButtonMessage(3, x, y, z));
				UiguidebookButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 140, 56, 20).build();
		guistate.put("button:button_credit", button_credit);
		this.addRenderableWidget(button_credit);
	}
}
