package de.nunoit.networking;

import java.util.List;

import de.nunoit.networking.protocol.Packet;
import de.nunoit.networking.protocol.PacketWrapper;
import de.nunoit.networking.protocol.Protocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class PacketDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf,
			List<Object> out) throws Exception {
		if (buf.readableBytes() < 4) {
			return;
		}
		int packetID = buf.readInt();

		Packet packet = Protocol.createPacket(packetID);

		packet.read(buf);

		if (buf.readableBytes() != 0) {
			System.out.println("Did not read all bytes from packet "
					+ packet.getClass() + " " + packetID);
		}

		out.add(new PacketWrapper(packet, buf.copy()));
	}
}
