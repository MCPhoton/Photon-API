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
package org.mcphoton.event;

import org.mcphoton.plugin.Plugin;

public interface EventsManager {

	void registerAll(Object listener);

	<E extends Event> void register(Class<E> eventClass, EventHandler<? super E> eventHandler, ListenOrder listenOrder);

	<E extends Event> void unregister(Class<E> eventClass, EventHandler<? super E> eventHandler, ListenOrder listenOrder);

	void unregisterAll(Plugin plugin);

	void post(Event event);

}
