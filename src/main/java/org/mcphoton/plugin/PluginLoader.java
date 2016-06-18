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
package org.mcphoton.plugin;

import java.io.File;
import java.util.List;

/**
 * A PluginLoader loads and unloads a specific type of plugins.
 *
 * @author TheElectronWill
 *
 * @param <T> the type of plugins this PluginLoader deals with
 */
public interface PluginLoader<T extends Plugin> {

	/**
	 * Loads a single plugin from a file. If its dependancies are not satisfied, an exception is thrown.
	 */
	T loadPlugin(File file) throws PluginLoadingException;

	/**
	 * Loads all the plugins from the specified files. The load order is calculated so that all dependancies
	 * (if possible) are resolved.
	 */
	List<T> loadPlugins(File[] files);

	/**
	 * Unloads a plugin previously loaded by this PluginLoader.
	 */
	void unloadPlugin(T plugin);

}
