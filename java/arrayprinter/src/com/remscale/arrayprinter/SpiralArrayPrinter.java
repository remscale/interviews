package com.remscale.arrayprinter;

import java.util.Iterator;

class SpiralArrayPrinter implements ArrayPrinter {

	@Override
	public void print(final char[][] array) {
		final Iterator<String> iterator = new SpiralIterator(array);
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
		}
	}
}