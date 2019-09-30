package aarti.draw.shape;

import java.util.List;

import aarti.draw.command.AbstractCommand;
import aarti.draw.exception.InsufficientParametersException;


public class Canvas extends AbstractCommand{

	@Override
	public String perform(List<String> parameters) throws InsufficientParametersException {

		if (parameters.size() < 2) {
			throw new InsufficientParametersException(
					"Canvas command requires 2 parameters, " + parameters.size() + " params provided.");
		}

		width = Integer.parseInt(parameters.get(0));
		height = Integer.parseInt(parameters.get(1));

		shape = new char [height+2][width];

		draw(0, 0, width - 1, 0, '-');
		draw(0, 1, 0, height + 1, '|');
		draw(width - 1, 1, width - 1, height + 1, '|');
		draw(0, height + 1, width - 1, height + 1, '-');


		StringBuilder shapeAsString = convertShapeToString();

		// Display canvas
		System.out.println(shapeAsString);

		return shapeAsString.toString();
	}

}
