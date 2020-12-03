package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Finds three integers that add to 2020 from a list of integers in a seperate file,
 * then finds the product of those three
 *
 * @author Penroll
 */
public class AdventOfCode2020Day1 {

    /**
     * Searches through an array of values to find three values that add to 2020,
     * and finds the product of the three
     * @param args command-line arguments (not used)
     * @throws FileNotFoundException if there is no file named "DayOneInput"
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("/Users/srgrealey/IdeaProjects/AdventOfCode2020/src/Day1/DayOneInput"));
        int[] values = getValues(input);
        int value = -1;
        for (int  i : values)
            for (int j : values)
                if (i + j == 2020) value = i * j;
        System.out.println("Part One Value: " + value);
        for (int i : values)
            for (int j : values)
                for (int k : values)
                    if (i + j + k == 2020) value = i * j * k;
        System.out.println("Part Two Value: " + value);
    }

    /**
     * Turns input file into an array of integers
     * @param input is the scanner that reads the file line by line
     * @return array of integers from the file
     */
    public static int[] getValues(Scanner input){
        int[] values = new int[200];
        int i = 0;
        while(input.hasNextInt()) {
            values[i] = input.nextInt();
            i++;
        }
        return values;
    }
}
