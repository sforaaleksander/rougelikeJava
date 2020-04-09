
public class Swamp extends GameObject {
    // private

    public Swamp(Coords coords) {
        super("\u2588", Colours.CYAN, "Bagno", coords);
        // TODO Auto-generated constructor stub
    }

    public void growSwamp(WorldMap map) {

    }

    @Override
    public void interact(Player player) {
        int lastPosY = player.getLastField().getCurrentObject().getCoords().getPosY();
        int lastPosX = player.getLastField().getCurrentObject().getCoords().getPosX();

        GameObject nextField = findNextField(lastPosY, lastPosX, this.getCoords().getPosY(), this.getCoords().getPosX(),
        player.getCurrentMap());

        if (nextField.getName().equals("Grass")){
            player.getCoords().setPosY(nextField.getCoords().getPosY());
            player.getCoords().setPosX(nextField.getCoords().getPosX());
            player.getLastField().setToDefault();
        } else {
            //game over
        }
        }

    

    public GameObject findNextField(int lastPosY, int lastPosX, int posY, int posX, WorldMap map) {
        if (lastPosY > posY) {
            GameObject nextStep = map.getBoard()[this.getCoords().getPosY() - 1][this.getCoords().getPosX()]
                    .getDefaultObject();
            return nextStep;
        } else if (lastPosY < posY) {
            GameObject nextStep = map.getBoard()[this.getCoords().getPosY() + 1][this.getCoords().getPosX()]
                    .getDefaultObject();
            return nextStep;
        } else if (lastPosX > posX) {
            GameObject nextStep = map.getBoard()[this.getCoords().getPosY()][this.getCoords().getPosX() - 1]
                    .getDefaultObject();
            return nextStep;
        } else if (lastPosX < posX) {
            GameObject nextStep = map.getBoard()[this.getCoords().getPosY()][this.getCoords().getPosX() + 1]
                    .getDefaultObject();
            return nextStep;
        }
        return null;
    }

}