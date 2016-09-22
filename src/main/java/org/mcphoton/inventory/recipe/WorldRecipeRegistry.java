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
package org.mcphoton.inventory.recipe;

import java.util.List;

import org.mcphoton.item.ItemStack;

/**
 * @author DJmaxZPLAY
 */
public interface WorldRecipeRegistry {

	public void register(Recipe recipe);
	
	public boolean hasRecipe(ItemStack item);
	
	public List<Recipe> getRecipes(ItemStack item);
	
	public void unregister(Recipe recipe);
	
	public void unregisterForItemstack(ItemStack item);

}
