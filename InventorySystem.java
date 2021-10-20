/**
 * InventorySystem.java
 * Tyler Brennan
 * Maintains the inventory for the store owner and provides necessary functions for maintaining the list of items
 **/

import java.util.HashMap;
import java.util.ArrayList;
public class InventorySystem{
    private ArrayList<Guitar> inventory;

    /*
     * inventorySystem()
     */
    public InventorySystem(){
        inventory = new ArrayList<Guitar>();
    }

    /*
     * addItem()
     * @param item      Guitar that should be added to the list
     */
    public void addItem(Guitar item){
        inventory.add(item);
    }

    /*
     * addGuitar()
     * @param price         Price of the guitar
     * @param serialNum     Serial number of the guitar
     * @param model         Model of the guitar
     * @param guitarSpecs   Specifications of the guitar
     * @param model         Model of the guitar
     * @param brand         Brand of guitar
     * @param type          Type of guitar
     * @param topWood       Type of top wood
     * @param bottomWood    Type of bottom wood
     */
    public void addGuitar(double price, int serialNum, String model, Brand brand, Type type, Wood topWood, Wood bottomWood){
        GuitarSpecifications guitarSpecs = new GuitarSpecifications(topWood, bottomWood, brand, type, model);
        Guitar guitar = new Guitar(price, serialNum, guitarSpecs);
        inventory.add(guitar);
    }
    

    /*
     * removeItem()
     * @param serialNum     Serial of the guitar to be removed
     * @return Guitar       The removed guitar object if it exists, null otherwise
     */
    public Guitar removeItem(int serialNum){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getSerial() == serialNum){
                return inventory.remove(i);
            }
        }
        return null;
    }

    /*
     * getItem()
     * @param serialNum     Serial of the desired guitar
     * @return Guitar       The guitar object if it exists, null otherwise
     */
    public Guitar getItem(int serialNum){
        Guitar guitar;
        int currSerialNum;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            currSerialNum = guitar.getSerial();
            if(currSerialNum == serialNum){
                return inventory.get(i);
            }
        }
        return null;
    }
    /*
     * getItemSerial()
     * Serial Numbers are distinct
     * Returns an ArrayList to work better in coordination with other search functions
     * @param serialNum             Serial of the desired guitar
     * @return ArrayList<Guitar>    Array of guitar object if it exists, null otherwise
     */
    public ArrayList<Guitar> getItemSerial(int serialNum){
        ArrayList<Guitar> res = new ArrayList<Guitar>();
        Guitar guitar;
        int currSerialNum;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            currSerialNum = guitar.getSerial();
            if(currSerialNum == serialNum){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemPrice()
     * @param price                 price of the desired guitar(s)
     * @return ArrayList<Guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<Guitar> getItemPrice(double price){
        ArrayList<Guitar> res = new ArrayList<Guitar>();
        Guitar guitar;
        double currPrice;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            currPrice = guitar.getPrice();
            if(currPrice == price){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemModel()
     * @param model                 Guitar model of the desired guitar(s)
     * @return ArrayList<Guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<Guitar> getItemModel(String model){
        ArrayList<Guitar> res = new ArrayList<Guitar>();
        Guitar guitar;
        GuitarSpecifications guitarSpecs;
        String currModel;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            guitarSpecs = guitar.getGuitarSpecifications();
            currModel = guitarSpecs.getModel();
            if(currModel.equals(model)){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemBrand()
     * @param brand                 Guitar brand of the desired guitar(s)
     * @return ArrayList<Guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<Guitar> getItemBrand(Brand brand){
        ArrayList<Guitar> res = new ArrayList<Guitar>();
        Guitar guitar;
        GuitarSpecifications guitarSpecs;
        Brand currBrand;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            guitarSpecs = guitar.getGuitarSpecifications();
            currBrand = guitarSpecs.getBrand();
            if(currBrand.equals(brand)){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemType()
     * @param type                  Guitar type of the desired guitar(s)
     * @return ArrayList<Guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<Guitar> getItemType(Type type){
        ArrayList<Guitar> res = new ArrayList<Guitar>();
        Guitar guitar;
        GuitarSpecifications guitarSpecs;
        Type currType;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            guitarSpecs = guitar.getGuitarSpecifications();
            currType = guitarSpecs.getType();
            if(currType.equals(type)){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemTopWood()
     * @param topWood               Top wood type of the desired guitar(s)
     * @return ArrayList<Guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<Guitar> getItemTopWood(Wood topWood){
        ArrayList<Guitar> res = new ArrayList<Guitar>();
        Guitar guitar;
        GuitarSpecifications guitarSpecs;
        Wood currTopWood;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            guitarSpecs = guitar.getGuitarSpecifications();
            currTopWood = guitarSpecs.getTopWood();
            if(currTopWood.equals(topWood)){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemBottomWood()
     * @param bottomWood            Bottom wood type of the desired guitar(s)
     * @return ArrayList<Guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<Guitar> getItemBottomWood(Wood bottomWood){
        ArrayList<Guitar> res = new ArrayList<Guitar>();
        Guitar guitar;
        GuitarSpecifications guitarSpecs;
        Wood currBottomWood;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            guitarSpecs = guitar.getGuitarSpecifications();
            currBottomWood = guitarSpecs.getBottomWood();
            if(currBottomWood.equals(bottomWood)){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }

    public ArrayList<Guitar> search(GuitarSpecifications specs){
        ArrayList<Guitar> res = new ArrayList<Guitar>();
        Guitar guitar;
        GuitarSpecifications guitarSpecs;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            guitarSpecs = guitar.getGuitarSpecifications();
            if(guitarSpecs.compareTo(specs)){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }

    /*
     * toString()
     * @return String   All the information associated with a each guitar
     */
    public String printSearch(ArrayList<Guitar> arr){
        if(arr.isEmpty()){
            return "\nThere are no items\n";
        }
        String res = "";
        for(int i = 0; i < arr.size(); i++){
            res += "\n" + arr.get(i) + "\n";
        }
        return res;
    }

    /*
     * toString()
     * @return String   All the information associated with a each guitar
     */
    public String toString(){
        return printSearch(inventory);
    }
}