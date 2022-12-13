package org.example.Day2;

import java.io.*;
import java.util.Objects;

public class Day2 {

    public static String[] lineToArray(String line) {
        String[] cheatSheet = line.split(" ");
        return cheatSheet;
    }

    public static void main(String[] args) throws IOException {
        File f = new File("./inputs/Day2_input.txt");
        BufferedReader br = null;
        String[] cheatSheet;
        String text;
        int score = 0;

        br = new BufferedReader(new FileReader(f));
        while ((text = br.readLine()) != null) {
            cheatSheet = lineToArray(text);
            switch (cheatSheet[0]) {
                case "A":
                    if (Objects.equals(cheatSheet[1], "Y")) {
                        score += 6 + 2; //win
                    } else if (Objects.equals(cheatSheet[1], "X")) {
                        score += 3 + 1; //draw
                    } else {
                        score += 3; //lose
                    }
                    break;
                case "B":
                    if (Objects.equals(cheatSheet[1], "Z")) {
                        score += 6 + 3;
                    } else if (Objects.equals(cheatSheet[1], "Y")) {
                        score += 3 + 2;
                    } else {
                        score += 1;
                    }
                    break;
                case "C": {
                    if (Objects.equals(cheatSheet[1], "X")) {
                        score += 6 + 1;
                    } else if (Objects.equals(cheatSheet[1], "Z")) {
                        score += 3 + 3;
                    } else {
                        score += 2;
                    }
                    break;
                }
            }
        }
        System.out.printf("**Score: %d\n", score);
    }
}