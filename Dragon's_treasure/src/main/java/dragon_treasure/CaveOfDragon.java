package main.java.dragon_treasure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CaveOfDragon {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static List<Treasure> dragonsTreasures;

    public CaveOfDragon() {
        dragonsTreasures = new ArrayList<>();
    }

    public void addTreasure(Treasure treasure) {
        dragonsTreasures.add(treasure);
    }

    public List<Treasure> getDragonsTreasures() {
        return dragonsTreasures;
    }

    void seeTheCave(int option) {
        switch (option) {
            case 1 -> viewListOfTreasures();
            case 2 -> {
                System.out.println("The most expensive treasure of the dragon from the point of view of cost:");
                viewTheMostExpensiveTreasure();
            }
            case 3 -> {
                System.out.println("Please enter the amount for which you want to collect the treasure:");
                double amount = 0.0;
                try {
                    amount = Double.parseDouble(reader.readLine());
                } catch (Exception e) {
                    System.out.println("Invalid data.");
                }
                selectingTreasures(amount);
            }
        }
    }

    private void viewListOfTreasures() {
        int index = 1;
        for(Treasure treasure : dragonsTreasures) {
            System.out.println(index + ". " + treasure);
            index++;
        }
    }

    private void viewTheMostExpensiveTreasure() {
        Treasure mostPreciousTreasure = dragonsTreasures.get(0);
        for (Treasure treasure : dragonsTreasures) {
            if(treasure.getCost() > mostPreciousTreasure.getCost())
                mostPreciousTreasure = treasure;
        }
        System.out.println(mostPreciousTreasure);
    }

    private void selectingTreasures(double amount) {
        List<Treasure> treasuresForGivenAmount = new ArrayList<>();
        double sum = 0.0;
        for (int i = 0; i < dragonsTreasures.size() && amount >= 0; i++) {
            if(dragonsTreasures.get(i).getCost() <= amount) {
                treasuresForGivenAmount.add(dragonsTreasures.get(i));
                sum += dragonsTreasures.get(i).getCost();
                amount -= dragonsTreasures.get(i).getCost();
            }
        }
        System.out.println("The dragon's treasure to the amount of: " + sum);
        for (Treasure treasure : treasuresForGivenAmount) {
            System.out.println(treasure);
        }
    }
}
