/**
 * guitar.java
 * Tyler Brennan
 * Creates a guitar class that covers all attributes associated with a guitar
**/

import java.lang.Math;
public class guitar{
    private final static String[] WOOD = {"rosewood", "alder", "mahogany", "cedar"};
    private final static String[] TYPE = {"acoustic", "electric"};
    private final static String[] BRAND = {"Gibson", "Fender", "Ibanez", "Paul Reed Smith", "Epiphone", "Jackson", "ESP", "Yamaha", "Rickenbacker", "Gretsch"};
    private double price;
    private int serialNum;
    private String model;
    private String brand;
    private String type;
    private String topWood;
    private String bottomWood;

    /* 
     * guitar()
     * @param price         Price of the guitar
     * @param serialNum     Serial number of the guitar
     * @param model         Model of the guitar
     * @param brand         Brand of guitar
     * @param type          Type of guitar
     * @param topWood       Type of top wood
     * @param bottomWood    Type of bottom wood
     */
    public guitar(double price, int serialNum, String model, String brand, String type, String topWood, String bottomWood){
        price = Math.round(price * 100);
        this.price = price/100;
        this.serialNum = serialNum;
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.topWood = topWood;
        this.bottomWood = bottomWood;
    }

    // GETTERS
    /* 
     * getPrice()
     * @return String   Price of the guitar
     */
    public double getPrice(){ return price; }

    /* 
     * getSerial()
     * @return String   Serial number associated with the guitar
     */
    public int getSerial(){ return serialNum; }

    /* 
     * getModel()
     * @return String   Model of the guitar
     */
    public String getModel(){ return model; }

    /* 
     * getBrand()
     * @return String   Brand of the guitar
     */
    public String getBrand(){ return brand; }

    /* 
     * getType()
     * @return String   Type of the guitar
     */
    public String getType(){ return type; }

    /* 
     * getTopWood()
     * @return String   Top wood used on the guitar
     */
    public String getTopWood(){ return topWood; }

    /* 
     * getBottomWood()
     * @return String   Bottom wood used on the guitar
     */
    public String getBottomWood(){ return bottomWood; }

    /*
     * printWood()
     * @return String   String of all the potential top/bottom woods for the guitar
     */
    public static String printWood(){
        return print(WOOD);
    }

    /*
     * printType()
     * @return String   String of all the potential types of guitar sold
     */
    public static String printType(){
        return print(TYPE);
    }

    /*
     * printBrand()
     * @return String   String of all the potential brands of the guitar
     */
    public static String printBrand(){
        return print(BRAND);
    }

    /*
     * print()
     * Helper function for printWood(), printType(), and printBrand() to print out all the information in each respective list
     * @param  String[] Array of attributes associated with the main function called
     * @return String   String of all the potential attributes of the guitar associated with the list provided
     */
    private static String print(String[] arr){
        String res = "";
        for(int i = 0; i < arr.length; i++){
            res += (i+1) + ") " + arr[i] + "\n";
        }
        return res.substring(0, res.length() - 1);
    }

    /*
    * Selection()
    * @param i          Index of the array of available top/bottom wood choices
    * @return String    The selected attribute
    */
    public static String woodSelection(int i){
        return selection(WOOD, i);
    }

    /*
     * Selection()
     * @param i         Index of the array of available guitar types
     * @return String   The selected attribute
     */
    public static String typeSelection(int i){
        return selection(TYPE, i);
    }

    /*
     * Selection()
     * @param i         Index of the array of available brands
     * @return String   The selected attribute
     */
    public static String brandSelection(int i){
        return selection(BRAND, i);
    }

    /*
    * Selection()
    * Helper function for woodSelection(), TypeSelection(), and BrandSelectiond() to select the user's desired attribute for the corresponding attribute
    * @param i          Index of the array submitted
    * @param String[]   Array associated with the command called
    * @return String    The selected attribute
    */
    private static String selection(String[] arr, int i){
        i -= 1;
        if(i < 0 || i >= arr.length){ return null; }
        else{ return arr[i]; }
    }

    /*
    * woodLen()
    * @return int       length of array
    */
    public static int woodLen(){
        return WOOD.length;
    }

    /*
    * typeLen()
    * @return int       length of array
    */
    public static int typeLen(){
        return TYPE.length;
    }

    /*
    * brandLen()
    * @return int       length of array
    */
    public static int brandLen(){
        return BRAND.length;
    }

    /*
     * toString()
     * @return String   All the information associated with a single guitar
     */
    public String toString(){
        return "Serial Number: " + serialNum + "\nPrice: $" + price +  "\nModel: " + model + "\nBrand: " + brand + "\nType: " + type + "\nTop Wood: " + topWood + "\nBottom Wood: " + bottomWood;
    }
}