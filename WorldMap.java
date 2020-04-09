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

    public List<Field> getFieldsList() {
        return fieldsList;
    }

    public void addToFieldsList(Field field) {
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
        summonGameObjects(newBoard);
        return newBoard;
    }

    public void summonGameObjects(Field[][] board) {
        summonHarmFields(board);
    }

    public void summonHarmFields(Field[][] board) {
        int[] randomPair = randomPair();
        board[randomPair[0]][randomPair[1]] = new Field(new HarmField("\u2592", Colours.RED_BACKGROUND_BRIGHT, "Lava",
                new Coords(randomPair[0], randomPair[1]), 1));
    }

    public void setCurrentOnMap(GameObject gameObject) {
        getBoard()[gameObject.getCoords().getPosY()][gameObject.getCoords().getPosX()].setCurrentObject(gameObject);
    }

    public void setDefaultOnMap(GameObject gameObject) {
        getBoard()[gameObject.getCoords().getPosY()][gameObject.getCoords().getPosX()].setDefaultObject(gameObject);
    }

    public Coords randomPlacementOnMap(GameObject gameObject) {
        Coords randomCoords = generateRandomCoords();
        gameObject.getCoords().setPosY(randomCoords.getPosY());
        gameObject.getCoords().setPosX(randomCoords.getPosX());
        return new Coords(randomCoords.getPosY(), randomCoords.getPosX());
    }

    public Coords generateRandomCoords() {
        int randomPosY = Engine.randomIntFromRange(1, height-1);
        int randomPosX = Engine.randomIntFromRange(1, width-1);
        return new Coords(randomPosY, randomPosX);
    }

    public int[] randomPair() {
        int randomPosY = Engine.randomIntFromRange(1, height-1);
        int randomPosX = Engine.randomIntFromRange(1, width-1);
        return new int[] { randomPosY, randomPosX };
    }
}
