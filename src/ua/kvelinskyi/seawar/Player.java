package ua.kvelinskyi.seawar;

abstract class  Player {    
    private int numberShips = 4;
    protected Field field;
      
    public void createFild(){
        field = new Field();
        field.createField();
        for (int i = 0; i < numberShips; i++) {
            i +=generateNewShipCordinates();
        }                       
    } 
    
    protected abstract String shot();
    
    public abstract void acceptShot(String coordinate);
    
    protected abstract int generateNewShipCordinates();  
    
    
}
