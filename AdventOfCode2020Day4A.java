package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Finds the number of valid passports for part A of Day 4
 *
 * @author Penroll
 */
public class AdventOfCode2020Day4A {

    /**
     * Find number of valid passports
     * @param args command-line arguments (not used)
     * @throws IOException if the input file is not found
     */
    public static void main(String[] args) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("/Users/srgrealey/IdeaProjects/AdventOfCode2020/src/Day4/DayFourInput")));
        String[] inputs = data.split("\n\n");
        int count = 0;
        for(String input : inputs){
            if(isValidPassport(input)){
                count++;
            }
        }
        System.out.println("Number of valid passports: " + count);

    }

    /**
     * Determines if a passport is valid
     * @param value is the information given from a passport
     * @return true if valid, otherwise false
     */
    public static boolean isValidPassport (String value){
        return value.contains("byr") && value.contains("iyr") && value.contains("eyr") && value.contains("hgt")
                && value.contains("hcl") && value.contains("ecl") && value.contains("pid");
    }
}
