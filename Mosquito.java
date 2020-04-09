
public class Mosquito extends Enemy {
    // private Field lastField;
    // private WorldMap currentMap;

    public Mosquito(WorldMap map) {
        super("\u259A", Colours.PURPLE, "Komar", map);
        // this.currentMap = Game.listOfLevels.get("Stage1");
        // Coords randomCoords = this.getCurrentMap().randomPlacementOnMap(this);
        // this.lastField = new Field(new Grass(randomCoords));
    }

    // private WorldMap getCurrentMap() {
    //     return currentMap;
    // }

    // public void setCurrentMap(WorldMap currentMap) {
    //     this.currentMap = currentMap;
    // }
}
