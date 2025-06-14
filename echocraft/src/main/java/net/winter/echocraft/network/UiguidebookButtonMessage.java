
package net.winter.echocraft.network;

import net.winter.echocraft.world.inventory.UiguidebookMenu;
import net.winter.echocraft.procedures.BookbuttoncreditwinterProcedure;
import net.winter.echocraft.EchocraftMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record UiguidebookButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<UiguidebookButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(EchocraftMod.MODID, "uiguidebook_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, UiguidebookButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, UiguidebookButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new UiguidebookButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<UiguidebookButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final UiguidebookButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = UiguidebookMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 3) {

			BookbuttoncreditwinterProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EchocraftMod.addNetworkMessage(UiguidebookButtonMessage.TYPE, UiguidebookButtonMessage.STREAM_CODEC, UiguidebookButtonMessage::handleData);
	}
}
