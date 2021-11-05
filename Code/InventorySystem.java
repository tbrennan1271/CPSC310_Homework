/**
 * InventorySystem.java
 * Tyler Brennan
 * Maintains the inventory for the store owner and provides necessary functions for maintaining the list of items
 **/

import java.util.ArrayList;
import java.util.List;
public class InventorySystem{
    private List<Guitar> inventory;

    /*
     * inventorySystem()
     */
    public InventorySystem(){
        inventory = new ArrayList<Guitar>();
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
        if(!notNullParams(price, serialNum, model, brand, type, topWood, bottomWood)){
            throw new IllegalArgumentException("No null parameters allowed");
        } else if(getItem(serialNum) != null){
            throw new IllegalArgumentException("No duplicate serials allowed");
        } else if(price < 0){
            throw new IllegalArgumentException("Price must not be negative");
        }
        GuitarSpecifications guitarSpecs = new GuitarSpecifications(topWood, bottomWood, brand, type, model);
        Guitar guitar = new Guitar(price, serialNum, guitarSpecs);
        inventory.add(guitar);
    }

    private boolean notNullParams(double price, int serialNum, String model, Brand brand, Type type, Wood topWood, Wood bottomWood) {
        return model != null && brand != null && type != null && topWood != null && bottomWood != null;
    }
    

    /*
     * removeItem()
     * Specific approach to removal by removing the guitar with exact serial number
     * @param serialNum     Serial of the guitar to be removed
     * @return Guitar       The removed guitar object if it exists, an empty list otherwise
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
     * removeItem()
     * Applies a more general approach to removal by removing a guitar with specific attributes as opposed to serial
     * @param specs         GuitarSpecifications of the guitar to be removed (more general approach to removal)
     * @return Guitar       The removed guitar object if it exists, an empty list otherwise
     */
    public List<Guitar> removeItem(GuitarSpecifications specs){
        List<Guitar> removed = new ArrayList<Guitar>();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getGuitarSpecifications().compareTo(specs)){
                removed.add(inventory.remove(i));
            }
        }
        return removed;
    }

    /*
     * getItem()
     * @param serialNum     Serial of the desired guitar
     * @return Guitar       The guitar list if it exists, null otherwise
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
     * search()
     * @param specs             Guitar specifications of desired guitar
     * @return List<Guitar>     Guitar list if it exists, an empty list otherwise
     */
    public List<Guitar> search(GuitarSpecifications specs){
        List<Guitar> res = new ArrayList<Guitar>();
        Guitar guitar;
        GuitarSpecifications guitarSpecs;
        for(int i = 0; i < inventory.size(); i++){
            guitar = inventory.get(i);
            guitarSpecs = guitar.getGuitarSpecifications();
            if(guitarSpecs.compareTo(specs)){
                res.add(inventory.get(i));
            }
        }
        return res;
    }

    /*
     * printSearch()
     * @return String   All the information associated with a each guitar within a search
     */
    public String printSearch(List<Guitar> arr){
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