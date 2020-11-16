package main.java.dragon_treasure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/*Создать консольное приложение, удовлетворяющее следующим требованиям:
• Приложение должно быть объектно-, а не процедурно-ориентированным.
• Каждый класс должен иметь отражающее смысл название и информативный состав.
• Наследование должно применяться только тогда, когда это имеет смысл.
• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
• Классы должны быть грамотно разложены по пакетам.
• Консольное меню должно быть минимальным.
• Для хранения данных можно использовать файлы.

Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ
на заданную сумму.*/

public class Dragon {
    private CaveOfDragon caveOfDragon;

    public Dragon() {
        this.caveOfDragon = new CaveOfDragon();
    }

    public void createDragonsTreasures() {
        Properties property = new Properties();
        Set<Object> set;
        try {
            property.load(getClass().getResourceAsStream("/main/java/resources/Treasures.properties"));
            set = property.keySet();
            for (Object s : set) {
                String treasureName = (String) s;
                double cost = Double.parseDouble(property.getProperty(treasureName));
                caveOfDragon.addTreasure(new Treasure(treasureName, cost));
            }
        } catch (IOException e) {
            System.out.println("Resource wasn't found.");
            e.printStackTrace();
        }
    }

    public void showListOfTreasures() {
        int index = 1;
        for(Treasure treasure : caveOfDragon.getDragonsTreasures()) {
            System.out.println(index + ". " + treasure);
            index++;
        }
    }

    public void showTheMostPreciousTreasure() {
        caveOfDragon.calculateTheMostPreciousTreasure();
    }

    public void selectingTreasures(double amount) {
        List<Treasure> dragonsTreasures = caveOfDragon.getDragonsTreasures();
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
