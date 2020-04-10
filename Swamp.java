
public class Swamp extends GameObject implements ActiveObject {
    WorldMap currentMap;

    public Swamp(WorldMap map) {
        super("\u2588", Colours.CYAN, "Bagno", WorldMap.generateRandomCoords());
        this.currentMap = map;
    }

    public void growSwamp() {

    }

    @Override
    public void interact(Player player) {
        int lastPosY = player.getLastField().getDefaultObject().getCoords().getPosY();
        int lastPosX = player.getLastField().getDefaultObject().getCoords().getPosX();
        int nowPosY = player.getCoords().getPosY();
        int nowPosX = player.getCoords().getPosX();

        GameObject nextField = findNextField(lastPosY, lastPosX, nowPosY, nowPosX, player.getCurrentMap());

        if (nextField.getName().equals("Grass")) {
            player.getCoords().setPosY(nextField.getCoords().getPosY());
            player.getCoords().setPosX(nextField.getCoords().getPosX());
            player.getCurrentMap().getBoard()[player.getCoords().getPosY()][player.getCoords().getPosX()]
                    .setCurrentObject(player);
            player.getLastField().setToDefault();
        } else {
            int lastFieldY = player.getLastField().getDefaultObject().getCoords().getPosY();
            int lastFieldX = player.getLastField().getDefaultObject().getCoords().getPosX();
            player.getCoords().setPosY(lastFieldY);
            player.getCoords().setPosX(lastFieldX);
            player.getCurrentMap().getBoard()[player.getCoords().getPosY()][player.getCoords().getPosX()]
                    .setCurrentObject(player);
        }
    }

    private GameObject findNextField(int lastPosY, int lastPosX, int posY, int posX, WorldMap map) {
        if (lastPosY > posY) {
            GameObject nextStep = map.getBoard()[posY - 1][posX].getDefaultObject();
            return nextStep;
        } else if (lastPosY < posY) {
            GameObject nextStep = map.getBoard()[posY + 1][posX].getDefaultObject();
            return nextStep;
        } else if (lastPosX > posX) {
            GameObject nextStep = map.getBoard()[posY][posX - 1].getDefaultObject();
            return nextStep;
        } else if (lastPosX < posX) {
            GameObject nextStep = map.getBoard()[posY][posX + 1].getDefaultObject();
            return nextStep;
        }
        return null;
    }

    @Override
    public void performAct() {
        Coords[] listOfCoords = new Coords[] { Coords.RIGHT, Coords.LEFT, Coords.DOWN, Coords.UP };
        Coords randomCoords;
        int nextY, nextX;
        do {
            randomCoords = listOfCoords[Engine.randomIntFromRange(0, 4)];
            nextY = this.getCoords().getPosY() + randomCoords.getPosY();
            nextX = this.getCoords().getPosX() + randomCoords.getPosX();

        } while (!(nextY > 0 && nextY < currentMap.getHeight() - 1 && nextX > 0 && nextX < currentMap.getWidth() - 1));
        // if (currentMap.getBoard()[nextY][nextX].getCurrentObject() instanceof
        // Diamond) { // TODO IF HEART IT BASICALLY
        // DISSAPEAR SO FAR ONLY
        // DIAMONDS RECREATE
        // TODO DOWHILE LOOP UNTIL
        // getCurrentMap().getBoard()[randomPair[0]][randomPair[1]] -> getcurrentobj IS
        // INSTANCE OF GRASS

        // int[] randomPair = currentMap.randomPair();

        if (currentMap.getBoard()[nextY][nextX].getCurrentObject() instanceof Diamond) {
            int[] randomPair = currentMap.randomPair();
            currentMap.getBoard()[randomPair[0]][randomPair[1]] = new Field(
                    new Diamond(new Coords(randomPair[0], randomPair[1])),
                    new Grass(new Coords(randomPair[0], randomPair[1])));
        }

        this.getCoords().setPosY(nextY);
        this.getCoords().setPosX(nextX);

        currentMap.getBoard()[this.getCoords().getPosY()][this.getCoords().getPosX()].setDefaultObject(this);
    }

    public WorldMap getCurrentMap() {
        return currentMap;
    }
}