/*
 * Copyright (C) 2004-2015 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.network.serverpackets.adenadistribution;

import com.l2jserver.gameserver.network.serverpackets.L2GameServerPacket;

/**
 * @author Erlandys
 */
public class ExDivideAdenaDone extends L2GameServerPacket
{
	private final int _friendsCount;
	private final long _count;
	private final long _dividedCount;
	private final String _name;
	
	public ExDivideAdenaDone(int friendsCount, long count, long dividedCount, String name)
	{
		_friendsCount = friendsCount;
		_count = count;
		_dividedCount = dividedCount;
		_name = name;
	}
	
	@Override
	protected final void writeImpl()
	{
		writeC(0xFE);
		writeH(0x15D);
		writeC(0x01); // Always 1
		writeC(0x00); // Always 0
		writeD(_friendsCount); // Friends count
		writeQ(_dividedCount); // Divided count
		writeQ(_count); // Whole count
		writeS(_name); // Giver name
	}
}
