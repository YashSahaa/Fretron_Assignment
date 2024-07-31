package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isPossible = true;
        ArrayList<Integer> apples = new ArrayList<>();

        //this will run until user will enter -1
        while (true) {
            System.out.println("Enter apple weight in grams (-1 to stop): ");
            int weight = sc.nextInt();
            if (weight == -1) {
                break;
            }
            apples.add(weight);
        }

        int tcount = 0;//To count total weight of all the apples
        for (int weight: apples) {
            tcount+=weight;
        }

        int countRam = (tcount *5) / 10;  // Ram split weight
        int countSham = (tcount *3) / 10; // Sham split weight
        int countRahim = (tcount *2) / 10;// Rahim split weight
        ArrayList<Integer> ram = new ArrayList<>();
        ArrayList<Integer> sham = new ArrayList<>();
        ArrayList<Integer> rahim = new ArrayList<>();

        Collections.sort(apples, Collections.reverseOrder()); //To sort array in descending order

        for (int appleWeight : apples) {
            if (countRam>=countSham && countRam>=countRahim){
                ram.add(appleWeight);
                countRam-=appleWeight;
                //Checking whether split is possible or not
                if(countRam<0){
                    isPossible=false;
                    break;
                }
            }
            else if (countSham>=countRam && countSham>=countRahim){
                sham.add(appleWeight);
                countSham-=appleWeight;
                //Checking whether split is possible or not
                if(countSham<0){
                    isPossible=false;
                    break;
                }
            }
            else if (countRahim>=countRam && countRahim>=countSham){
                rahim.add(appleWeight);
                countRahim-=appleWeight;
                //Checking whether split is possible or not
                if(countRahim<0){
                    isPossible=false;
                    break;
                }
            }
        }

        //Printing values if split is possible
        if (isPossible){
            System.out.println("Ram : " + ram);
            System.out.println("Sham : " + sham);
            System.out.println("Rahim : " + rahim);
        }
        else {
            System.out.println("Split not possible");
        }
    }
}





