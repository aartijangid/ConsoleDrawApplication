package aarti.draw.shape;

import java.util.List;

import aarti.draw.command.AbstractCommand;
import aarti.draw.exception.InsufficientParametersException;

public class Quit extends AbstractCommand{

	@Override
	public String perform(List<String> params) throws InsufficientParametersException{
		Runtime.getRuntime().exit(0);
		return "EXIT";
	}

}
