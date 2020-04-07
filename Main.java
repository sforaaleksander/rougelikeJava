public class Main{
    public static void main(String args[]){

        IO.initializeScanner();
        // Game game = new Game();
        Engine.jFrame();
        WorldMap worldTradeCenter = new WorldMap(20, 40);
        UI.displayMap(worldTradeCenter);
    }
}