import java.util.ArrayList;
import java.util.List;

public class WorldMap {
    private Field[][] board;
    private Player player;
    private int width;
    private int height;
    private List<Field> fieldsList;


    public WorldMap(int height, int width) {
        this.width = width;
        this.height = height;
        this.board = createWorldMap(height, width);
        this.fieldsList = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Field> getFieldsList(){
        return fieldsList;
    }

    public void addToFieldsList(Field field){
        fieldsList.add(field);
    }

    public Field[][] getBoard() {
        return board;
    }

    public Player getPlayer(){
        return player;
    }

    public Field[][] createWorldMap(int height, int width) {
        Field[][] newBoard = new Field[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height - 1 || x == 0 || x == width - 1) {
                    newBoard[y][x] = new ObstField("#", "Frame", new Coords(y, x));
                } else if (y == player.getCoords().getposY() && x == player.getCoords().getposX()) {
                    newBoard[y][x] = player;
                } else {
                    newBoard[y][x] = new WalkField(",", "Grass", new Coords(y, x));
                }

            }
        }
        return newBoard;
    }
}