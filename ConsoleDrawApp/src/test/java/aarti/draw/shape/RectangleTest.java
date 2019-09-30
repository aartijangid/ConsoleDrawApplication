package aarti.draw.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import aarti.draw.exception.InsufficientParametersException;

public class RectangleTest {
	@Test
	public void givenRightTopAndBottomLeftCornerCoordinatesShouldDrawRectangle() throws InsufficientParametersException {
		// give
		Canvas canvas = new Canvas();
		List<String> canvasParameters = new ArrayList<String>();
		canvasParameters.add("12");
		canvasParameters.add("9");
		// coordinates to draw rectangle 
		Rectangle rectangle = new Rectangle();
		List<String> rectangleParameters = new ArrayList<String>();
		rectangleParameters.add("3");
		rectangleParameters.add("2");
		rectangleParameters.add("5");
		rectangleParameters.add("6");

		char[][] expected = {{'-','-','-','-','-','-','-','-','-','-','-','-'},
				{'|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 'x', 'x', 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 0, 'x', 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 0, 'x', 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 0, 'x', 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 'x', 'x', 'x', 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '|'},
				{'-','-','-','-','-','-','-','-','-','-','-','-'}};

		// when
		canvas.perform(canvasParameters);

		rectangle.shape = canvas.shape;
		rectangle.height = canvas.height;
		rectangle.width = canvas.width;
		rectangle.perform(rectangleParameters);

		// then
		Assert.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(canvas.shape));

	}

	@Test (expected = InsufficientParametersException.class )
	public void givenIncorrectNumberOfParametersForCoordinatesShouldThrowError() throws InsufficientParametersException {
		// give
		Canvas canvas = new Canvas();
		List<String> canvasParameters = new ArrayList<String>();
		canvasParameters.add("12");
		canvasParameters.add("9");
		// coordinates to draw rectangle
		Rectangle rectangle = new Rectangle();
		List<String> rectangleParameters = new ArrayList<String>();
		rectangleParameters.add("3");
		rectangleParameters.add("2");
		rectangleParameters.add("5");
		
		canvas.perform(canvasParameters);
		rectangle.shape = canvas.shape;
		rectangle.perform(rectangleParameters);
		
	}
}
