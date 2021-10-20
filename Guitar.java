/**
 * Guitar.java
 * Tyler Brennan
 * Creates a guitar class that covers all attributes associated with a guitar
**/

import java.lang.Math;
public class Guitar{
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

    private GuitarSpecifications guitarSpecs;

    public Guitar(){
        
    }

    /* 
     * DELETE --------------------------------------------------------------------------
     * @param price         Price of the guitar
     * @param serialNum     Serial number of the guitar
     * @param model         Model of the guitar
     * @param brand         Brand of guitar
     * @param type          Type of guitar
     * @param topWood       Type of top wood
     * @param bottomWood    Type of bottom wood
     */
    public Guitar(double price, int serialNum, String model, String brand, String type, String topWood, String bottomWood){
        price = Math.round(price * 100);
        this.price = price/100;
        this.serialNum = serialNum;
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.topWood = topWood;
        this.bottomWood = bottomWood;
    }

    /* 
     * @param price         Price of the guitar
     * @param serialNum     Serial number of the guitar
     * @param model         Model of the guitar
     * @param guitarSpecs   Specifications of the guitar
     */
    public Guitar(double price, int serialNum, GuitarSpecifications guitarSpecs){
        price = Math.round(price * 100);
        this.price = price/100;
        this.serialNum = serialNum;
        this.guitarSpecs = guitarSpecs;
    }

    /* 
     * getPrice()
     * @return double   Price of the guitar
     */
    public double getPrice(){ 
        return price; 
    }

    /* 
     * getSerial()
     * @return int  Serial number associated with the guitar
     */
    public int getSerial(){ 
        return serialNum; 
    }

    /* 
     * getGuitarSpecifications()
     * @return GuitarSpecifications     Specifications for the specific guitar
     */
    public GuitarSpecifications getGuitarSpecifications(){ 
        return guitarSpecs; 
    }

    /* 
     * setPrice()
     * @param price Price of the guitar
     */
    public void setPrice(double price){ 
        this.price = price; 
    }

    /* 
     * setSerial()
     * @return serial   Serial number associated with the guitar
     */
    public void setSerial(int serialNum){ 
        this.serialNum = serialNum; 
    }

    /* 
     * setGuitarSpecifications()
     * @return guitarSpecs     Specifications for the specific guitar
     */
    public void setGuitarSpecifications(GuitarSpecifications guitarSpecs){ 
        this.guitarSpecs = guitarSpecs; 
    }

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
        return "Serial Number: " + serialNum + "\nPrice: $" + price + "\n" + guitarSpecs;
    }
}