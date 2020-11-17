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
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private CaveOfDragon caveOfDragon;

    public Dragon() {
        this.caveOfDragon = new CaveOfDragon();
        createDragonsTreasures();
    }

    private void createDragonsTreasures() {
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

    void showCave() {
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
        caveOfDragon.seeTheCave(option);
    }
}
