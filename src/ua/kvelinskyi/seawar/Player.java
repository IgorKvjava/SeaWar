package ua.kvelinskyi.seawar;

abstract class  Player {    
    private int numberShips = 4;
      
    public void locateShip(){
        for (int i = 0; i < numberShips;) {
            playerProgress();
            i += getField().locateShip(getX(), getY(), 1);
        }        
    }
    
    public int shot() {
        playerProgress();
        return getField().shotPlayer(getX(), getY(), -1);
    }
    
    abstract Field getField();
    
    abstract void playerProgress();
    
    abstract String getX(); 
    
    abstract int getY();
    
    abstract String getName();          
    
}
