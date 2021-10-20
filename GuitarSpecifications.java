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

    public GuitarSpecifications() {
        
    }

    public GuitarSpecifications(Wood topWood, Wood bottomWood, Brand brand, Type type, String model){
        this.topWood = topWood;
        this.bottomWood = bottomWood;
        this.brand = brand;
        this.type = type;
        this.model = model;
    }

    public void setTopWood(Wood topWood){
        this.topWood = topWood;
    }

    public void setBottomWood(Wood bottomWood){
        this.bottomWood = bottomWood;
    }

    public void setBrand(Brand brand){
        this.brand = brand;
    }

    public void setType(Type type){
        this.type = type;
    }

    public void setModel(String model){
        this.model = model;
    }


    public Wood getTopWood(){
        return topWood;
    }

    public Wood getBottomWood(){
        return bottomWood;
    }

    public Brand getBrand(){
        return brand;
    }

    public Type getType(){
        return type;
    }

    public String getModel(){
        return model;
    }

    public String toString(){
        return "Model: " + model + "\nBrand: " + brand + "\nType: " + type + "\nTop Wood: " + topWood + "\nBottom Wood: " + bottomWood;
    }

    public boolean compareTo(GuitarSpecifications specs){
        if(specs.getTopWood() != null && topWood != null && specs.getTopWood() != topWood){
            return false;
        } else if(specs.getBottomWood() != null && bottomWood != null && specs.getBottomWood() != bottomWood){
            return false;
        }else if(specs.getBrand() != null && brand != null && specs.getBrand() != brand){
            return false;
        }else if(specs.getType() != null && type != null && specs.getType() != type){
            return false;
        }else if(!specs.getModel().equals("") && !model.equals("") && !specs.getModel().equals(model)){
            return false;
        }else{
            return true;
        }
    }
}