package com.git.clownvin.dsapi.packet;

import com.git.clownvin.simplepacketframework.packet.Packet;

public class RemoveCharacterPacket extends Packet {
	private int id;
	
	public RemoveCharacterPacket(int id) {
		this(false, toBytes(id), -1);
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public RemoveCharacterPacket(boolean construct, byte[] bytes, int length) {
		super(construct, bytes, length);
		// TODO Auto-generated constructor stub
	}
	
	private static byte[] toBytes(int id) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) ((id >> 24) & 0xFF);
		bytes[1] = (byte) ((id >> 16) & 0xFF);
		bytes[2] = (byte) ((id >> 8) & 0xFF);
		bytes[3] = (byte) (id & 0xFF);
		return bytes;
	}

	@Override
	protected void construct(byte[] bytes, int length) {
		id = ((bytes[0] & 0xFF) << 24) | ((bytes[1] & 0xFF) << 16) | ((bytes[2] & 0xFF) << 8) | (bytes[3] & 0xFF);
	}

	@Override
	public boolean shouldEncrypt() {
		// TODO Auto-generated method stub
		return false;
	}

}
