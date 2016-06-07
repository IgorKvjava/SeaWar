package ua.kvelinskyi.seawar;

class Game {

    private Player playerShot;
    private Player playerAccept;
    private Player playerBot;
    private Player playerHuman;
    private Player playerTime;
    private int resultShot;
    private static final int NEXT_PLAYER = 0;
    private static final int WINNER = -1;

    public void startGame() {
        playerBot = new PlayerBot();
        playerHuman = new PlayerHuman();
        playerBot.createFildPlayer();       
        System.out.println("Enter the ships coordinates"); 
        playerHuman.createFildPlayer();
        playerShot = playerHuman;
        playerAccept = playerBot;
        while (true) {
            System.out.println("Shot " + playerShot.getName());            
            String s =playerShot.shot();
            if (playerShot.getName().equals("Bot")) {
                System.out.println(s);
            }
            resultShot = playerAccept.acceptShot(s);
            if (resultShot == NEXT_PLAYER) {
                playerTime = playerShot;
                playerShot = playerAccept;
                playerAccept = playerTime;
            } else if (resultShot == WINNER) {
                if (playerShot.equals(playerHuman)) {
                    System.out.println("Human Win");
                    return;
                } else {
                    System.out.println("Bot Win");
                    return;
                }
            }           
        }
    }

}
