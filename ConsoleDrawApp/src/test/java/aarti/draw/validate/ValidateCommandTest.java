package aarti.draw.validate;

import org.junit.Test;

import aarti.draw.command.CommandInput;
import aarti.draw.exception.InsufficientParametersException;

public class ValidateCommandTest {
	
	@Test (expected = InsufficientParametersException.class )
	public void givenInsufficientParametersShouldThrowInsufficientParameterException() throws InsufficientParametersException{
		CommandInput input = new CommandInput("C 20");
		
		ValidateCommand.validateInputCommandParameters(input);
	}
}
