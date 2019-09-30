package aarti.draw.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import aarti.draw.exception.InsufficientParametersException;

public class CanvasTest {
	@Test
	public void givenHeightWidthDrawCanvas() throws InsufficientParametersException {
		// Given
		Canvas canvas = new Canvas();
		List<String> parameters = new ArrayList<String>();
		parameters.add("6");
		parameters.add("5");
		char[][] expected = {{'-','-','-','-','-','-'},
				{'|', 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, '|'},
				{'|', 0, 0, 0, 0, '|'},
				{'-','-','-','-', '-','-'}};

		// When
		canvas.perform(parameters);

		// Then
		Assert.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(canvas.shape));
	}

	@Test (expected = InsufficientParametersException.class )
	public void givenIncorrectNumberOfParametersShouldThrowError() throws InsufficientParametersException {
		Canvas canvas = new Canvas();
		List<String> parameters = new ArrayList<String>();
		parameters.add("6");

		// When
		canvas.perform(parameters);

	}
}
