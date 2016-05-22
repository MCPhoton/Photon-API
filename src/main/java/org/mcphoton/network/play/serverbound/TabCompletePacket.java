/*
 * Copyright (c) 2016 MCPhoton <http://mcphoton.org> and contributors.
 *
 * This file is part of the Photon API <https://github.com/mcphoton/Photon-API>.
 *
 * The Photon API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Photon API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mcphoton.network.play.serverbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author DJmaxZPLAY
 */
public class TabCompletePacket implements Packet {

	public String text;
	public boolean assumeCommand, hasPosition;
	public int x, y, z;

	@Override
	public int getId() {
		return 0x01;
	}

	@Override
	public boolean isServerBound() {
		return true;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(text);
		out.writeBoolean(assumeCommand);
		out.writeBoolean(hasPosition);
		if (hasPosition) {
			out.writeLong(ProtocolHelper.encodePosition(x, y, z));
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		text = ProtocolHelper.readString(buff);
		assumeCommand = ProtocolHelper.readBoolean(buff);
		hasPosition = ProtocolHelper.readBoolean(buff);
		if (hasPosition) {
			long pos = buff.getLong();
			x = ProtocolHelper.decodePositionX(pos);
			y = ProtocolHelper.decodePositionX(pos);
			z = ProtocolHelper.decodePositionX(pos);
		}
		return this;
	}

	@Override
	public String toString() {
		return "TabCompletePacket{" + "text=" + text + ", assumeCommand=" + assumeCommand + ", hasPosition=" + hasPosition + ", x=" + x + ", y=" + y + ", z=" + z + '}';
	}
}