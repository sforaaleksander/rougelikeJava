public class Field {
    private GameObject currentObject;
    private GameObject defaultObject;


    public Field(GameObject defaultObject){
        this.currentObject = defaultObject;
        this.defaultObject = defaultObject;
    }

    public Field(GameObject currentObject, GameObject defaultObject){
        this.currentObject = currentObject;
        this.defaultObject = defaultObject;
    }

    public GameObject getCurrentObject(){
        return currentObject;
    }

    public GameObject getDefaultObject(){
        return defaultObject;
    }

	public void setToDefault() {
        this.currentObject = this.defaultObject;
	}

    public void setCurrentObject(GameObject currentObject){
        this.currentObject = currentObject;
    }

    public void setDefaultObject(GameObject defaultObject){
        this.currentObject = defaultObject;
        this.defaultObject = defaultObject;
    }
}