import java.util.ArrayList;
import java.util.List;

public class WorldMap {
    private Field[][] board;
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


    public Field[][] createWorldMap(int height, int width) {
        Field[][] newBoard = new Field[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height - 1 || x == 0 || x == width - 1) {
                    newBoard[y][x] = new Field(new ObstField("#", "Frame", new Coords(y, x)));
                } else {
                    newBoard[y][x] = new Field(new WalkField(".", "Grass", new Coords(y, x)));
                }
            }
        }
        return newBoard;
    }

    public void placeOnMap(Field field){
        getBoard()[field.getCurrentObject().getCoords().getPosY()][field.getCurrentObject().getCoords().getPosX()] = field;
    }
}
