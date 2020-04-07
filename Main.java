public class Main{
    public static void main(String args[]){

        IO.initializeScanner();
        Player player1 = new Player();
        WorldMap worldTradeCenter = new WorldMap(20, 40);
        UI.displayMap(worldTradeCenter);
    }
}