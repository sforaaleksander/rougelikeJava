
public class UI {

    public static void displayMap(WorldMap map) {
        for (int y = 0; y < map.getHeight(); y++){
            for (int x = 0; x < map.getWidth(); x++){
                System.out.println(map.getBoard()[y][x].getSymbol());
            }
        }
    }
}