package ua.kvelinskyi.seawar;

class Cell {
    private String abscissaX;
    private int ordinateY;
    private int stateCell; //new int[4];

    public Cell(String abscissaX, int ordinateY, int stateCell) {
        this.abscissaX = abscissaX;
        this.ordinateY = ordinateY;
        this.stateCell = stateCell;
    }
    
    public void createShip(String X, int Y){
        Ship ship = new Ship(X, Y, 1);
    }

    public String getAbscissaX() {
        return abscissaX;
    }

    public int getOrdinateY() {
        return ordinateY;
    }

    public int getStateCell() {
        return stateCell;
    }
    
    public void setStateCell(int stateCell) {
        this.stateCell = stateCell;
    }

    @Override
    public String toString() {
        return "abscissaX "+abscissaX+" ordinateY " +ordinateY+" stateCell "+stateCell;
    }
    
    
}
