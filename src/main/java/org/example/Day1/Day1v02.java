package org.example.Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Day1v02 {

    public static ArrayList<Integer> sortArrayList(ArrayList<Integer> list) {
        ArrayList<Integer> listSorted = list;
        Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(listSorted, comparador);
        return listSorted;
    }

    public static final int getPodium(ArrayList<Integer> list) {
        int podium = 0;
        for (int i = 0; i < 3; i++) {
            podium += list.get(i);
        }
        return podium;
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
            System.out.printf("1st => %d\n" +
                    "2nd => %d\n" +
                    "3rd => %d\n", sortArrayList(listKcal).get(0), sortArrayList(listKcal).get(1), sortArrayList(listKcal).get(2));
            System.out.printf("Total => %d", getPodium(sortArrayList(listKcal)));
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}

