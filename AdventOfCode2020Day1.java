package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventOfCode2020Day1 {

    public static boolean isMultiplied(int one, int two, int three){
        return one + two + three == 2020;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("/Users/srgrealey/IdeaProjects/AdventOfCode2020/src/Day1/DayOneInput"));
        int value = -1;
        int[] values = getValues(input);
        for (int i : values)
            for (int j : values)
                for (int k : values)
                    if (isMultiplied(i, j, k)) value = i * j * k;
        System.out.println(value);
    }
    public static int[] getValues(Scanner input){
        int[] values = new int[200];
        int i =0;
        while(input.hasNextInt()){
            values[i] = input.nextInt();
            i++;
        }
        return values;
    }
}
