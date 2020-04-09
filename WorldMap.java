import java.util.ArrayList;
import java.util.List;

public class WorldMap {
    private Field[][] board;
    private int width;
    private int height;
    private List<Field> takenFields;
    private int numberOfDiamonds;
    private int numberOfMosquitos;
    private int numberOfLavas;
    private int numberOfHearts;
    private List<GameObject> activeObjects;


    public WorldMap(int height, int width, int numberOfMosquitos, int numberOfDiamonds, int numberOfLavas, int numberOfHearts) {
        this.width = width;
        this.height = height;
        this.board = createWorldMap(height, width);
        this.numberOfDiamonds = numberOfDiamonds;
        this.numberOfHearts = numberOfHearts;
        this.numberOfLavas = numberOfLavas;
        this.numberOfMosquitos = numberOfMosquitos;
        this.activeObjects = new ArrayList<>();
        summonHearts();
        summonLavas();
        summonDiamonds();
        summonMosquitos();
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
    //TODO make one method and checking fieldsTaken List 
    private void summonMosquitos() {
        for (int i = 0; i < numberOfMosquitos; i++) {
            int[] randomPair = randomPair();
            Mosquito komar = new Mosquito(new Coords(randomPair[0], randomPair[1]), this);
            board[randomPair[0]][randomPair[1]] = new Field(komar, new Grass(new Coords(randomPair[0], randomPair[1])));
            // komar.setCurrentMap(this);
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

    private void summonHearts() {
        for (int i = 0; i < numberOfHearts; i++) {
            int[] randomPair4 = randomPair();
            board[randomPair4[0]][randomPair4[1]] = new Field(new Heart(new Coords(randomPair4[0], randomPair4[1])),
                    new Grass(new Coords(randomPair4[0], randomPair4[1])));
        }
    }

    public void summonLavas() {
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
}
