package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */
public class AdventOfCode2020Day2 {

    public static void main(String[] args) throws FileNotFoundException {
        int count = 0;
        Scanner input = getInput();
        String[] values = getValues(input);

        for (String value : values) {
            if (isValid(value)) {
                count++;
            }
        }
        System.out.println(count);
    }
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
     * Determines if a password is valid
     * @param line is the line being tested
     * @return true if password is valid, otherwise false
     */
    public static boolean isValid(String line){


        int min = Integer.parseInt(line.substring(0,line.indexOf('-')));
        int max = Integer.parseInt(line.substring(line.indexOf('-')+1,line.indexOf(' ')));
        String letter = line.substring(line.indexOf(' ') + 1, line.indexOf(':'));
        String password = line.substring(line.indexOf(':') + 2);

        char[] chars = password.toCharArray(); //Changes password to char array

        //int count = 0;
        //for (char i : chars) if (Character.toString(i).equals(letter)) count++;
        //Code from part 1

        boolean first = Character.toString(chars[min - 1]).equals(letter);
        boolean last = Character.toString(chars[max - 1]).equals(letter);

        return (!first || !last) && (first || last);
    }

    /**
     * Gets Scanner input from the filename
     * @return Input Scanner
     * @throws FileNotFoundException if file is not found obv
     */
    public static Scanner getInput() throws FileNotFoundException {
        Scanner input;
        input = new Scanner(new File("/Users/srgrealey/IdeaProjects/AdventOfCode2020/src/Day2/DayOneInput.txt"));
        return input;
    }
}
