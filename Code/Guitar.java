/**
 * Guitar.java
 * Tyler Brennan
 * Creates a guitar class that covers all attributes associated with a guitar
 **/

import java.lang.Math;
public class Guitar{
    private double price;
    private int serialNum;

    private GuitarSpecifications guitarSpecs;

    /* 
     * Guitar()
     * @param price         Price of the guitar
     * @param serialNum     Serial number of the guitar
     * @param guitarSpecs   Specifications of the guitar
     */
    public Guitar(double price, int serialNum, GuitarSpecifications guitarSpecs){
        setPrice(price);
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
        if(price < 0){
            throw new IllegalArgumentException("Price must not be negative");
        }
        price = Math.round(price * 100);
        this.price = price/100;
    }

    /*
     * toString()
     * @return String   All the information associated with a single guitar
     */
    public String toString(){
        return "Serial Number: " + serialNum + "\nPrice: $" + price + "\n" + guitarSpecs;
    }
}