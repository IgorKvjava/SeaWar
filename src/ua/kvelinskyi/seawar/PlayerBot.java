package ua.kvelinskyi.seawar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerBot extends Player{
       
    private String coordinate;
    private List<String> arrayCoordinatesShots = new ArrayList<String>();
    private Random random = new Random();
    private String [] abscissaX = {"A","B","C","D","E","F","G","H","I","J"};

    @Override
    protected String shot() {
       while (true) { 
           coordinate = abscissaX[random.nextInt(9)]+(random.nextInt(9)+1);
            if (isDifferent(coordinate)) {
                arrayCoordinatesShots.add(coordinate);
                field.printField();
                return coordinate;
            }
        } 
    }

    @Override
    protected int generateNewShipCoordinates() {        
        return field.locateShip(abscissaX[random.nextInt(9)], (random.nextInt(9)+1), 1);
    }
    
    @Override
    public String getName() {
        return "Bot";
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
}
