/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2018 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.tiles.machine.tier3;

import net.minecraft.item.ItemStack;
import techreborn.init.TRTileEntities;

public class TileCreativeQuantumChest extends TileQuantumChest {

	public TileCreativeQuantumChest() {
		super(TRTileEntities.CREATIVE_QUANTUM_CHEST);
	}

	@Override
	public void tick() {
		super.tick();
		ItemStack stack = inventory.getInvStack(1);
		if (!stack.isEmpty() && storedItem.isEmpty()) {
			stack.setAmount(stack.getMaxAmount());
			storedItem = stack.copy();
		}

		storedItem.setAmount(maxCapacity - storedItem.getMaxAmount());
	}

	@Override
	public int slotTransferSpeed() {
		return 1;
	}
}