package MazeGenerator;
// hewwo owo

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import MazeGenerator.Types.*;

@Command(name="MazeGenerator", mixinStandardHelpOptions = true, description = "Generates a maze", version = "0.0a1")
public class MazeGenerator implements Callable<Integer> {

    @Parameters(description = "Maze width", index = "0")
    static int widthParam;
    @Parameters(description = "Maze height", index = "1")
    static int heightParam;
    @Parameters(description = "Maze seed", index = "2", arity = "0..1")
    static String seedParam;

    @Override
    public Integer call() {
        Grid outGrid = new Grid(widthParam, heightParam);
        Maze maze;
        if (seedParam != null) {
            maze = new Maze(outGrid, seedParam);
        } else {
            maze = new Maze(outGrid);
        }
        for (String line : maze.getStrArray()) {
            System.out.println(line);
        }
        maze.generateSimpleStartPoint();
        System.out.printf("Maze start point is %s%n", Arrays.toString(maze.startPoint));
        return 0;
    };

    public static void main(String... args) {
        int exitCode = new CommandLine(new MazeGenerator()).execute(args);
        System.exit(exitCode);
    }
}
