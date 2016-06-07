package ua.kvelinskyi.seawar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerHuman extends Player {
   
    private Scanner sc = new Scanner(System.in);
    private String coordinate;
    private String x;
    private int y;
    private List<String> arrayCoordinatesShots = new ArrayList<String>();

    @Override
    protected int generateNewShipCoordinates() {
        coordinate = sc.nextLine();
        if (isValid(coordinate)) {            
            x = coordinate.substring(0, 1);
            y = Integer.parseInt(coordinate.substring(1));
            return field.locateShip(x, y, 1);
        }
        return 0;
    }

    private boolean isDifferent(String coordinate) {
        if (arrayCoordinatesShots.isEmpty()) {
           return true;
       }
        for (String arrayCoordinatesShot : arrayCoordinatesShots) {
            if (!arrayCoordinatesShot.equals(coordinate)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(String coordinate) {
        Pattern p = Pattern.compile("[A-J]{1}\\d{1,2}");
        Matcher m = p.matcher(coordinate);
        return m.matches();
    }

    @Override
    protected String shot() {
        while (true) {
            coordinate = sc.nextLine();
            if (isValid(coordinate) && isDifferent(coordinate)) {
                arrayCoordinatesShots.add(coordinate);                
                return coordinate;
            }
        }
    }

    @Override
    public String getName() {
        return "Human";
    }
    
}
