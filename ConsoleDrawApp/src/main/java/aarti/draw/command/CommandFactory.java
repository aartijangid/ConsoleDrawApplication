package aarti.draw.command;

import aarti.draw.shape.BucketFill;
import aarti.draw.shape.Canvas;
import aarti.draw.shape.Help;
import aarti.draw.shape.Line;
import aarti.draw.shape.Quit;
import aarti.draw.shape.Rectangle;

public class CommandFactory {
	public AbstractCommand getCommand(CommandInput input) {
		switch (input.getCommand()) {
		case CANVAS:
			return new Canvas();
		case LINE:
			return new Line();
		case RECTANGLE:
			return new Rectangle();
		case BUCKET_FILL:
			return new BucketFill();
		case QUIT:
			return new Quit();
		case HELP:
			return new Help();
		default:
			return null;
		}

	}
}