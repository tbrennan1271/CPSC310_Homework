/**
 * GuitarInventoryTester.java
 * Tyler Brennan
 * Runs multiple tests to check how well the inventory system works
 **/

public class GuitarInventoryTester{
    private static InventorySystem inventory = new InventorySystem();
    private static GuitarSpecifications guitarSpecs;
    public static void main(String[] args){
        duplicateSerialTest();
        removalIndexTest();
        removalGuitarSpecificationsTest();
        nullAdditionTest();
        modifyTest();
        multipleItemSearchTest();
        negativePriceTest();
    }

    private static void duplicateSerialTest(){
        System.out.println("Duplicate Serial Number Test:");
        try{
            inventory.addGuitar(2, 1, "Serial 1", Brand.GIBSON, Type.ELECTRIC, Wood.CEDAR, Wood.CEDAR);
            inventory.addGuitar(2, 1, "Serial 1", Brand.GIBSON, Type.ELECTRIC, Wood.CEDAR, Wood.CEDAR);
        } catch(IllegalArgumentException e){
            System.out.print("IllegalArgumentException caught: ");
            System.out.println(e.getMessage());
        }

        inventory = new InventorySystem();
        System.out.println("-------------------------------------------------");
    }

    private static void removalIndexTest(){
        System.out.println("Remove Items by Index Test:");
        int serial = 1;
        inventory.addGuitar(2, serial, "Removal Guitar", Brand.GIBSON, Type.ELECTRIC, Wood.CEDAR, Wood.CEDAR);
        inventory.removeItem(serial);
        System.out.println(inventory);

        inventory = new InventorySystem();
        System.out.println("-------------------------------------------------");
    }
    
    private static void removalGuitarSpecificationsTest(){
        System.out.println("Remove Items by GuitarSpecifications Test:");
        GuitarSpecifications specs = new GuitarSpecifications(Wood.CEDAR, Wood.CEDAR, Brand.GIBSON, Type.ELECTRIC, "Replacement Guitar");
        inventory.addGuitar(2, 1, "Replacement Guitar", Brand.GIBSON, Type.ELECTRIC, Wood.CEDAR, Wood.CEDAR);
        inventory.removeItem(specs);
        System.out.println(inventory);

        inventory = new InventorySystem();
        System.out.println("-------------------------------------------------");
    }

    public static void nullAdditionTest(){
        System.out.println("Adding Guitar With Null Attributes Test:");
        try{
            inventory.addGuitar(1, 1, "guitar0", null, Type.ELECTRIC, Wood.CEDAR, Wood.CEDAR);
        } catch(IllegalArgumentException e){
            System.out.print("IllegalArgumentException caught: ");
            System.out.println(e.getMessage());
        }

        inventory = new InventorySystem();
        System.out.println("-------------------------------------------------");
    }

    public static void modifyTest(){
        System.out.println("Modifying Guitar Test:");
        inventory.addGuitar(1, 1, "guitar0", Brand.GIBSON, Type.ELECTRIC, Wood.CEDAR, Wood.CEDAR);
        Guitar guitar = inventory.search(new GuitarSpecifications(null, null, null, null, null)).get(0);
        guitar.setPrice(10);
        GuitarSpecifications specs = guitar.getGuitarSpecifications();
        specs.setBottomWood(Wood.MAHOGANY);
        specs.setTopWood(Wood.ALDER);
        specs.setModel("Replacement");
        specs.setType(Type.ACOUSTIC);
        specs.setBrand(Brand.IBANEZ);
        System.out.println(inventory);

        inventory = new InventorySystem();
        System.out.println("-------------------------------------------------");
    }

    private static void multipleItemSearchTest(){
        System.out.println("Search Test:");
        int numItems = 10;
        String desiredModel = "guitar0";
        Brand desiredBrand = Brand.ESP;
        Type desiredType = Type.ACOUSTIC;
        Wood desiredTopWood = Wood.CEDAR;
        Wood desiredBottomWood = Wood.ALDER;
        Brand brand;
        Type type;
        Wood topWood;
        Wood bottomWood;
        for(int serial = 0; serial < numItems; serial++){
            // Introduce different guitars to sort on
            type = serial % 2 == 0 ? Type.ELECTRIC : Type.ACOUSTIC;
            if(serial % 4 == 0){
                topWood = Wood.ROSEWOOD;
                bottomWood = Wood.CEDAR;
            } else if(serial % 4 == 1){
                topWood = Wood.ALDER;
                bottomWood = Wood.MAHOGANY;
            } else if(serial % 4 == 2){
                topWood = Wood.MAHOGANY;
                bottomWood = Wood.ALDER;
            } else {
                topWood = Wood.CEDAR;
                bottomWood = Wood.ROSEWOOD;
            }
            if(serial % 10 == 0){
                brand = Brand.GIBSON;
            } else if(serial % 10 == 1){
                brand = Brand.FENDER;
            } else if(serial % 10 == 2){
                brand = Brand.IBANEZ;
            } else if(serial % 10 == 3){
                brand = Brand.PAUL_REED_SMITH;
            } else if(serial % 10 == 4){
                brand = Brand.EPIPHONE;
            } else if(serial % 10 == 5){
                brand = Brand.JACKSON;
            } else if(serial % 10 == 6){
                brand = Brand.ESP;
            } else if(serial % 10 == 7){
                brand = Brand.YAMAHA;
            } else if(serial % 10 == 8){
                brand = Brand.RICKENBACKER;
            } else {
                brand = Brand.GRETSCH;
            }
            inventory.addGuitar(0, serial, "guitar" + serial, brand, type, topWood, bottomWood);
        }
        System.out.println("\n\nSearch for " + desiredBrand + ":");
        guitarSpecs = new GuitarSpecifications(null, null, desiredBrand, null, null);
        System.out.println(inventory.printSearch(inventory.search(guitarSpecs)));
        System.out.println("\n\nSearch for " + desiredModel + ":");
        guitarSpecs = new GuitarSpecifications(null, null, null, null, desiredModel);
        System.out.println(inventory.printSearch(inventory.search(guitarSpecs)));
        System.out.println("\n\nSearch for " + desiredType + ":");
        guitarSpecs = new GuitarSpecifications(null, null, null, desiredType, null);
        System.out.println(inventory.printSearch(inventory.search(guitarSpecs)));
        System.out.println("\n\nSearch for " + desiredTopWood + " top wood:");
        guitarSpecs = new GuitarSpecifications(desiredTopWood, null, null, null, null);
        System.out.println(inventory.printSearch(inventory.search(guitarSpecs)));
        System.out.println("\n\nSearch for " + desiredBottomWood + " bottom wood:");
        guitarSpecs = new GuitarSpecifications(null, desiredBottomWood, null, null, null);
        System.out.println(inventory.printSearch(inventory.search(guitarSpecs)));

        System.out.println("\n\nSearch for " + desiredBottomWood + " bottom wood, " + desiredType + ":");
        guitarSpecs = new GuitarSpecifications(null, desiredBottomWood, null, desiredType, null);
        System.out.println(inventory.printSearch(inventory.search(guitarSpecs)));
        System.out.println("\n\nSearch for " + desiredTopWood + " top wood, " + desiredType + ":");
        guitarSpecs = new GuitarSpecifications(desiredTopWood, null, null, desiredType, null);
        System.out.println(inventory.printSearch(inventory.search(guitarSpecs)));

        inventory = new InventorySystem();
        System.out.println("-------------------------------------------------");
    }

    private static void negativePriceTest(){
        System.out.println("Guitar with a negative Price Test:");
        try{
            inventory.addGuitar(-1, 1, "guitar1", Brand.GIBSON, Type.ELECTRIC, Wood.CEDAR, Wood.CEDAR);
        } catch(IllegalArgumentException e){
            System.out.print("IllegalArgumentException caught: ");
            System.out.println(e.getMessage());
        }
        try{
            GuitarSpecifications search = new GuitarSpecifications(null, null, null, null, null);
            inventory.addGuitar(1, 1, "guitar1", Brand.GIBSON, Type.ELECTRIC, Wood.CEDAR, Wood.CEDAR);
            inventory.search(search).get(0).setPrice(-1);
        } catch(IllegalArgumentException e){
            System.out.print("IllegalArgumentException caught: ");
            System.out.println(e.getMessage());
        }

        inventory = new InventorySystem();
        System.out.println("-------------------------------------------------");
    }
}