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
        //TODO ZROBIC 2 OSOBNE METODY Z PARAMETREM PLAYER DO GENEROWANIA OSOBNO HP I OSOBNO DIAMENTOW
        String hpResult = "HP: ";
        String collectedDiamonds = "DIAMONDS: ";
        for (int i =0; i<player.getHp();i++){
            hpResult += Colours.RED + "\u2764 " + Colours.RESET;
        }

        collectedDiamonds += 
        player.getCollectedDiamonds() + "/" + player.getCurrentMap().getNumberOfDiamonds()+ " ";

        for (int i =0; i<player.getCollectedDiamonds();i++){
            collectedDiamonds += Colours.CYAN + "\u25C6 " + Colours.RESET;
        }
        String concatenatedResult = hpResult + "\n" + collectedDiamonds;
        System.out.println(concatenatedResult);
    }
}