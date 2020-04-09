import java.util.ArrayList;
import java.util.List;

public class WorldMap {
    private Field[][] board;
    private int width;
    private int height;
    private List<Field> fieldsList;
    private int requiredDiamonds; /// TODO sprawdzanie czy gracz zebrał wszyskie diamenty na mapie (czyli czy
                                  /// gracz ma tyle diamentow ile mapa wymaga zeby przejsc poziom)

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
                    newBoard[y][x] = new Field(new Frame(new Coords(y, x)));
                } else {
                    newBoard[y][x] = new Field(new Grass(new Coords(y, x)));
                }
            }
        }
        summonGameObjects(newBoard);
        return newBoard;
    }

    public void summonGameObjects(Field[][] board) {
        summonHarmFields(board);
        summonItems(board);
        summonEnemies(board);

    }
    
    private void summonEnemies(Field[][] board) {
        int[] randomPair = randomPair();
        board[randomPair[0]][randomPair[1]] = new Field(new Mosquito(new Coords(randomPair[0], randomPair[1])),
                new Grass(new Coords(randomPair[0], randomPair[1])));
    }

    private void summonItems(Field[][] board) {
        //TODO STROGI REFACTOR TO JEST TYLKO TEST DZIAŁANIA DOMYŚLNIE MA BYĆ PETLA 
        int[] randomPair = randomPair();
        board[randomPair[0]][randomPair[1]] = new Field(new Diamond(new Coords(randomPair[0], randomPair[1])),
                new Grass(new Coords(randomPair[0], randomPair[1])));
      
        int[] randomPair4 = randomPair();
        board[randomPair4[0]][randomPair4[1]] = new Field(new Heart(new Coords(randomPair4[0], randomPair4[1])),
                new Grass(new Coords(randomPair4[0], randomPair4[1])));
    }

    public void summonHarmFields(Field[][] board) {
        int[] randomPair = randomPair();
        board[randomPair[0]][randomPair[1]] = new Field(new Lava(new Coords(randomPair[0], randomPair[1])));
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
        int randomPosY = Engine.randomIntFromRange(1, height - 1);
        int randomPosX = Engine.randomIntFromRange(1, width - 1);
        return new Coords(randomPosY, randomPosX);
    }

    public int[] randomPair() {
        int randomPosY = Engine.randomIntFromRange(1, height - 1);
        int randomPosX = Engine.randomIntFromRange(1, width - 1);
        return new int[] { randomPosY, randomPosX };
    }

    public int getRequiredDiamonds() {
        return requiredDiamonds;
    }
}
