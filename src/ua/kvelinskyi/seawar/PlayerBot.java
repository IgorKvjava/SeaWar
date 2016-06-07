package ua.kvelinskyi.seawar;

import java.util.Random;

public class PlayerBot extends Player{
    private Field field; 
    private String x;
    private int y; 
    private Random random = new Random();
    private String [] abscissaX = {"A","B","C","D","E","F","G","H","I","J"};

    public PlayerBot() {
        field = new Field();
    }

    @Override
    void playerProgress() {
        x = abscissaX[random.nextInt(9)];
        y = (random.nextInt(9)+1);
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
        return "Bot";
    }

    @Override
    Field getField() {
        return field;
    }   
    
}
