/**
 * GuitarSpecifications.java
 * Tyler Brennan
 * A class that covers the important specifications of a guitar
 **/

public class GuitarSpecifications{
    private Wood topWood;
    private Wood bottomWood;
    private Brand brand;
    private Type type;
    private String model;

    /* 
     * GuitarSpecifications()
     * @param topWood       Top wood of the guitar
     * @param bottomWood    Bottom wood of the guitar
     * @param brand         Brand of the guitar
     * @param type          Type of  guitar
     * @param model         Model of the guitar
     */
    public GuitarSpecifications(Wood topWood, Wood bottomWood, Brand brand, Type type, String model){
        this.topWood = topWood;
        this.bottomWood = bottomWood;
        this.brand = brand;
        this.type = type;
        this.model = model;
    }

    /* 
     * setTopWood()
     * @param topWood   Top wood of the guitar
     */
    public void setTopWood(Wood topWood){
        this.topWood = topWood;
    }

    /* 
     * setBottomWood()
     * @param bottomWood    Bottom wood of the guitar
     */
    public void setBottomWood(Wood bottomWood){
        this.bottomWood = bottomWood;
    }

    /* 
     * setBrand()
     * @param brand     Brand of the guitar
     */
    public void setBrand(Brand brand){
        this.brand = brand;
    }

    /* 
     * setType()
     * @param type      Type of  guitar
     */
    public void setType(Type type){
        this.type = type;
    }

    /* 
     * setModel()
     * @param model     Model of the guitar
     */
    public void setModel(String model){
        this.model = model;
    }


    /* 
     * getTopWood()
     * @return Wood     Top wood of the guitar
     */
    public Wood getTopWood(){
        return topWood;
    }

    /* 
     * getBottomWood()
     * @return Wood     Bottom wood of the guitar
     */
    public Wood getBottomWood(){
        return bottomWood;
    }

    /* 
     * getBrand()
     * @return Brand    Brand of the guitar
     */
    public Brand getBrand(){
        return brand;
    }

    /* 
     * getType()
     * @return Type     Type of  guitar
     */
    public Type getType(){
        return type;
    }

    /* 
     * getModel()
     * @return String   Model of the guitar
     */
    public String getModel(){
        return model;
    }

    /* 
     * toString()
     * @return String   String representation of a GuitarSpecification object
     */
    public String toString(){
        return "Model: " + model + "\nBrand: " + brand + "\nType: " + type + "\nTop Wood: " + topWood + "\nBottom Wood: " + bottomWood;
    }

    /* 
     * compareTo()
     * @param specs     GuitarSpecification object to compare to
     * @return boolean  True if the attributes of two different GuitarSpecification objects are the same, false if not
     */
    public boolean compareTo(GuitarSpecifications specs){
        if(specs.getTopWood() != null && topWood != null && specs.getTopWood() != topWood){
            return false;
        } else if(specs.getBottomWood() != null && bottomWood != null && specs.getBottomWood() != bottomWood){
            return false;
        } else if(specs.getBrand() != null && brand != null && specs.getBrand() != brand){
            return false;
        } else if(specs.getType() != null && type != null && specs.getType() != type){
            return false;
        } else if(specs.getModel() != null && model != null && !specs.getModel().equals("") && !model.equals("") && !specs.getModel().equals(model)){
            return false;
        } else{
            return true;
        }
    }
} 