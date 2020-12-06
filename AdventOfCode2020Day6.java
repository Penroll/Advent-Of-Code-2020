package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdventOfCode2020Day6 {
    public static String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static void main(String[] args) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("/Users/srgrealey/IdeaProjects/" +
                "AdventOfCode2020/src/Day6/DaySixInput")));
        String[] values = data.split("\n\n");
        int numAllAnswered = 0, numQuestionsAnswered = 0;
        for(String value : values){
            int[] count2 = new int[26];
            String[] people = value.split("\n");
            for(String letter : letters)
                if (value.contains(letter))
                    value = value.replace(letter, "");
                    numQuestionsAnswered++;
            for(String person : people)
                for (int letter = 0; letter < letters.length; letter++) {
                    if (person.contains(letters[letter])) {
                        count2[letter]++;
                    }
                }
            for(int counts : count2){
                if(counts == people.length){
                    numAllAnswered++;
                }
            }
        }
        System.out.println("Answer For Part 1: " + numQuestionsAnswered);
        System.out.println("Answer For Part 2: " + numAllAnswered);
    }
}
