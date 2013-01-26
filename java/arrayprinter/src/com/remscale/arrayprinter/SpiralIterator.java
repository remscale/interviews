package com.remscale.arrayprinter;

import java.util.Iterator;

class SpiralIterator implements Iterator<String> {

	private char[][] array;
	private int startCol;
	private int startRow;
	private int endCol;
	private int endRow;
	
	private int remainingChars;
	
	private SpiralDirection direction;

	public SpiralIterator(final char[][] array) {
		if (null == array) {
			throw new IllegalArgumentException("Input array must not be null");
		}
		
		this.array = array;
		
		startCol = 0;
		startRow = 0;
		endCol = array[startRow].length - 1;
		endRow = array.length - 1;
		
		remainingChars = array[startRow].length * array.length;
		direction = SpiralDirection.Right;
	}
	
	@Override
	public boolean hasNext() {
		return remainingChars > 0;
	}

	@Override
	public String next() {
		if (remainingChars <= 0) {
			throw new IllegalStateException("No remaining chars to return");
		}
		
		final StringBuilder builder = new StringBuilder();
		
		switch (direction) {
		case Down:
			for (int i = startRow; i <= endRow; i++) {
				builder.append(array[i][endCol]);
			}
			
			direction = SpiralDirection.Left;
			endCol--;
			
			
			break;
		case Right:
			
			for (int i = startCol; i <= endCol; i++) {
				builder.append(array[startRow][i]);
			}
			
			direction = SpiralDirection.Down;
			startRow++;
			
			
			break;
		case Left:
			
			for (int i = endCol; i >= startCol; i--) {
				builder.append(array[endRow][i]);
			}
			
			direction = SpiralDirection.Up;
			endRow--;
			
			break;
		case Up:
			
			for (int i = endRow; i >= startRow; i--) {
				builder.append(array[i][startCol]);
			}
			
			direction = SpiralDirection.Right;
			startCol++;
			
			break;
		default:
			throw new IllegalStateException("Unknown spiral direction specified");
		}
		final String chars = builder.toString();
		remainingChars -= chars.length();
		return chars;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
