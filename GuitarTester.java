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
        inventorySystem inventory = new inventorySystem();
        userInput usrIn = new userInput(sc, inventory);
        ArrayList<guitar> search = null;
        guitar item;
        int index = 0;
        int selection = 0;
        Double price = 0.0;
        int serial = 0;
        String model = "";
        String brand = "";
        String type = "";
        String topWood = "";
        String bottomWood = "";
        boolean validInput = false;

        while(selection != 6){
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
                    if(selection > 6 || selection < 1){
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
                System.out.println("1) Serial number");
                System.out.println("2) Price");
                System.out.println("3) Model");
                System.out.println("4) Brand");
                System.out.println("5) Type");
                System.out.println("6) Top Wood");
                System.out.println("7) Bottom Wood");
                System.out.print("Which attribute would you like to search by: ");
                do{
                    try{
                        index = sc.nextInt();
                        if(index > 8 || index < 1){
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

                if(index == 1){
                    System.out.print("Serial number: ");
                    do{
                        try{
                            serial = sc.nextInt();
                            break;
                        } catch(Exception e){
                            System.out.print("Sorry that serial number is invalid, please enter another: ");
                            sc.nextLine();
                        }
                    } while(true);
                    search = inventory.getItemSerial(serial);
                }

                else if(index == 2){
                    search = inventory.getItemPrice(usrIn.userPrice());

                }

                else if(index == 3){
                    search = inventory.getItemModel(usrIn.userModel());

                }

                else if(index == 4){
                    search = inventory.getItemBrand(usrIn.userBrand());

                }

                else if(index == 5){
                    search = inventory.getItemType(usrIn.userType());

                }

                else if(index == 6){
                    search = inventory.getItemTopWood(usrIn.userTopWood());

                }
                
                else if(index == 7){
                    search = inventory.getItemBottomWood(usrIn.userBottomWood());

                }

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

                item = new guitar(price, serial, model, brand, type, topWood, bottomWood);
                inventory.addItem(item);
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
                guitar replace;
                if(item == null){
                    System.out.println("This item does not exist");
                } else{
                    int input = 0;
                    while(input != 8){
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
                                if(input > 8 || input < 1){
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
                            inventory.removeItem(item.getSerial());
                            replace = new guitar(item.getPrice(), usrIn.userSerial(), item.getModel(), item.getBrand(), item.getType(), item.getTopWood(), item.getBottomWood());
                            item = replace;
                            inventory.addItem(replace);
                        }
                        else if(input == 2){
                            inventory.removeItem(item.getSerial());
                            replace = new guitar(usrIn.userPrice(), item.getSerial(), item.getModel(), item.getBrand(), item.getType(), item.getTopWood(), item.getBottomWood());
                            inventory.addItem(replace);
                            sc.nextLine();
                        }
                        else if(input == 3){
                            inventory.removeItem(item.getSerial());
                            replace = new guitar(item.getPrice(), item.getSerial(), usrIn.userModel(), item.getBrand(), item.getType(), item.getTopWood(), item.getBottomWood());
                            inventory.addItem(replace);
                        }
                        else if(input == 4){
                            inventory.removeItem(item.getSerial());
                            replace = new guitar(item.getPrice(), item.getSerial(), item.getModel(), usrIn.userBrand(), item.getType(), item.getTopWood(), item.getBottomWood());
                            inventory.addItem(replace);
                        }
                        else if(input == 5){
                            inventory.removeItem(item.getSerial());
                            replace = new guitar(item.getPrice(), item.getSerial(), item.getModel(), item.getBrand(), usrIn.userType(), item.getTopWood(), item.getBottomWood());
                            inventory.addItem(replace);
                        }
                        else if(input == 6){
                            inventory.removeItem(item.getSerial());
                            replace = new guitar(item.getPrice(), item.getSerial(), item.getModel(), item.getBrand(), item.getType(), usrIn.userTopWood(), item.getBottomWood());
                            inventory.addItem(replace);
                        }
                        else if(input == 7){
                            inventory.removeItem(item.getSerial());
                            replace = new guitar(item.getPrice(), item.getSerial(), item.getModel(), item.getBrand(), item.getType(), item.getTopWood(), usrIn.userBottomWood());
                            inventory.addItem(replace);
                        }
                    item = inventory.getItem(item.getSerial());
                    }
                }
            }
            else if (selection == 5) {
                System.out.print("List of guitars:" + inventory);
            }
            else if (selection != 6) {
                System.out.println("Please select a value between 1 and 5");
            }
            System.out.println();
        }
    }
}