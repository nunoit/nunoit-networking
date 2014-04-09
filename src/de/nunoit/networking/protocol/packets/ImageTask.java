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
public class ImageTask extends Packet {

	private int taskId, posX, posY, zoom, resX, resY;

	@Override
	public void handle(PacketHandler handler) throws Exception {
		handler.handle(this);
	}

	@Override
	public void write(ByteBuf buf) {
		buf.writeInt(taskId);
		buf.writeInt(posX);
		buf.writeInt(posY);
		buf.writeInt(zoom);
		buf.writeInt(resX);
		buf.writeInt(resY);
	}

	@Override
	public void read(ByteBuf buf) {
		taskId = buf.readInt();
		posX = buf.readInt();
		posY = buf.readInt();
		zoom = buf.readInt();
		resX = buf.readInt();
		resY = buf.readInt();
	}

}
