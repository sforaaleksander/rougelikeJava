import java.util.ArrayList;
import java.util.List;

public class WorldMap {
    private Field[][] board;
    private int width;
    private int height;
    private List<Field> fieldsList;
    private int requiredDiamonds; /// TODO sprawdzanie czy gracz zebrał wszyskie diamenty na mapie (czyli czy gracz ma tyle diamentow ile mapa wymaga zeby przejsc poziom)
    

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
                    newBoard[y][x] = new Field(new ObstField("#", Colours.WHITE_BACKGROUND, "Frame", new Coords(y, x)));
                } else {
                    newBoard[y][x] = new Field(new WalkField(" ", Colours.GREEN_BACKGROUND, "Grass", new Coords(y, x)));
                }
            }
        }
        newBoard[9][9] = new Field(new HarmField("X", Colours.PURPLE_BACKGROUND, "DZIURA", new Coords(9, 9), 1));
        return newBoard;
    }

    public void placeOnMap(Field field){
        getBoard()[field.getCurrentObject().getCoords().getPosY()][field.getCurrentObject().getCoords().getPosX()] = field;
    }

    public int getRequiredDiamonds() {
        return requiredDiamonds;
    }
}
