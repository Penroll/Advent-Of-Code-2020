package Day1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventOfCode2020Day1 {

    public static boolean isMultiplied(int one, int two, int three){
        if(one + two + three == 2020){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);
        Scanner input = getInput(scnr);
        int value = -1;
        int[] values = getValues(input);
        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values.length; j++){
                for(int k = 0; k < values.length; k++){
                    if(isMultiplied(values[i],values[j],values[k])){
                        value = values[i]*values[j]*values[k];
                    }
                }


            }
        }
        System.out.println(value);
    }

    public static Scanner getInput(Scanner scnr) throws FileNotFoundException {
        Scanner input = null;
        input = new Scanner(new File("/Users/srgrealey/IdeaProjects/AdventOfCode2020/src/Day1/DayOneInput"));
        return input;
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
