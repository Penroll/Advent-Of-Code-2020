package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Advent of Code 2020 Day 6
 *
 * @author Penroll
 */
public class AdventOfCode2020Day6 {
    /**
     * Letters of the alphabet :)
     */
    public static String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    /**
     * Finds the number of questions answered per group and the number of questions that everyone in the group
     * answered yes to
     * @param args command-line arguments (not used)
     * @throws IOException if the input file is not found
     */
    public static void main(String[] args) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("/Users/srgrealey/IdeaProjects/" +
                "AdventOfCode2020/src/Day6/DaySixInput")));
        String[] values = data.split("\n\n");
        int numAllAnswered = 0, numQuestionsAnswered = 0;
        for(String value : values){
            int[] count2 = new int[letters.length];
            String[] people = value.split("\n");
            for(String letter : letters)
                if (value.contains(letter))
                    value = value.replace(letter, "");
                    numQuestionsAnswered++;
            for(String person : people)
                IntStream.range(0, letters.length).filter(letter -> person.contains(letters[letter])).forEach(letter -> count2[letter]++);
            numAllAnswered += Arrays.stream(count2).filter(counts -> counts == people.length).count();
        }
        System.out.println("Answer For Part 1: " + numQuestionsAnswered);
        System.out.println("Answer For Part 2: " + numAllAnswered);
    }
}
