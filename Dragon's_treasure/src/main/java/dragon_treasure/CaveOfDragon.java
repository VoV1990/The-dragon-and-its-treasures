package main.java.dragon_treasure;

import java.util.ArrayList;
import java.util.List;

public class CaveOfDragon {
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

    public void calculateTheMostPreciousTreasure() {
        Treasure mostPreciousTreasure = dragonsTreasures.get(0);
        for (Treasure treasure : dragonsTreasures) {
            if(treasure.getCost() > mostPreciousTreasure.getCost())
                mostPreciousTreasure = treasure;
        }
        System.out.println(mostPreciousTreasure);
    }
}
