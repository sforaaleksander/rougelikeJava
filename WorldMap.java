import java.util.ArrayList;
import java.util.List;

public class WorldMap {
    private Field[][] board;
    private static int width;
    private static int height;
    private List<Field> takenFields;
    private int numberOfDiamonds;
    private int numberOfMosquitos;
    private int numberOfLavas;
    private int numberOfHearts;
    private int numberOfSwamps;
    private List<ActiveObject> activeObjects;

    public WorldMap(int numberOfMosquitos, int numberOfDiamonds, int numberOfLavas,
            int numberOfHearts, int numberOfSwamps) {
        height = 30;
        width = 90;
        this.board = createWorldMap(height, width);
        this.numberOfDiamonds = numberOfDiamonds;
        this.numberOfHearts = numberOfHearts;
        this.numberOfLavas = numberOfLavas;
        this.numberOfMosquitos = numberOfMosquitos;
        this.numberOfSwamps = numberOfSwamps;
        this.activeObjects = new ArrayList<>();
        summonHearts();
        summonLavas();
        summonDiamonds();
        summonMosquitos();
        summonSwamps();
        this.takenFields = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Field> getTakenFields() {
        return takenFields;
    }

    public void addToTakenFieldsList(Field field) {
        takenFields.add(field);
    }

    public List<ActiveObject> getActiveObjects() {
        return activeObjects;
    }

    public Field[][] getBoard() {
        return board;
    }

    public int getNumberOfDiamonds() {
        return numberOfDiamonds;
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
        return newBoard;
    }

    // TODO: Make a more abstract method suitable for all objects
    // TODO: Check list of takenFields when adding

    private void summonMosquitos() {
        for (int i = 0; i < numberOfMosquitos; i++) {
            int[] randomPair = randomPair();
            Mosquito komar = new Mosquito(this);
            board[randomPair[0]][randomPair[1]] = new Field(komar, new Grass(new Coords(randomPair[0], randomPair[1])));
            board[randomPair[0]][randomPair[1]].setDefaultObject(new Grass(new Coords(randomPair[0], randomPair[1])));
            activeObjects.add(komar);
        }
    }

    private void summonDiamonds() {
        for (int i = 0; i < numberOfDiamonds; i++) {
            int[] randomPair = randomPair();
            board[randomPair[0]][randomPair[1]] = new Field(new Diamond(new Coords(randomPair[0], randomPair[1])),
                    new Grass(new Coords(randomPair[0], randomPair[1])));
        }
    }

    private void summonSwamps() {
        for (int i = 0; i < numberOfSwamps; i++) {
            int[] randomPair = randomPair();
            Swamp bagno = new Swamp(this);
            board[randomPair[0]][randomPair[1]] = new Field(bagno);
            board[randomPair[0]][randomPair[1]].setDefaultObject(new Grass(new Coords(randomPair[0], randomPair[1])));
            activeObjects.add(bagno);
        }
    }

    private void summonHearts() {
        for (int i = 0; i < numberOfHearts; i++) {
            int[] randomPair4 = randomPair();
            board[randomPair4[0]][randomPair4[1]] = new Field(new Heart(new Coords(randomPair4[0], randomPair4[1])),
                    new Grass(new Coords(randomPair4[0], randomPair4[1])));
        }
    }

    private void summonLavas() {
        for (int i = 0; i < numberOfLavas; i++) {
            int[] randomPair = randomPair();
            board[randomPair[0]][randomPair[1]] = new Field(new Lava(new Coords(randomPair[0], randomPair[1])));
        }
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

    public static Coords generateRandomCoords() {
        int randomPosY = Engine.randomIntFromRange(1, height - 1);
        int randomPosX = Engine.randomIntFromRange(1, width - 1);
        return new Coords(randomPosY, randomPosX);
    }

    public int[] randomPair() {
        //TODO add chceck if not in takenFieldsList?
        int randomPosY = Engine.randomIntFromRange(1, height - 1);
        int randomPosX = Engine.randomIntFromRange(1, width - 1);
        return new int[] { randomPosY, randomPosX };
    }
}
