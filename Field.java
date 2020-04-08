public class Field {
    private GameObject gameObject;

    public Field(GameObject gameObject){
        this.gameObject = gameObject;
    }

    public GameObject getGameObject(){
        return gameObject;
    }

    public void setGameObject(GameObject go){
        this.gameObject = go;
    }
}