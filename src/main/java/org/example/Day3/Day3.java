package org.example.Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {
    public static int getTotal(int total, String lowerCase, String upperCase, Character c) {
        if (lowerCase.contains(String.valueOf(c))) {
            for (int i = 0; i < lowerCase.toCharArray().length; i++) {
                if (c == lowerCase.toCharArray()[i]) {
                    total += i + 1;
                    break;
                }
            }

        } else if (upperCase.contains(String.valueOf(c))) {
            for (int i = 0; i < upperCase.toCharArray().length; i++) {
                if (c == upperCase.toCharArray()[i]) {
                    total += i + 1 + 26;
                    break;
                }
            }
        }
        return total;
    }

    public static String generateAlphabet(){
        String alphabet = "";

        for (char c = 'a'; c <= 'z' ; ++c) {
            alphabet += c;
        }
        return alphabet;
    }

    public static void main(String[] args) throws IOException {
        File f = new File("./inputs/Day3_input.txt");
        String line, firstCharacter, secondCharacter, alphabetLowerCase, alphabetUpperCase;
        int total = 0, halfLine;
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Character> sameChars;

        BufferedReader br = new BufferedReader(new FileReader(f));
        while ((line = br.readLine()) != null) {
            words.add(line);
            halfLine = line.length() / 2;
            firstCharacter = line.substring(0, halfLine);
            secondCharacter = line.substring(halfLine);
            sameChars = new ArrayList<>();
            for (int i = 0; i < firstCharacter.length(); i++) {
                for (int j = 0; j < firstCharacter.length(); j++) {
                    if (firstCharacter.charAt(i) == secondCharacter.charAt(j) && !sameChars.contains(firstCharacter.charAt(i))) {
                        sameChars.add(firstCharacter.charAt(i));
                    }
                }
            }
            alphabetLowerCase = generateAlphabet().toLowerCase();
            alphabetUpperCase = generateAlphabet().toUpperCase();
            for (Character c : sameChars) {
                total = getTotal(total, alphabetLowerCase, alphabetUpperCase, c);
            }
        }
        System.out.println(total);
    }
}
