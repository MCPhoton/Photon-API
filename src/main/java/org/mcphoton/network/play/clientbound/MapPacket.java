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
package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author DJmaxZPL4Y
 */
public class MapPacket implements Packet {

	public int itemDamage, length;
	public byte scale, columns, rows, x, z;
	public boolean trackingPosition;
	public Icon[] icons;

	@Override
	public int getId() {
		return 0x24;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(itemDamage);
		out.writeByte(scale);
		out.writeBoolean(trackingPosition);
		out.writeVarInt(icons.length);
		for (Icon icon : icons) {
			out.writeByte(icon.getDirectionAndType());
			out.writeByte(icon.getX());
			out.writeByte(icon.getZ());
		}
		out.writeByte(columns);
		if (columns > 0) {
			out.writeByte(rows);
			out.writeByte(x);
			out.writeByte(z);
			out.writeVarInt(length);
			//TODO Write Data, see <http://minecraft.gamepedia.com/Map_item_format>
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		itemDamage = ProtocolHelper.readVarInt(buff);
		scale = buff.get();
		trackingPosition = ProtocolHelper.readBoolean(buff);
		icons = new Icon[ProtocolHelper.readVarInt(buff)];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = new Icon(buff.get(), buff.get(), buff.get());
		}
		columns = buff.get();
		if (columns > 0) {
			rows = buff.get();
			x = buff.get();
			z = buff.get();
			length = ProtocolHelper.readVarInt(buff);
			//TODO Read Data, see <http://minecraft.gamepedia.com/Map_item_format>
		}
		return this;
	}

	@Override
	public String toString() {
		return "MapPacket{" + "itemDamage=" + itemDamage + ", scale=" + scale + ", trackingPosition=" + trackingPosition + ", icons='" + Arrays.toString(icons) + "', columns=" + columns + "rows=" + rows + ", x=" + x + ", z=" + z + '}';
	}

	public class Icon {

		private byte directionAndType, x, z;

		public Icon(byte directionAndType, byte x, byte z) {
			this.directionAndType = directionAndType;
			this.x = x;
			this.z = z;
		}

		public byte getDirectionAndType() {
			return directionAndType;
		}

		public byte getX() {
			return x;
		}

		public byte getZ() {
			return z;
		}
	}
}
