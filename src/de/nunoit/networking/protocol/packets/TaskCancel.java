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
public class TaskCancel extends Packet {

	private int taskId;

	@Override
	public void handle(PacketHandler handler) throws Exception {
		handler.handle(this);
	}

	@Override
	public void write(ByteBuf buf) {
		buf.writeInt(taskId);
	}

	@Override
	public void read(ByteBuf buf) {
		taskId = buf.readInt();
	}

}
