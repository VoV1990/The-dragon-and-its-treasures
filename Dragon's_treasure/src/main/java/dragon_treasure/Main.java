package main.java.dragon_treasure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        dragon.createDragonsTreasures();
        chooseOption(dragon);
    }

    private static void chooseOption(Dragon dragon) {
        boolean stop = false;
        int option = 0;
        do{
            System.out.println("Please make a choice:");
            System.out.println("1. View the dragon's Treasures.");
            System.out.println("2. View the most expensive treasure in terms of value.");
            System.out.println("3. Selecting treasures for a given amount.");
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
            if(option >= 1 && option <= 3) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        doIt(option, dragon);
    }

    private static void doIt(int option, Dragon dragon) {
        switch (option) {
            case 1 -> dragon.showListOfTreasures();
            case 2 -> {
                System.out.println("The most precious treasure of the dragon from the point of view of cost:");
                dragon.showTheMostPreciousTreasure();
            }
            case 3 -> {
                System.out.println("Please enter the amount for which you want to collect the treasure:");
                double amount = 0.0;
                try {
                    amount = Double.parseDouble(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Invalid data.");
                }
                dragon.selectingTreasures(amount);
            }
        }
    }
}
