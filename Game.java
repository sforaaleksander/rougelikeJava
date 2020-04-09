import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class Game extends KeyAdapter {
    private Map<String, WorldMap> listOfLevels;
    private List<WorldMap> maps;
    private Player player;
    private WorldMap currentMap;

    public Game() {
        listOfLevels = createListofLevels();
        this.currentMap = listOfLevels.get("Stage1");
        this.player = new Player(currentMap);
        // this.player.setCurrentMap(listOfLevels.get("Stage1"));
        UI.displayMap(player.getCurrentMap());

    }

    private Map<String, WorldMap> createListofLevels() {
        Map<String, WorldMap> listOfLevels = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            listOfLevels.put("Stage" + (i + 1), new WorldMap(5 + 2 * i, 6 + 2 * i, 3 + i, 1 + i));
        }
        return listOfLevels;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Engine.clearScreen();

        char ch = event.getKeyChar();
        System.out.println((int) ch);

        switch (ch) {
            case 'w':
                player.playerMove(Coords.UP);
                break;
            case 's':
                player.playerMove(Coords.DOWN);
                break;
            case 'a':
                player.playerMove(Coords.LEFT);
                break;
            case 'd':
                player.playerMove(Coords.RIGHT);
                break;
        }
        // player.getCurrentMap().getBoard()[][].setCurrentObject(player);
        for (ActiveObject activeObject : currentMap.getActiveObjects()) {
            activeObject.performAct();
        }

        currentMap.getBoard()[player.getCoords().getPosY()][player.getCoords().getPosX()].setCurrentObject(player);

        UI.displayMap(player.getCurrentMap());
        UI.bottomDisplay(player);
    }

    public Map<String, WorldMap> getListOfLevels() {
        return listOfLevels;
    }

    public void setCurrentMap(WorldMap currentMap) {
        this.currentMap = currentMap;
    }

    public WorldMap getCurrentMap() {
        return currentMap;
    }

}