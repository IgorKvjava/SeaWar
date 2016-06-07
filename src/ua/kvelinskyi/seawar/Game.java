package ua.kvelinskyi.seawar;

class Game {

    private Player player;
    Player playerBot;
    Player playerHuman;
    private int resultShot;
    private static final int NEXT_PLAYER = 0;
    private static final int WIN = -1;

    public void startGame() {
        playerBot = new PlayerBot();
        playerHuman = new PlayerHuman();
        playerBot;
        player.locateShip();
        playerHuman.createFild();
        System.out.println("Enter the ships coordinates");
        player.locateShip();
        while (true) {
            System.out.println("Shot " + player.getName());
            resultShot = player.shot();
            if (resultShot == NEXT_PLAYER) {
                if (player.equals(playerHuman)) {
                    player = playerBot;
                } else {
                    player = playerHuman;
                }
            } else if (resultShot == WIN) {
                if (player.equals(playerHuman)) {
                    System.out.println("Human Win");
                    return;
                } else {
                    System.out.println("Bot Win");
                    return;
                }
            }

            //System.out.println("\nNew game enter 1 \nEnd game enter 0");
        }
    }

}
