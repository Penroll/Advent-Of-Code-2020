package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Determines if a password is valid or not based on given criteria
 * For Advent Of Code 2020 Day 2
 *
 * @author Penroll
 */
public class AdventOfCode2020Day2 {

    /**
     * Determines the number of passwords that are valid  within the input file
     * @param args command line arguments (not used)
     * @throws FileNotFoundException if there is no input file found
     */
    public static void main(String[] args) throws FileNotFoundException {
        int count = 0;
        Scanner input = new Scanner(new File("/Users/srgrealey/IdeaProjects/AdventOfCode2020/src/Day2/DayTwoInput"));
        String[] values = getValues(input);

        for (String value : values){
            if (isValid(value)){
                count++;
            }
        }
        System.out.println("Part 1 Answer: " + count);

        count = 0;
        for (String value : values) {
            if (isValid2(value)) {
                count++;
            }
        }
        System.out.println("Part 2 Answer: " + count);
    }

    /**
     * Gets an array of Strings, each being a set of data pertaining to a password
     * @param input is the scanner of the input file
     * @return an array of password data in String format
     */
    public static String[] getValues(Scanner input){
        String[] values = new String[1000];
        int i =0;
        while(input.hasNextLine()){
            values[i] = input.nextLine();
            i++;
        }
        return values;
    }

    /**
     * Determines if a password is valid (part two parameters)
     * @param line is the line being tested
     * @return true if password is valid, otherwise false
     */
    public static boolean isValid2(String line){
        int min = Integer.parseInt(line.substring(0,line.indexOf('-')));
        int max = Integer.parseInt(line.substring(line.indexOf('-')+1,line.indexOf(' ')));
        String letter = line.substring(line.indexOf(' ') + 1, line.indexOf(':'));
        String password = line.substring(line.indexOf(':') + 2);
        char[] chars = password.toCharArray(); //Changes password to char array

        boolean first = Character.toString(chars[min - 1]).equals(letter);
        boolean last = Character.toString(chars[max - 1]).equals(letter);

        return (!first || !last) && (first || last);
    }

    /**
     * Determines if a password is valid (part one parameters)
     * @param line is the line being tested
     * @return true if password is valid, otherwise false
     */
    public static boolean isValid(String line){
        int min = Integer.parseInt(line.substring(0,line.indexOf('-')));
        int max = Integer.parseInt(line.substring(line.indexOf('-')+1,line.indexOf(' ')));
        String letter = line.substring(line.indexOf(' ') + 1, line.indexOf(':'));
        String password = line.substring(line.indexOf(':') + 2);
        char[] chars = password.toCharArray(); //Changes password to char array
        int count = 0;

        for (char i : chars) if (Character.toString(i).equals(letter)) count++;

        return count <= max && count >= min;
    }
}
