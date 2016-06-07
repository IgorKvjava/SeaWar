package ua.kvelinskyi.seawar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerHuman extends Player {

    private Field field;
    private Scanner sc = new Scanner(System.in);
    private String coordinate;
    private String x;
    private int y;
    private List arrayCoordinatesShots = new ArrayList();

    @Override
    protected void acceptShot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void generateNewShipCordinates() {
        coordinate = sc.nextLine();
        if (isDifferent(coordinate) && isValid(coordinate)) {
            arrayCoordinatesShots.add(coordinate);
            x = coordinate.substring(0, 1);
            y = Integer.parseInt(coordinate.substring(1));
            field.locateShip(x, y, 1);
        }
    }

    private boolean isDifferent(String coordinate) {
        for (Object arrayCoordinatesShot : arrayCoordinatesShots) {
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

}
