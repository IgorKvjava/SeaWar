package ua.kvelinskyi.seawar;

abstract class  Player {    
    private int numberShips = 4;
    protected Field field;
      
    public void createFild(){
        field = new Field();
        generateNewShipCordinates();               
    }
    
    public int shot() {        
        return getField().shotPlayer(getX(), getY(), -1);
    }
    protected abstract void acceptShot();
    
    protected abstract void generateNewShipCordinates();  
    
    
}
