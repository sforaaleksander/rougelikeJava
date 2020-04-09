public class UI {

    public static void displayMap(WorldMap map) {
        for (int y = 0; y < map.getHeight(); y++){
            for (int x = 0; x < map.getWidth(); x++){
                System.out.print(map.getBoard()[y][x].getCurrentObject().getSymbol());
            }
            System.out.println("");
        }
    }

    public static void bottomDisplay(Player player){
        String hpResult = "HP: ";
        for (int i =0; i<player.getHp();i++){
            hpResult += "\u25C6 ";
        }
        System.out.println(hpResult);
    }
}