package machine;

import java.util.*;

public class CoffeeMachine {

    public static ArrayList<String> steps = new ArrayList<String>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int numberOfCoffees = scanner.nextInt();
        CreateCoffeeIngredients(numberOfCoffees);


        //MakeCoffee();
    }

    private static void CreateCoffeeIngredients(int numberOfCoffees) {

        final int waterPerCoffee = 200; // ml
        final int beansPerCoffee = 15; //grains
        final int milkPerCoffee = 50; // ml

        System.out.println("For " + numberOfCoffees + " cups of coffee you will need:");
        System.out.println(numberOfCoffees * waterPerCoffee + " ml of water");
        System.out.println(numberOfCoffees * milkPerCoffee + " ml of milk");
        System.out.println(numberOfCoffees * beansPerCoffee + " g of coffee beans");

    }


    private static void MakeCoffee() {


        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready !");

    }

}


