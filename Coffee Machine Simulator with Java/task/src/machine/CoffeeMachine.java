package machine;

import java.util.*;

public class CoffeeMachine {

    public static ArrayList<String> steps = new ArrayList<String>();

    private static int Water = 0;
    private static int Milk = 0;
    private static int Beans = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        GetIngredientsAmount(scanner);
        MakeCoffeeIfPossible(scanner);
    }

    private static void MakeCoffeeIfPossible(Scanner scanner) {

        int possibleCoffees = PossibleAmountOfCoffees();

        System.out.println("Write how many cups of coffee you will need:");
        int numberOfCoffees = scanner.nextInt();



        if (numberOfCoffees == possibleCoffees) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (numberOfCoffees < possibleCoffees) {
            int diff = possibleCoffees - numberOfCoffees;
            System.out.println("Yes, I can make that amount of coffee (and even " + diff + " more than that)");
        } else {
            System.out.println("No, I can make only " + possibleCoffees + " cup(s) of coffee");
        }


    }

    private static void GetIngredientsAmount(Scanner scanner) {

        System.out.println("Write how many ml of water the coffee machine has:");
        Water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        Milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        Beans = scanner.nextInt();



    }

    private static int ValidateWater() {
        final int waterPerCoffee = 200; // ml
        return Water / waterPerCoffee;
    }

    private static int ValidateMilk() {
        final int milkPerCoffee = 50; // ml
        return Milk / milkPerCoffee;
    }

    private static int ValidateBeans() {
        final int beansPerCoffee = 15; //grains
        return Beans / beansPerCoffee;
    }


    private static int PossibleAmountOfCoffees() {

        int water = ValidateWater();
        int milk = ValidateMilk();
        int beans = ValidateBeans();

        int res = Math.min(water, Math.min(milk, beans));

        return res;

    }


}


