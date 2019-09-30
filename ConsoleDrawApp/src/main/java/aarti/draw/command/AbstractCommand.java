package aarti.draw.command;

import java.util.Arrays;
import java.util.List;

import aarti.draw.exception.InsufficientParametersException;

public abstract class AbstractCommand {

	public char[][] shape;
	public int height;
	public int width;

	public abstract String perform(List<String> parameters) throws InsufficientParametersException;

	public char[][] draw(int x1, int y1, int x2, int y2, char printKey) {
		try {
			//Vertical line
			if (x1 == x2) {
				for (int i = y1; i <= y2; i++) {
					shape[i][x1] = printKey;
				}
			} // horizonatal line 
			else if (y1 == y2) { 
				Arrays.fill(shape[y1], x1, x2+1, printKey);
			} 
		} catch (Exception e) {
			System.out.println(e);
		}
		return shape;
	}

	public StringBuilder convertShapeToString() {
		StringBuilder shapeAsString = new StringBuilder();

		for (int i = 0; i < shape.length; ++i) {
			for (int j = 0; j < shape[i].length; j++) {
				shapeAsString.append((shape[i][j]) == 0 ? " " : shape[i][j]);
			}
			shapeAsString.append("\n");
		}
		return shapeAsString;
	}

	public void validateLineAndRectangleCoordinates(int x1, int y1, int x2, int y2)
			throws InsufficientParametersException {
		if (x1 >= 0 && y1 >= 0 
				&& x2 >= 0 && y2 >= 0 
				&& x1 < width && y1 < height 
				&& x2 < width && y2 < height 
				&& x1 <= x2 && y1 <= y2) {
			return;
		}else 
			throw new InsufficientParametersException(
					"Points are beyond the canvas borders.");
	}

	public char[][] getShape() {
		return shape;
	}
	public void setShape(char[][] shape) {
		this.shape = shape;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
