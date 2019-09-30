package aarti.draw.command;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import aarti.draw.shape.BucketFill;
import aarti.draw.shape.Canvas;
import aarti.draw.shape.Help;
import aarti.draw.shape.Line;
import aarti.draw.shape.Quit;
import aarti.draw.shape.Rectangle;

public class CommandFactoryTest {
	@Test
	public void testGetCanvasCommand() {
		CommandFactory commandFactory = new CommandFactory();
		CommandInput input = new CommandInput("C 20 10");
		AbstractCommand shape = commandFactory.getCommand(input);

		assertTrue(shape instanceof Canvas);
	}

	@Test
	public void testGetLineCommand() {
		CommandFactory commandFactory = new CommandFactory();
		CommandInput input = new CommandInput("L 1 2 6 2");
		AbstractCommand command = commandFactory.getCommand(input);

		assertTrue(command instanceof Line);
	}

	@Test
	public void testGetRectangleCommand() {
		CommandFactory commandFactory = new CommandFactory();
		CommandInput input = new CommandInput("R 16 1 20 3");
		AbstractCommand command = commandFactory.getCommand(input);

		assertTrue(command instanceof Rectangle);
	}

	@Test
	public void testBucketFillCommand() {
		CommandFactory commandFactory = new CommandFactory();
		CommandInput input = new CommandInput("B 2 5 o");
		AbstractCommand command = commandFactory.getCommand(input);

		assertTrue(command instanceof BucketFill);
	}

	@Test
	public void testQuitCommand() {
		CommandFactory commandFactory = new CommandFactory();
		CommandInput input = new CommandInput("Q");
		AbstractCommand command = commandFactory.getCommand(input);

		assertTrue(command instanceof Quit);
	}

	@Test
	public void testHelpCommand() {
		CommandFactory commandFactory = new CommandFactory();
		CommandInput input = new CommandInput("H");
		AbstractCommand command = commandFactory.getCommand(input);

		assertTrue(command instanceof Help);
	}
}
