package aarti.draw.shape;

import java.util.List;

import aarti.draw.command.AbstractCommand;
import aarti.draw.exception.InsufficientParametersException;

public class BucketFill extends AbstractCommand{
	char keyChar;

	@Override
	public String perform(List<String> parameters) throws InsufficientParametersException {
		int x = Integer.parseInt(parameters.get(0));
		int y = Integer.parseInt(parameters.get(1));
		keyChar = parameters.get(2).charAt(0);

		String shapeAsString = fillEmptySpaceInCanvas(x, y);

		System.out.println(shapeAsString);

		return shapeAsString.toString();
	}

	private String fillEmptySpaceInCanvas(int x, int y) throws InsufficientParametersException {

		if (shape[y][x] != 0) { return ""; }

		if (x > 0 || x < height || y > 0 || y < width) {
			if (shape[y][x] == 0)
				shape[y][x] = keyChar;

			fillEmptySpaceInCanvas(x + 1, y);
			fillEmptySpaceInCanvas(x - 1, y);
			fillEmptySpaceInCanvas(x, y - 1);
			fillEmptySpaceInCanvas(x, y + 1);
		} else 
			throw new InsufficientParametersException(
					"Points are beyond the canvas borders.");

		StringBuilder shapeAsString = convertShapeToString();

		return shapeAsString.toString();
	}

}
