/**
 * GuitarTester.java
 * Tyler Brennan
 * Retrieves user information and maintains an inventory of guitars/allows the user to search for guitars
 **/

import java.util.Scanner;
import java.util.ArrayList;
public class GuitarTester{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        InventorySystem inventory = new InventorySystem();
        UserInput usrIn = new UserInput(sc, inventory);
        ArrayList<Guitar> search = null;
        GuitarSpecifications guitarSpecs;
        Guitar item;
        int index = 0;
        int selection = 0;
        Double price = 0.0;
        int serial = 0;
        String model = "";
        Brand brand;
        Type type;
        Wood topWood;
        Wood bottomWood;
        int numSelections;
        boolean validInput = false;

        while(selection != 6){
            numSelections = 6;
            System.out.println("1) Search");
            System.out.println("2) Add an item");
            System.out.println("3) Remove an item");
            System.out.println("4) Modify an entry");
            System.out.println("5) Display inventory");
            System.out.println("6) Quit");
            System.out.print("Please select what you want to do: ");
            do{
                try{
                    selection = sc.nextInt();
                    if(selection > numSelections || selection < 1){
                        System.out.print("Please enter a valid index: ");
                        continue;
                    }
                    validInput = true;
                } catch(Exception e){
                    System.out.print("Please enter a valid index: ");
                    sc.nextLine();
                }
            } while(!validInput);
            validInput = false;

            // --------------- ITEM SEARCH ---------------
            if (selection == 1){
                GuitarSpecifications searchGuitarSpecs = new GuitarSpecifications();
                Guitar searchGuitar = new Guitar();
                System.out.println("Select the attributes of the guitar you would like to view");
                System.out.println("Press enter if you have no preference in guitar models:");
                model = usrIn.userModel();
                System.out.println("Input any other index else if you have no preference for the following:");
                brand = usrIn.userBrandSort();
                type = usrIn.userTypeSort();
                topWood = usrIn.userTopWoodSort();
                bottomWood = usrIn.userBottomWoodSort();
                guitarSpecs = new GuitarSpecifications(topWood, bottomWood, brand, type, model);
                search = inventory.search(guitarSpecs);
                if(search == null){ 
                    System.out.println("No items match your search");
                } else{
                    System.out.print("These guitars match your search:" + inventory.printSearch(search));
                }
            }

            // --------------- ADD AN ITEM --------------- 
            else if (selection == 2){
                System.out.println("Please enter the specific information for the item you want to add:");
                serial = usrIn.userSerial();
                price = usrIn.userPrice();
                model = usrIn.userModel();
                brand = usrIn.userBrand();
                type = usrIn.userType();
                topWood = usrIn.userTopWood();
                bottomWood = usrIn.userBottomWood();
                inventory.addGuitar(price, serial, model, brand, type, topWood, bottomWood);
            }

            // --------------- ITEM REMOVAL --------------- 
            else if (selection == 3){
                System.out.print("Please enter the serial number of the item you want to remove: ");
                do{
                    try{
                        selection = sc.nextInt();
                        validInput = true;
                    } catch(Exception e){
                        System.out.print("Please enter a valid index: ");
                        sc.nextLine();
                    }
                } while(!validInput);
                validInput = false;
                item = inventory.removeItem(selection);
                if (item == null){
                    System.out.println("This item does not exist");
                } else{
                    System.out.println("Item has been removed:");
                    System.out.println(item);
                }
            }

            // --------------- ITEM MODIFICATION --------------- 
            else if (selection == 4){
                System.out.print("Enter the serial number of the item you wish to modify: ");
                item = inventory.getItem(sc.nextInt());
                Guitar replace;
                if(item == null){
                    System.out.println("This item does not exist");
                } else{
                    int input = 0;
                    while(input != 8){
                        numSelections = 8;
                        System.out.println("1) Serial number");
                        System.out.println("2) Price");
                        System.out.println("3) Model");
                        System.out.println("4) Brand");
                        System.out.println("5) Type");
                        System.out.println("6) Top Wood");
                        System.out.println("7) Bottom Wood");
                        System.out.println("8) Quit");
                        System.out.print("Which aspect of this item would you like to modify: ");
                        do{
                            try{
                                input = sc.nextInt();
                                if(input > numSelections || input < 1){
                                    System.out.print("Please enter a valid index: ");
                                    continue;
                                }
                                validInput = true;
                            } catch(Exception e){
                                System.out.print("Please enter a valid index: ");
                                sc.nextLine();
                            }
                        } while(!validInput);
                        validInput = false;
                        if(input == 1){
                            item = inventory.getItem(item.getSerial());
                            item.setSerial(usrIn.userSerial());
                        }
                        else if(input == 2){
                            item = inventory.getItem(item.getSerial());
                            item.setPrice(usrIn.userPrice());
                            sc.nextLine();
                        }
                        else if(input == 3){
                            item = inventory.getItem(item.getSerial());
                            guitarSpecs = item.getGuitarSpecifications();
                            guitarSpecs.setModel(usrIn.userModel());
                            item.setGuitarSpecifications(guitarSpecs);
                        }
                        else if(input == 4){
                            item = inventory.getItem(item.getSerial());
                            guitarSpecs = item.getGuitarSpecifications();
                            guitarSpecs.setBrand(usrIn.userBrand());
                            item.setGuitarSpecifications(guitarSpecs);
                        }
                        else if(input == 5){
                            inventory.getItem(item.getSerial());
                            guitarSpecs = item.getGuitarSpecifications();
                            guitarSpecs.setType(usrIn.userType());
                            item.setGuitarSpecifications(guitarSpecs);
                        }
                        else if(input == 6){
                            item = inventory.getItem(item.getSerial());
                            guitarSpecs = item.getGuitarSpecifications();
                            guitarSpecs.setTopWood(usrIn.userTopWood());
                            item.setGuitarSpecifications(guitarSpecs);
                        }
                        else if(input == 7){
                            item = inventory.getItem(item.getSerial());
                            guitarSpecs = item.getGuitarSpecifications();
                            guitarSpecs.setBottomWood(usrIn.userBottomWood());
                            item.setGuitarSpecifications(guitarSpecs);
                        }
                    item = inventory.getItem(item.getSerial());
                    }
                }
            }
            else if (selection == 5) {
                System.out.print("List of guitars:" + inventory);
            }
        }
    }
}