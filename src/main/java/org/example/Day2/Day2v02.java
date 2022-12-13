package org.example.Day2;

import java.io.*;
import java.util.Objects;

public class Day2v02 {

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
                case "A":{
                    if(Objects.equals(cheatSheet[1], "Y")){
                        score += 3+1; //draw
                    } else if (Objects.equals(cheatSheet[1], "X")) {
                        score += 3; //lose
                    }else{
                        score += 6+2; //win
                    }
                    break;
                }

                case "B":{
                    if(Objects.equals(cheatSheet[1], "Z")){
                        score += 6+3;
                    } else if (Objects.equals(cheatSheet[1], "Y")) {
                        score += 3+2;
                    }else{
                        score += 1;
                    }
                    break;
                }

                case "C":{
                    if(Objects.equals(cheatSheet[1], "X")){
                        score += 2;
                    } else if (Objects.equals(cheatSheet[1], "Z")) {
                        score += 6+1;
                    }else{
                        score += 3+3;
                    }
                    break;
                }
            }
        }
        System.out.printf("**Score v02: %d\n", score);
    }
}