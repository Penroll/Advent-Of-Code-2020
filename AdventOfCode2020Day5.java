package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Gets the maximum seat ID as well as the missing seatID on the flight seating
 */
public class AdventOfCode2020Day5 {

    /**
     * Maximum flight ID number
     */
    public static int max = 0;

    /**
     * Minimum flight ID number
     */
    public static int min = 1000;

    /**
     * Integer array of all seating IDs
     */
    public static int[] seatIDS = new int[936];

    /**
     * Finds the maximum seatID as well as the missing seatID in the flight
     * @param args command-line arguments (not used)
     * @throws IOException if the input file is not found
     */
    public static void main(String[] args) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("/Users/srgrealey/IdeaProjects/" +
                "AdventOfCode2020/src/Day5/DayFiveInput")));
        String[] values = data.split("\n");
        for (int i = 0; i < values.length; i++){
            seatIDS[i] = run(values[i]);
        }
        System.out.print("Max Seat ID: " + max + "\nYour Seat ID: ");
        findYourSeat(seatIDS);
    }

    /**
     * Finds the missing seatID within the flight manifest
     * @param seatIDS is the integer array of all seat IDs
     */
    public static void findYourSeat(int[] seatIDS){
        Arrays.sort(seatIDS);
        int counter = min;
        for(int value : seatIDS){
            if(value != counter){
                System.out.println(counter);
                break;
            }
            else{ counter++; }
        }
    }

    /**
     * Finds the seatID of a certain seat given its binary values
     * @param value is the binary value specifying the seat
     * @return the seat ID of the seat
     */
    public static int run(String value) {
        int seatID;
        char[] values = value.toCharArray();
        StringBuilder row = new StringBuilder();
        StringBuilder column = new StringBuilder();
        for (char s : values) {
            switch (s) {
                case 'F' -> row.append("0");
                case 'B' -> row.append("1");
                case 'L' -> column.append("0");
                case 'R' -> column.append("1");
            }
        }
        seatID = Integer.parseInt(row.toString(), 2) * 8 + Integer.parseInt(column.toString(), 2);
        max = Math.max(seatID, max);
        min = Math.min(seatID, min);
        return seatID;
    }
}
