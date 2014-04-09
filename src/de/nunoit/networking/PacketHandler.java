package de.nunoit.networking;

import de.nunoit.networking.protocol.Packet;
import io.netty.channel.Channel;

public abstract class PacketHandler extends AbstractPacketHandler
{

	public void handle(Packet packet) throws Exception
	{
	}

	public void connected(Channel ch) throws Exception
	{
	}

	public void disconnected(Channel ch) throws Exception
	{
	}
}
