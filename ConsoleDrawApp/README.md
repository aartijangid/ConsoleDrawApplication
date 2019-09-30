# Console Drawing Application
Is a simple drawing program. It works as follow:

1. create a new canvas
2. start drawing on the canvas by issuing various commands 
3. quit

# How to install?
1. Make sure you have [java 8(or higher version)](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed on your systems
2. Clean and Install
	`./mvnw clean install`

## How to execute?
	`java -jar target/console-0.0.1-SNAPSHOT.jar`

## Usage example

```bash
➜  ConsoleDrawApp git:(ConsoleApp) ✗ java -jar target/console-0.0.1-SNAPSHOT.jar 
Enter command: h
Follow below steps:
1. Create a new canvas 
2. Draw on the canvas by issuing various commands 
3. Quit 


--------------------------------------------------------------------------------------------------|
|Command 	  | Description                                                                   |
--------------------------------------------------------------------------------------------------|
|C w h          | Create a new canvas of width w and height h.                                    |
|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only                        |
|               | horizontal or vertical lines are supported. Horizontal and vertical lines       |
|               | will be drawn using the 'x' character.                                          |
|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and                         |
|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn      |
|               | using the 'x' character.                                                        |
|B x y c        | Fill the entire area connected to (x,y) with "colour" c. The                    |
|               | behaviour of this is the same as that of the "bucket fill" tool in paint        |
|               | programs.                                                                       |
|Q              | Quit                                                                            |
|H              | Help                                                                            |
--------------------------------------------------------------------------------------------------
```
## How to run tests?
1. Ensure to go through "How to install?"
2. Run test with Maven
	`./mvnw clean test` 

## Approach
Test Driven Development(TDD)

## Good to have
Should have slanting lines as well.

## Edge case
Given Line command with coordinates of slanting line will not do anything. 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

