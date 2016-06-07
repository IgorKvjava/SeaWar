package ua.kvelinskyi.seawar;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerHuman extends Player {

    private Field field;
    private Scanner sc = new Scanner(System.in);
    private String coordinate;
    private String x;
    private int y;    

    public PlayerHuman() {
        field = new Field();
    }

    @Override
    public void playerProgress() {
        coordinate = sc.nextLine();
        if (is(coordinate)) {
            x = coordinate.substring(0, 1);
            y = Integer.parseInt(coordinate.substring(1));
        }
    }
    
    @Override
    String getX() {
        return x;
    }

    @Override
    int getY() {
        return y;
    }

    @Override
    String getName() {
        return "human";
    }

    private boolean is(String userString) {
        Pattern p = Pattern.compile("[A-J]{1}\\d{1,2}");
        Matcher m = p.matcher(userString);
        return m.matches();
    }

    @Override
    Field getField() {
        return field;
    }

}
