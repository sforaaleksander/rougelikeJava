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
    private int currentLvl;    

    public Game() {
        listOfLevels = createListofLevels();
        this.currentMap = listOfLevels.get("Stage1");
        this.player = new Player(currentMap);
        // this.player.setCurrentMap(listOfLevels.get("Stage1"));
        this.currentLvl=1;
        // uncment below to debug
        //UI.displayMap(player.getCurrentMap());

    }

    private Map<String, WorldMap> createListofLevels() {
        Map<String, WorldMap> listOfLevels = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            listOfLevels.put("Stage" + (i + 1), new WorldMap(10 + 4 * i, 6 + 2 * i, 15 + i*5, 1 + i, (2*i+4)));
        }
        return listOfLevels;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        Engine.clearScreen();

        char ch = event.getKeyChar();
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
        //currentMap.getBoard()[player.getCoords().getPosY()][player.getCoords().getPosX()].setCurrentObject(player);
        //TODO NULL POINTER EXEPTION WHEN GETTING CURRENT MAP BECAUSE WE ARE OUT OF LISTOFMMAPS
        for (ActiveObject activeObject : currentMap.getActiveObjects()) {
            activeObject.performAct();
        }

        currentMap.getBoard()[player.getCoords().getPosY()][player.getCoords().getPosX()].setCurrentObject(player);

        UI.displayMap(player.getCurrentMap());
        UI.bottomDisplay(player);
        //TODO create new methods for below ifs
        if (player.getHp()==0) {
            Engine.clearScreen();
            System.out.println("YOU LOST!!");
            //restart game TODO
            System.exit(0);
        }
        if (player.getCollectedDiamonds() == currentMap.getNumberOfDiamonds()){
            Engine.clearScreen();
            if ((getCurrentLvl())<listOfLevels.size()){
                setCurrentLvl((getCurrentLvl() +1));
                System.out.println("STAGE " + getCurrentLvl() + " !!\nPress any key to start new stage!");
                currentMap = listOfLevels.get("Stage"+ getCurrentLvl());
                player.setCurrentMap(currentMap);
                player.setCollectedDiamonds(0);
                return;
            }    
            Engine.clearScreen();        
            System.out.println("YOU WIN!!");
            System.exit(0);
        }
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

    public void setCurrentLvl(int currentLvl) {
        this.currentLvl = currentLvl;
    }

    public int getCurrentLvl() {
        return currentLvl;
    }

}