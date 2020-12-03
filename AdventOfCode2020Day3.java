package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Finds the number of trees that will be run into given a certain slope
 * Advent of Code Day 3
 *
 * @author Penroll
 */
public class AdventOfCode2020Day3 {

    /**
     * Number of characters in a line of the terrain
     */
    public static final int NUM_OF_CHARS = 31;

    /**
     * Number of lines that make up the terrain
     */
    public static final int NUM_OF_LINES = 323;

    /**
     * Gets the number of trees that would be hit given slopes of 1,3,5, or 7 to the right and 1 down,
     * and the slope of 1 to the right and 2 down, multiplied together
     * @param args command-line arguments (not used)
     * @throws FileNotFoundException if the Day 3 input file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("/Users/srgrealey/IdeaProjects/" +
                "AdventOfCode2020/src/Day3/DayThreeInput"));
        String[] values = getValues(input);
        System.out.println((long) getNumTrees(values,1) * getNumTrees(values, 3) *
                getNumTrees(values, 5) * getNumTrees(values, 7) * getNumTrees(values, 1, 2));
    }

    /**
     * Converts the input file into lines of String
     * @param input is the scanner of the input file
     * @return a String array, with each value consisting of one line in the file
     */
    public static String[] getValues(Scanner input){
        String[] values = new String[323];
        int i =0;
        while(input.hasNextLine()){
            values[i] = input.nextLine();
            i++;
        }
        return values;
    }

    /**
     * Gets the number of trees hit given a slope and a String array serving as the
     * terrain that will be navigated
     * @param values is the String array serving as the terrain
     * @param right is the rise of the slope (rise/run)
     * @param down is the run of the slope (rise/run)
     * @return the number of trees hit at a given slope
     */
    public static int getNumTrees(String[] values, int right, int down){
        int toTheRight = 0;
        int numTrees = 0;
        for (int i = 0; i < NUM_OF_LINES; i+=down) {
            if (toTheRight >= NUM_OF_CHARS) {
                toTheRight -= NUM_OF_CHARS;
            }
            if (values[i].charAt(toTheRight) == '#') {
                numTrees++;
            }
            toTheRight+= right;
        }
        return numTrees;
    }

    /**
     * Gets the number of trees hit given a slope and a String array serving as the
     * terrain that will be navigated (This is for a slope of down = 1)
     * @param values is the String array serving as the terrain
     * @param right is the number of units to the right for each unit down
     * @return the number of trees hit with a given slope
     */
    public static int getNumTrees(String[] values, int right){
        int toTheRight = 0;
        int numTrees = 0;
        for (String s : values) {
            for (int j = 0; j < right; j++) {
                if (toTheRight >= NUM_OF_CHARS) {
                    toTheRight -= NUM_OF_CHARS;
                }
                if (s.charAt(toTheRight) == '#') {
                    numTrees++;
                }
            }
            toTheRight += right;
        }
        numTrees /= right;
        return numTrees;
    }
}
