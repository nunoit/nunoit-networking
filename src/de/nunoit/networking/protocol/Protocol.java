package de.nunoit.networking.protocol;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.nunoit.networking.protocol.packets.Connect;
import de.nunoit.networking.protocol.packets.ImageRequest;
import de.nunoit.networking.protocol.packets.ImageTask;
import de.nunoit.networking.protocol.packets.TaskCancel;

public class Protocol {

	public static int PROTOCOL_VERSION = 1;

	private static Map<Integer, Class<? extends Packet>> packets = new HashMap<>();

	public static void init() {
		packets.put(0, Connect.class);
		packets.put(1, ImageRequest.class);
		packets.put(2, ImageTask.class);
		packets.put(3, TaskCancel.class);
	}

	public static Packet createPacket(int id) {
		try {
			return packets.get(id).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// Impossible
		}
		return null;
	}

	public static int getPacketId(Class<? extends Packet> c) {
		for (Entry<Integer, Class<? extends Packet>> e : packets.entrySet()) {
			if (e.getValue().equals(c)) {
				return e.getKey();
			}
		}
		System.err.println("Unknown Packet ID requested! " + c.getName());
		return -1;
	}
}
