package aarti.draw.validate;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aarti.draw.command.CommandInput;
import aarti.draw.command.CommandType;
import aarti.draw.exception.InsufficientParametersException;
import aarti.draw.exception.InvalidInputException;

public class ValidateCommand {

	static final Map<String, Integer> parameterMap;

	static final Pattern pattern = Pattern
			.compile("[a-zA-Z]{1}(\\s\\d+)*(\\s[a-zA-z]{1})?+");

	static{
		parameterMap = new HashMap<String, Integer>();
		parameterMap.put("CANVAS", 2);
		parameterMap.put("LINE", 4);
		parameterMap.put("RECTANGLE", 4);
		parameterMap.put("BUCKET_FILL", 3);
		parameterMap.put("QUIT", 0);
		parameterMap.put("HELP", 0);
	}

	public static Boolean validateInputCommandParameters(CommandInput inputCommand) throws InsufficientParametersException {
		CommandType command = inputCommand.getCommand();

		if(parameterMap.containsKey(command.name()) && (parameterMap.get(command.name()) == inputCommand.getParameters().size())) {
			return true;
		} else {
			throw new InsufficientParametersException(
					"Canvas command requires " + parameterMap.get(command.name()) + " parameters, " 
							+ inputCommand.getParameters().size() + " params provided.");
		}
	}

	public static Boolean validateUserInputPattern(String userInput) throws InvalidInputException {
		Matcher patternMatcher = pattern.matcher(userInput);
		if(patternMatcher.matches()) {
			return true;
		}else 
			throw new InvalidInputException("Command input is not valid.");
	}
}
