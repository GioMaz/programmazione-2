package ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainView {
    private final Map map;

    public MainView() {
        map = new Map();
    }

    public void loop() {
        do {
            map.displayOnOut();

            Scanner myObj = new Scanner(System.in);
            int i = myObj.nextInt();
            int j = myObj.nextInt();

            if (map.isFurnaceOutputEmpty()) {
                map.moveIntoFurnace(i, j);
            }
            else {
                map.placeFromFurnace(i, j);
            }
        } while (true);
    }
}