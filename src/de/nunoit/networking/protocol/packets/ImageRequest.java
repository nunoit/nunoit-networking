package de.nunoit.networking.protocol.packets;

import io.netty.buffer.ByteBuf;
import de.nunoit.networking.PacketHandler;
import de.nunoit.networking.protocol.Packet;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ImageRequest extends Packet {

	@Override
	public void handle(PacketHandler handler) throws Exception {
		handler.handle(this);
	}

	@Override
	public void write(ByteBuf buf) {
	}

	@Override
	public void read(ByteBuf buf) {
	}

}
