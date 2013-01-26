package com.remscale.arrayprinter;

public class ArrayPrinterFactory {
	
	public ArrayPrinter create() {
		return new SpiralArrayPrinter();
	}

}
