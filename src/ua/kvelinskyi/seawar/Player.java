package ua.kvelinskyi.seawar;

abstract class  Player {    
    private int numberShips = 4;
    protected Field field;
    private int resultShot;
      
    public void createFildPlayer(){
        field = new Field();
        field.createField();        
        for (int i = 0; i < numberShips;) {
            i +=generateNewShipCoordinates();
        }        
    } 
    
    public int acceptShot(String coordinate) {
        resultShot = field.shotPlayer(coordinate.substring(0, 1), Integer.parseInt(coordinate.substring(1)), -1);
        if (resultShot == 2) {
            return 1;
        }
        if (getName().equals("Human")) {
            field.printFieldHumen();
        }
        if (resultShot == 1 && getName().equals("Bot")) {
            field.printField();
        }        
        return resultShot;
    }
    
    protected abstract String shot();
    
    protected abstract int generateNewShipCoordinates();
    
    public abstract String getName();
    
    
}
