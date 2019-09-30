package aarti.draw.command;

import java.util.HashMap;
import java.util.Map;


public enum CommandType {

	CANVAS("C"), LINE("L"), RECTANGLE("R"), BUCKET_FILL("B"), QUIT("Q"), HELP("H");

	private static final Map<String, CommandType> commandMap = new HashMap<String, CommandType>();

	static {
		for (CommandType command : CommandType.values()) {
			commandMap.put(command.commandChar, command);
		}
	}

	private final String commandChar;

	private CommandType(String commandChar) {
		this.commandChar = commandChar;
	}

	public static CommandType get(String commandChar) {
		return commandMap.get(commandChar);
	}

}
