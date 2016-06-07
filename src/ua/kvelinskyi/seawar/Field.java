package ua.kvelinskyi.seawar;

public class Field {

    private Cell[] cells = new Cell[100];
    private String[] abscissaX = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private int countShip = 0;

    public void createField() {
        int indexAbscissaX = 0;
        for (int i = 0; i < cells.length;) {
            for (int j = 1; j < 11; j++) {
                cells[i] = new Cell(abscissaX[indexAbscissaX], j, 0);
                i++;
            }
            indexAbscissaX++;
        }
    }

    public int locateShip(String abscissaX, int ordinateY, int stateCell) {
        for (Cell cell : cells) {            
            if (stateCell == 1 && cell.getAbscissaX().equals(abscissaX)
                    && cell.getOrdinateY() == ordinateY && cell.getStateCell() == 0) {
                cell.createShip(abscissaX, ordinateY);
                shipCells(cell, stateCell * 2);
                countShip++;
                cell.setStateCell(1);                
                return 1;
            }
            if (cell.getAbscissaX().equals(abscissaX)
                    && cell.getOrdinateY() == ordinateY && cell.getStateCell() == 1 && stateCell == -1) {                
                shipCells(cell, stateCell * 2);
                cell.setStateCell(-1);               
                return 1;
            }
        }
        return 0;
    }

    private void shipCells(Cell cell, int stateCell) {
        int indexAbscissaX = 0;
        int indexX;
        int indexY;
        for (int i = 0; i < 10; i++) {
            if (this.abscissaX[i].equals(cell.getAbscissaX())) {
                indexAbscissaX = i;
                i = 10;
            }
        }
        indexX = indexAbscissaX - 1;
        indexY = cell.getOrdinateY() - 1;
        for (int i = indexX; i < (indexX + 3); i++) {
            for (int j = indexY; j < (indexY + 3); j++) {
                statusCell(i, j, stateCell);
            }
        }
    }

    private void statusCell(int indexX, int indexY, int stateCell) {
        if (10 > indexX && indexX >= 0 && 10 >= indexY && indexY > 0) {
            for (Cell cell : cells) {
                if (cell.getAbscissaX().equals(abscissaX[indexX]) && cell.getOrdinateY() == indexY) {
                    cell.setStateCell(stateCell);
                    return;
                }
            }
        }

    }

    public int shotPlayer(String abscissaX, int ordinateY, int stateCell) {
        Cell cell = searchCell(abscissaX, ordinateY);        
        int resultShot = 1;
        if (cell != null) {             
            switch (cell.getStateCell()) {
                case 1:                    
                    --countShip;
                    resultShot = locateShip(abscissaX, ordinateY, stateCell);
                    printField();
                    break;
                case -1:
                    resultShot = 1;
                    break;
                case -2:
                    resultShot = 1;
                    break;
                default:
                    cell.setStateCell(-2);
                    resultShot = 0;
                    printField();
                    break;
            }
        }        
        if (countShip <= 0) {
            return -1;
        }
        return resultShot;
    }

    private Cell searchCell(String abscissaX, int ordinateY) {
        for (Cell cell : cells) {
            if (cell.getAbscissaX().equals(abscissaX) && cell.getOrdinateY() == ordinateY) {
                return cell;
            }
        }
        return null;
    }

    public void printField() {
        int index = 0;
        int i = 0;
        String result;
        System.out.println("    1 2 3 4 5 6 7 8 9 10");
        System.out.println("    ____________________");
        System.out.print(abscissaX[i] + " | ");
        for (Cell cell : cells) {
            switch(cell.getStateCell()) {
                case 1:
                    result = " ";
                    break;
                case -2:                    
                    result = "-";
                    break;
                case -1:                    
                    result = "X";
                    break;    
                default:                    
                    result = " ";
                    break;
            }
            System.out.print(result + " ");
            index++;
            if (index == 10) {
                System.out.print(" |\n");
                if (++i < 10) {
                    System.out.print(abscissaX[i] + " | ");
                }
                index = 0;
            }
        }
        System.out.println("--------------------------------------------");
    }

}
