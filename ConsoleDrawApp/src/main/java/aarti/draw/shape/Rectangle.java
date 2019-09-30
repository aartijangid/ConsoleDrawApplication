package aarti.draw.shape;

import java.util.List;

import aarti.draw.command.AbstractCommand;
import aarti.draw.exception.InsufficientParametersException;


public class Rectangle extends AbstractCommand{

	@Override
	public String perform(List<String> parameters) throws InsufficientParametersException{

		if (parameters.size() < 4) {
			throw new InsufficientParametersException(
					"Line command requires 4 parameters, " + parameters.size() + " params provided.");
		}

		int x1 = Integer.parseInt(parameters.get(0));
		int y1 = Integer.parseInt(parameters.get(1));
		int x2 = Integer.parseInt(parameters.get(2));
		int y2 = Integer.parseInt(parameters.get(3));

		validateLineAndRectangleCoordinates(x1, y1, x2, y2);

		draw(x1, y1, x2, y1, 'x');
		draw(x1, y1, x1, y2, 'x');
		draw(x2, y1, x2, y2, 'x');
		draw(x1, y2, x2, y2, 'x');

		StringBuilder shapeAsString = convertShapeToString();

		// Display rectangle
		System.out.println(shapeAsString);

		return shapeAsString.toString();
	}

}
