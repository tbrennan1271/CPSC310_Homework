/**
 * UserInput.java
 * Tyler Brennan
 * Used to facilitate the main block of code in pulling in user input by making repetitive code into methods
 **/

import java.util.Scanner;
 public class UserInput{
    private Scanner sc;
    private InventorySystem inventory;


    /*
     * userInput()
     * @param sc       Scanner object
     */
    public UserInput(Scanner sc, InventorySystem inventory){
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
            } catch(IllegalArgumentException e){
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
        return model.toLowerCase();
    }

    /*
     * userBrand()
     * @return Brand    the user inputted brand
     */
    public Brand userBrand(){
        Brand brand;
        System.out.println("Brand: ");
        System.out.println("1) Gibson");
        System.out.println("2) Fender");
        System.out.println("3) Ibanez");
        System.out.println("4) Paul Reed Smith");
        System.out.println("5) Epiphone");
        System.out.println("6) Jackson");
        System.out.println("7) ESP");
        System.out.println("8) Yamaha");
        System.out.println("9) Rickenbacker");
        System.out.println("10) Gretsch");
        System.out.print("Select a brand by using its index: ");
        do{
            try{
                brand = brandSelect();
                if(brand != null){
                    return brand;
                } else{
                    System.out.print("Please enter a valid index: ");
                }
            } catch(Exception e){
                System.out.print("Please enter a valid index: ");
                sc.nextLine();
            }
        } while(true);
    }
    /*
     * userBrandSort()
     * @return Brand    the user inputted brand
     */
    public Brand userBrandSort(){
        System.out.println("Brand: ");
        System.out.println("1) Gibson");
        System.out.println("2) Fender");
        System.out.println("3) Ibanez");
        System.out.println("4) Paul Reed Smith");
        System.out.println("5) Epiphone");
        System.out.println("6) Jackson");
        System.out.println("7) ESP");
        System.out.println("8) Yamaha");
        System.out.println("9) Rickenbacker");
        System.out.println("10) Gretsch");
        System.out.print("Select a brand by using its index: ");
        try{
            return brandSelect();
        } catch(Exception e){
            sc.nextLine();
            return null;
        }
    }

    private Brand brandSelect(){
        int index = sc.nextInt();
        if(index == 1){
            return Brand.GIBSON;
        } else if(index == 2){
            return Brand.FENDER;
        } else if (index == 3){
            return Brand.IBANEZ;
        } else if (index == 4){
            return Brand.PAUL_REED_SMITH;
        } else if (index == 5){
            return Brand.EPIPHONE;
        } else if (index == 6){
            return Brand.JACKSON;
        } else if (index == 7){
            return Brand.ESP;
        } else if (index == 8){
            return Brand.YAMAHA;
        } else if (index == 9){
            return Brand.RICKENBACKER;
        } else if (index == 10){
            return Brand.GRETSCH;
        } else{
            return null;
        }
    }

    /*
     * userType()
     * @return Type     the user inputted type
     */
    public Type userType(){
        Type type;
        System.out.println("Type: ");
        System.out.println("1) Acoustic");
        System.out.println("2) Electric");
        System.out.print("Select a type by using its index: ");
        do{
            try{
                type = typeSelect();
                if(type != null){
                    return type;
                } else{
                    System.out.print("Please enter a valid index: ");
                }
            } catch(Exception e){
                System.out.print("Please enter a valid index: ");
                sc.nextLine();
            }
        } while(true);
    }
    /*
     * userTypeSort()
     * @return Type     the user inputted type
     */
    public Type userTypeSort(){
        System.out.println("Type: ");
        System.out.println("1) Acoustic");
        System.out.println("2) Electric");
        System.out.print("Select a type by using its index: ");
        try{
            return typeSelect();
        } catch(Exception e){
            sc.nextLine();
            return null;
        }
    }

    private Type typeSelect(){
        int index = sc.nextInt();
        if(index == 1){
            return Type.ACOUSTIC;
        } else if(index == 2){
            return Type.ELECTRIC;
        } else{
            return null;
        }
    }

    /*
     * userTopWood()
     * @return Wood     the user inputted wood type
     */
    public Wood userTopWood(){
        Wood topWood;
        System.out.println("Top Wood:");
        System.out.println("1) Rosewood");
        System.out.println("2) Alder");
        System.out.println("3) Mahogany");
        System.out.println("4) Cedar");
        System.out.print("Select a top wood type by using its index: ");
        do{
            try{
                topWood = woodSelect();
                if(topWood != null){
                    return topWood;
                } else{
                    System.out.print("Please enter a valid index: ");
                }
            } catch(Exception e){
                System.out.print("Please enter a valid index: ");
                sc.nextLine();
            }
        } while(true);
    }
    /*
     * userTopWoodSort()
     * @return Wood     the user inputted wood type
     */
    public Wood userTopWoodSort(){
        System.out.println("Top Wood:");
        System.out.println("1) Rosewood");
        System.out.println("2) Alder");
        System.out.println("3) Mahogany");
        System.out.println("4) Cedar");
        System.out.print("Select a top wood type by using its index: ");
        try{
            return woodSelect();
        } catch(Exception e){
            sc.nextLine();
            return null;
        }
    }

    /*
     * userBottomWood()
     * @return Wood     the user inputted wood type
     */
    public Wood userBottomWood(){
        Wood bottomWood;
        System.out.println("Bottom Wood:");
        System.out.println("1) Rosewood");
        System.out.println("2) Alder");
        System.out.println("3) Mahogany");
        System.out.println("4) Cedar");
        System.out.print("Select a bottom wood type by using its index: ");
        do{
            try{
                bottomWood = woodSelect();
                if(bottomWood != null){
                    return bottomWood;
                } else{
                    System.out.print("Please enter a valid index: ");
                }
            } catch(Exception e){
                System.out.print("Please enter a valid index: ");
                sc.nextLine();
            }
        } while(true);
    }
    /*
     * userBottomWoodSort()
     * @return Wood     the user inputted wood type
     */
    public Wood userBottomWoodSort(){
        System.out.println("Bottom Wood:");
        System.out.println("1) Rosewood");
        System.out.println("2) Alder");
        System.out.println("3) Mahogany");
        System.out.println("4) Cedar");
        System.out.print("Select a top wood type by using its index: ");
        try{
            return woodSelect();
        } catch(Exception e){
            sc.nextLine();
            return null;
        }
    }

    private Wood woodSelect(){
        int index = sc.nextInt();
        if(index == 1){
            return Wood.ROSEWOOD;
        } else if(index == 2){
            return Wood.ALDER;
        } else if (index == 3){
            return Wood.MAHOGANY;
        } else if (index == 4){
            return Wood.CEDAR;
        } else{
            return null;
        }
    }
 }