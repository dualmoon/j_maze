package MazeGenerator.Types;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.valueOf;

public class Maze {
    private final Random random;
    public int[] startPoint;
    public Grid grid;
    private static final ThreadLocal<Random> RANDOM_THREAD_LOCAL = ThreadLocal.withInitial(Random::new);

    public Maze(Grid grid) {
        this(grid, valueOf(Math.random()));
    }

    public Maze(Grid grid, String seed) {
        this.grid = grid;
        this.random = rand(seed);
    }

    public ArrayList<String> getStrArray(){
        ArrayList<String> strArray = new ArrayList<>();
        for(int i = 0; i < grid.height; i++) {
            String line = "";
            line += String.join("", Collections.nCopies(grid.width, "x"));
            strArray.add(line);
        }
        return strArray;
    }

    private int[] getRandXY(int width, int height) {
        int randomX = ThreadLocalRandom.current().nextInt(0, width);
        int randomY = ThreadLocalRandom.current().nextInt(0, height);
        return new int[]{randomX, randomY};
    }

    public void generateSimpleStartPoint() {
        int[] randoms = getRandXY(grid.width, grid.height);
        startPoint = new int[]{randoms[0], randoms[1]};
    }

    public static Random rand(String seed) {
        Random random = RANDOM_THREAD_LOCAL.get();
        random.setSeed(seed.hashCode());
        return random;
    }

    @Override
    public String toString() {
        return String.format("Maze{\n\t\tGrid{\n\t\t\twidth: %s\n\t\t\theight: %s\n\t\t}", grid.width, grid.height);
    }
}
