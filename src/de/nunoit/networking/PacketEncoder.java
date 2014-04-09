package de.nunoit.networking;

import de.nunoit.networking.protocol.Packet;
import de.nunoit.networking.protocol.Protocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Packet p, ByteBuf out)
			throws Exception {
		out.writeInt(Protocol.getPacketId(p.getClass()));
		p.write(out);
	}
}
