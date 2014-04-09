package de.nunoit.networking;

import de.nunoit.networking.protocol.packets.Connect;
import de.nunoit.networking.protocol.packets.ImageRequest;
import de.nunoit.networking.protocol.packets.ImageTask;
import de.nunoit.networking.protocol.packets.TaskCancel;

public abstract class AbstractPacketHandler {

	/**
	 * Handshake packet to identify a client with a UUID
	 */
	public void handle(Connect connect) {
	}

	/**
	 * Requests a new order from the server
	 */
	public void handle(ImageRequest request) {
	}

	/**
	 * Image the client should render
	 */
	public void handle(ImageTask task) {
	}

	/**
	 * Should be sent in case the client can´t complete the image
	 */
	public void handle(TaskCancel cancel) {
	}

}
