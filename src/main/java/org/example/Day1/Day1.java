package org.example.Day1;

import java.io.*;
import java.util.ArrayList;

public class Day1 {

    public static int maxOfArrayList(ArrayList<Integer> list) {
        int max = 0;

        max = list.get(0);
        for (int num :
                list) {
            if (num > max)
                max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        File f = new File("./inputs/Day1_inputs.txt");
        BufferedReader br = null;
        String text;
        int kcal, totalKcal = 0;
        ArrayList<Integer> listKcal = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(f));
            while ((text = br.readLine()) != null) {
                if (text.equals("")) {
                    listKcal.add(totalKcal);
                    totalKcal = 0;
                } else {
                    kcal = Integer.parseInt(text);
                    totalKcal += kcal;
                }
            }
            System.out.printf("Max => %d\n", maxOfArrayList(listKcal));
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
