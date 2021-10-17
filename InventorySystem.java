/**
 * inventorySystem.java
 * Tyler Brennan
 * Maintains the inventory for the store owner and provides necessary functions for maintaining the list of items
 **/

import java.util.HashMap;
import java.util.ArrayList;
public class inventorySystem{
    private ArrayList<guitar> inventory;

    /*
     * inventorySystem()
     */
    public inventorySystem(){
        inventory = new ArrayList<guitar>();
    }

    /*
     * addItem()
     * @param item      Guitar that should be added to the list
     */
    public void addItem(guitar item){
        inventory.add(item);
    }

    /*
     * removeItem()
     * @param serialNum     Serial of the guitar to be removed
     * @return guitar       The removed guitar object if it exists, null otherwise
     */
    public guitar removeItem(int serialNum){
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
     * @return guitar       The guitar object if it exists, null otherwise
     */
    public guitar getItem(int serialNum){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getSerial() == serialNum){
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
     * @return ArrayList<guitar>    Array of guitar object if it exists, null otherwise
     */
    public ArrayList<guitar> getItemSerial(int serialNum){
        ArrayList<guitar> res = new ArrayList<guitar>();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getSerial() == serialNum){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemPrice()
     * @param price                 price of the desired guitar(s)
     * @return ArrayList<guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<guitar> getItemPrice(double price){
        ArrayList<guitar> res = new ArrayList<guitar>();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getPrice() == price){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemModel()
     * @param model                 Guitar model of the desired guitar(s)
     * @return ArrayList<guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<guitar> getItemModel(String model){
        ArrayList<guitar> res = new ArrayList<guitar>();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getModel().equals(model)){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemBrand()
     * @param brand                 Guitar brand of the desired guitar(s)
     * @return ArrayList<guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<guitar> getItemBrand(String brand){
        ArrayList<guitar> res = new ArrayList<guitar>();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getBrand().equals(brand)){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemType()
     * @param type                  Guitar type of the desired guitar(s)
     * @return ArrayList<guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<guitar> getItemType(String type){
        ArrayList<guitar> res = new ArrayList<guitar>();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getType().equals(type)){
                res.add(inventory.get(i));
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemTopWood()
     * @param topWood               Top wood type of the desired guitar(s)
     * @return ArrayList<guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<guitar> getItemTopWood(String topWood){
        ArrayList<guitar> res = new ArrayList<guitar>();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getTopWood().equals(topWood)){
                res.add(inventory.get(i));
                System.out.println("HIT");
            }
        }
        if(res.isEmpty()){ return null; }
        return res;
    }
    /*
     * getItemBottomWood()
     * @param bottomWood            Bottom wood type of the desired guitar(s)
     * @return ArrayList<guitar>    Array of guitar object(s) if they exist, null otherwise
     */
    public ArrayList<guitar> getItemBottomWood(String bottomWood){
        ArrayList<guitar> res = new ArrayList<guitar>();
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getBottomWood().equals(bottomWood)){
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
    public String printSearch(ArrayList<guitar> arr){
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