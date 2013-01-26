package com.remscale.arrayprinter;

public class ArrayPrinterMain {
	
	public static void main(final String[] args) {
		final char[][] array = {
				{ 'C', 'O', 'M', 'P' },
				{ 'Z', 'E', 'D', 'U' },
				{ 'I', 'R', 'E', 'T' },
		};
		
		final ArrayPrinterFactory factory = new ArrayPrinterFactory();
		final ArrayPrinter printer = factory.create();
		printer.print(array);
	}
}