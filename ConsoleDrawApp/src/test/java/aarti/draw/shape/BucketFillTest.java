package aarti.draw.shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import aarti.draw.exception.InsufficientParametersException;

public class BucketFillTest {
	@Test
	public void givenPointCoordinatesAndAElementShouldFillTheCanvas() throws InsufficientParametersException {
		
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
			
			// coordinates to fill the canvas
			BucketFill bucketFill = new BucketFill();
			List<String> bucketFillParameters = new ArrayList<String>();
			bucketFillParameters.add("2");
			bucketFillParameters.add("1");
			bucketFillParameters.add("o");

			char[][] expected = {{'-','-','-','-','-','-','-','-','-','-','-','-'},
					{'|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
					{'|', 'o', 'o', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', '|'},
					{'|', 'o', 'o', 'x', 0, 'x', 'o', 'o', 'o', 'o', 'o', '|'},
					{'|', 'o', 'o', 'x', 0, 'x', 'o', 'o', 'o', 'o', 'o', '|'},
					{'|', 'o', 'o', 'x', 0, 'x', 'o', 'o', 'o', 'o', 'o', '|'},
					{'|', 'o', 'o', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', '|'},
					{'|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
					{'|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
					{'|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|'},
					{'-','-','-','-','-','-','-','-','-','-','-','-'}};

			// when
			
			canvas.perform(canvasParameters);

			rectangle.shape = canvas.shape;
			rectangle.height = canvas.height;
			rectangle.width = canvas.width;
			rectangle.perform(rectangleParameters);

			bucketFill.height = canvas.height;
			bucketFill.width = canvas.width;
			bucketFill.shape = rectangle.shape;
			bucketFill.perform(bucketFillParameters);
			
			// then
			Assert.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(bucketFill.shape));
	}
}
