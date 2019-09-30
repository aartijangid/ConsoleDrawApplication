package aarti.draw.console;

import java.util.Scanner;

import aarti.draw.command.AbstractCommand;
import aarti.draw.command.CommandFactory;
import aarti.draw.command.CommandInput;
import aarti.draw.command.CommandType;
import aarti.draw.exception.InsufficientParametersException;
import aarti.draw.exception.InvalidInputException;
import aarti.draw.validate.ValidateCommand;

public class App 
{
	private AbstractCommand command;
	private Boolean isCanvasExist = false;

	public static void main( String[] args )
	{
		App newApp = new App();
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.print("Enter command: ");
				newApp.executeCommand(scanner.nextLine());
			}
		} 
	}

	private void executeCommand(String userInput){
		// validate command input
		try {
			if(ValidateCommand.validateUserInputPattern(userInput) == true) {

				CommandInput commandInput = new CommandInput(userInput);

				if(commandInput.getCommand().equals(CommandType.CANVAS))
					isCanvasExist = true;

				if(isCanvasExist == true || commandInput.getCommand().equals(CommandType.HELP) 
						|| commandInput.getCommand().equals(CommandType.QUIT)) {
					if(ValidateCommand.validateInputCommandParameters(commandInput)== true){

						CommandFactory commandFactory = new CommandFactory();
						if(command != null) 
							updateAbstractCommand(commandInput);
						else 
							command = commandFactory.getCommand(commandInput);

						command.perform(commandInput.getParameters());
					}
				} else {
					System.out.println("Please draw canvas first.");
				}
			}
		} catch (InsufficientParametersException e) {
			System.out.println(e.getMessage());
			System.out.println("Need help for command Input? Type H");
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
			System.out.println("Need help for command Input? Type H");
		}
	}

	private void updateAbstractCommand(CommandInput commandInput) {
		CommandFactory commandFactory = new CommandFactory();
		AbstractCommand updatedCommand = commandFactory.getCommand(commandInput);

		if (this.command != null) {
			updatedCommand.setShape(this.command.getShape());
			updatedCommand.setHeight(this.command.getHeight());
			updatedCommand.setWidth(this.command.getWidth());
		}
		this.command = updatedCommand;

	}
}
