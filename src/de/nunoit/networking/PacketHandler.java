package de.nunoit.networking;

import de.nunoit.networking.protocol.Packet;

public abstract class PacketHandler extends AbstractPacketHandler {

	public void handle(Packet packet) throws Exception {
	}

	public void connected() throws Exception {
	}

	public void disconnected() throws Exception {
	}
}
