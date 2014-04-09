package de.nunoit.networking.protocol.packets;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import de.nunoit.networking.PacketHandler;
import de.nunoit.networking.protocol.Packet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Connect extends Packet {

	private String uuid;

	@Override
	public void handle(PacketHandler handler) throws Exception {
		handler.handle(this);
	}

	@Override
	public void write(ByteBuf buf) {
		writeString(buf, uuid);
	}

	@Override
	public void read(ByteBuf buf) {
		uuid = readString(buf);
	}

}
