/**
 * userInput.java
 * Tyler Brennan
 * Used to facilitate the main block of code in pulling in user input by making repetitive code into methods
 **/

import java.util.Scanner;
 public class userInput{
    Scanner sc;
    inventorySystem inventory;


    /*
     * userInput()
     * @param sc       Scanner object
     */
    public userInput(Scanner sc, inventorySystem inventory){
        this.sc = sc;
        this.inventory = inventory;
    }

    /*
     * userSerial()
     * @return int      the user inputted serial number
     */
    public int userSerial(){
        int serial;
        System.out.print("Serial number: ");
        do{
            try{
                serial = sc.nextInt();
                if(inventory.getItem(serial) != null){
                    System.out.print("Sorry that serial number was already used, please enter another: ");
                    continue;
                }
                return serial;
            } catch(Exception e){
                System.out.print("Sorry that serial number is invalid, please enter another: ");
                sc.nextLine();
            }
        } while(true);
        
    }

    /*
     * userPrice()
     * @return double       the user inputted price
     */
    public double userPrice(){
        double price;
        System.out.print("Price: ");
        do{
            try{
                price = sc.nextDouble();
                if(price < 0.0){
                    System.out.print("Enter a price at or above $0: ");
                    continue;
                }
                return price;
            } catch(Exception e){
                System.out.print("Sorry that price is invalid, please enter another: ");
                sc.nextLine();
            }
        } while(true);
    }

    /*
     * userModel()
     * @return String       the user inputted model
     */
    public String userModel(){
        String model;
        sc.nextLine();
        System.out.print("Model: ");
        model = sc.nextLine();
        return model;
    }

    /*
     * userBrand()
     * @return String       the user inputted brand
     */
    public String userBrand(){
        String brand;
        int index;
        System.out.println("Brand: ");
        System.out.println(guitar.printBrand());
        System.out.print("Select a brand by using its index: ");
        do{
            try{
                index = sc.nextInt();
                brand = guitar.brandSelection(index);
                if(index < 1 || index > guitar.brandLen()){
                    System.out.print("Please enter a valid index: ");
                    continue;
                }
                return brand;
            } catch(Exception e){
                System.out.print("Please enter a valid index: ");
                sc.nextLine();
            }
        } while(true);
    }

    /*
     * userType()
     * @return String       the user inputted type
     */
    public String userType(){
        String type;
        int index;
        System.out.println("Type: ");
        System.out.println(guitar.printType());
        System.out.print("Select a type by using its index: ");
        do{
            try{
                index = sc.nextInt();
                type = guitar.typeSelection(index);
                if(index < 1 || index > guitar.typeLen()){
                    System.out.print("Please enter a valid index: ");
                    continue;
                }
                return type;
            } catch(Exception e){
                System.out.print("Please enter a valid index: ");
                sc.nextLine();
            }
        } while(true);
    }

    /*
     * userTopWood()
     * @return String       the user inputted wood type
     */
    public String userTopWood(){
        String topWood;
        int index;
        System.out.println("Top Wood:");
        System.out.println(guitar.printWood());
        System.out.print("Select a top wood type by using its index: ");
        do{
            try{
                index = sc.nextInt();
                topWood = guitar.woodSelection(index);
                if(index < 1 || index > guitar.woodLen()){
                    System.out.print("Please enter a valid index: ");
                    continue;
                }
                return topWood;
            } catch(Exception e){
                System.out.print("Please enter a valid index: ");
                sc.nextLine();
            }
        } while(true);
    }

    /*
     * userBottomWood()
     * @return String       the user inputted wood type
     */
    public String userBottomWood(){
        String bottomWood;
        int index;
        System.out.println("Bottom Wood:");
        System.out.println(guitar.printWood());
        System.out.print("Select a bottom wood type by using its index: ");
        do{
            try{
                index = sc.nextInt();
                bottomWood = guitar.woodSelection(index);
                if(index < 1 || index > guitar.woodLen()){
                    System.out.print("Please enter a valid index: ");
                    continue;
                }
                return bottomWood;
            } catch(Exception e){
                System.out.print("Please enter a valid index: ");
                sc.nextLine();
            }
        } while(true);
    }
 }