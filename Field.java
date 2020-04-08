public class Field {
    private GameObject currentObject;
    private GameObject defaultObject;


    public Field(GameObject gameObject){
        this.gameObject = gameObject;
    }

    public GameObject getGameObject(){
        return gameObject;
    }

	public void setToDefault() {
	}

}