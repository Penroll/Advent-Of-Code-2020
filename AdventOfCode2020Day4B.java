package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdventOfCode2020Day4B {

    public static char[] validHCLs = {'a','b','c','d','e','f','0','1','2','3','4','5','6','7','8','9'};

    public static String[] validECLs = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
    public static String byr, iyr, eyr, hgt, hcl, ecl, pid;
    public static int pByr, pIyr, pEyr, pHgt;
    public static boolean isCM;
    public static void main(String[] args) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("/Users/srgrealey/IdeaProjects/AdventOfCode2020/src/Day4/DayFourInput")));
        String[] passports = data.split("\n\n");
        int numCorrectPassports = 0;
        for (String passport : passports){
            getData(passport);
            if(isValidPassport()){
                numCorrectPassports++;
            }
        }
        System.out.println("Number of Correct Passports: " + numCorrectPassports);
    }

    public static void getData(String passport){
        byr = passport.substring(passport.indexOf("byr")+4, passport.indexOf("byr") + 8);
        try{
            pByr = Integer.parseInt(byr);
        }
        catch(NumberFormatException e){
            pByr = 0;
        }
        iyr = passport.substring(passport.indexOf("iyr")+4, passport.indexOf("iyr") + 8);
        try{
            pIyr = Integer.parseInt(iyr);
        }
        catch(NumberFormatException e){
            pIyr = 0;
        }
        eyr = passport.substring(passport.indexOf("eyr")+4, passport.indexOf("eyr") + 8);
        try{
            pEyr = Integer.parseInt(eyr);
        }
        catch(NumberFormatException e){
            pEyr = 0;
        }
        ecl = passport.substring(passport.indexOf("ecl")+4, passport.indexOf("ecl") + 7);
        try{ pid = passport.substring(passport.indexOf("pid")+4, passport.indexOf("pid") + 13); }
        catch(StringIndexOutOfBoundsException e){ pid = "That's not it chief"; }
        hgt = (passport.contains("cm")) ? passport.substring(passport.indexOf("hgt")+4, passport.indexOf("hgt") + 7)
                : passport.substring(passport.indexOf("hgt")+4, passport.indexOf("hgt") + 6);
        try{
            pHgt = Integer.parseInt(hgt);
        }
        catch(NumberFormatException e){
            pHgt = 0;
        }
        isCM = passport.contains("cm");
        try{hcl = passport.substring(passport.indexOf("hcl")+4, passport.indexOf("hcl") + 11);}
        catch(StringIndexOutOfBoundsException e){ hcl = "gggggg";}
    }

    public static boolean isValidPassport(){
        return isValidBYR() && isValidIYR() && isValidEYR() && isValidHGT()
                && isValidHCL() && isValidECL() && isValidPID();
    }

    public static boolean isValidBYR(){
        return byr.length() == 4 && pByr >= 1920 && pByr <= 2002;
    }

    public static boolean isValidIYR(){
        return iyr.length() == 4 && pIyr >= 2010 && pByr <= 2020;
    }

    public static boolean isValidEYR(){
        return eyr.length() == 4 && pEyr >= 2020 && pEyr <= 2030;
    }

    public static boolean isValidHGT(){
        if(isCM){
            return pHgt >= 150 && pHgt <= 193;
        }
        else{
            return pHgt >= 59 && pHgt <= 76;
        }
    }

    public static boolean isValidHCL(){
        char[] hclChars = hcl.toCharArray();
        if(hcl.length() != 7){
            return false;
        }
        hcl = hcl.replace("#","");
        hcl = hcl.replace(" ", "");
        if(hcl.length() != 6){
            return false;
        }
        int numCorrectChars = 0;
        for(char c : hclChars){
            for(char d : validHCLs){
                if(c == d){
                    numCorrectChars++;
                }
            }
        }
        return numCorrectChars == 6;
    }

    public static boolean isValidECL(){
        for(String s : validECLs){
            if (ecl.equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }

    public static boolean isValidPID(){
        char[] pidChar = pid.toCharArray();
        int numNumbers = 0;
        for (char c : pidChar){
            if(Character.isDigit(c)){
                numNumbers++;
            }
        }
        return numNumbers == 9;
    }
}
