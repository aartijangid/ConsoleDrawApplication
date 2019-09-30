package aarti.draw.command;

import java.util.ArrayList;
import java.util.List;


public class CommandInput {

	private CommandType command;
	private List<String> parameters;

	public CommandInput(String input) {
		String token[] = input.split(" ");
		this.command = CommandType.get(token[0].toUpperCase());
		this.parameters = new ArrayList<String>();
		for (int i = 1; i < token.length; i++) {
			this.parameters.add(token[i]);
		}
	}	

	public CommandType getCommand() {
		return command;
	}
	public void setCommand(CommandType command) {
		this.command = command;
	}
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommandInput [command=").append(command)
		.append(", parameters=").append(parameters).append("]");
		return builder.toString();
	}
}
