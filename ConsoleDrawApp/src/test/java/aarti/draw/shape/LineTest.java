package aarti.draw.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import aarti.draw.exception.InsufficientParametersException;

public class LineTest {
	@Test
	public void givenPointsShouldDrawHorizontalLine() throws InsufficientParametersException {
		// give
		Canvas canvas = new Canvas();
		List<String> canvasParameters = new ArrayList<String>();
		canvasParameters.add("6");
		canvasParameters.add("5");
		// coordinates to draw horizontal line 
		Line line = new Line();
		List<String> lineParameters = new ArrayList<String>();
		lineParameters.add("1");
		lineParameters.add("2");
		lineParameters.add("4");
		lineParameters.add("2");

		char[][] expected = {{'-','-','-','-','-','-'},
				{'|', 0, 0, 0, 0, '|'},
				{'|', 'x', 'x', 'x', 'x', '|'},
				{'|', 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, '|'},
				{'-','-','-','-', '-','-'}};

		// when
		canvas.perform(canvasParameters);
		
		line.shape = canvas.shape;
		line.height = canvas.height;
		line.width = canvas.width;
		line.perform(lineParameters);

		// then
		Assert.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(canvas.shape));
	}

	@Test
	public void givenPointsShouldDrawVerticalLine() throws InsufficientParametersException {
		// give
		Canvas canvas = new Canvas();
		List<String> canvasParameters = new ArrayList<String>();
		canvasParameters.add("12");
		canvasParameters.add("9");
		// coordinates to draw vertical line 
		Line line = new Line();
		List<String> lineParameters = new ArrayList<String>();
		lineParameters.add("3");
		lineParameters.add("2");
		lineParameters.add("3");
		lineParameters.add("6");

		char[][] expected = {{'-','-','-','-','-','-','-','-','-','-','-','-'},
				{'|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|'},
				{'-','-','-','-','-','-','-','-','-','-','-','-'}};

		// when
		canvas.perform(canvasParameters);
		
		line.shape = canvas.shape;
		line.height = canvas.height;
		line.width = canvas.width;
		line.perform(lineParameters);

		// then
		Assert.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(canvas.shape));
	}

	@Test (expected = InsufficientParametersException.class )
	public void givenIncorrectNumberOfParametersShouldThrowError() throws InsufficientParametersException {
		// give
		Canvas canvas = new Canvas();
		List<String> canvasParameters = new ArrayList<String>();
		canvasParameters.add("12");
		canvasParameters.add("9");
		// coordinates to draw horizontal line 
		Line line = new Line();
		List<String> lineParameters = new ArrayList<String>();
		lineParameters.add("3");
		lineParameters.add("2");
		lineParameters.add("3");

		// when
		canvas.perform(canvasParameters);
		line.shape = canvas.shape;
		line.perform(lineParameters);

	}
}
