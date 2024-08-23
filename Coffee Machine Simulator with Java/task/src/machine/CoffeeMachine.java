package machine;

import java.util.*;

class Coffee {
    public int RequiredWater;
    public int RequiredBeans;
    public int RequiredMilk;
    public int Costs;
    public String Name;
    public int OrderNumber;

    public Coffee(String name, int requiredWater, int requiredBeans, int requiredMilk, int costs, int orderNumber) {
        RequiredWater = requiredWater;
        RequiredBeans = requiredBeans;
        RequiredMilk = requiredMilk;
        Costs = costs;
        Name = name;
        OrderNumber = orderNumber;
    }
}

class Machine {
    public int Water = 400;
    public int Milk = 540;
    public int Beans = 120;
    public int Money = 550;
    public int DisposableCups = 9;

    public HashMap<String, Coffee> Assortment;
    private Scanner scanner;

    public Machine(Scanner scanner) {
        this.scanner = scanner;
        this.Assortment = new HashMap<String, Coffee>();
        this.Assortment.put("espresso", new Coffee("espresso", 250, 16, 0, 4, 1));
        this.Assortment.put("latte", new Coffee("latte", 350, 20, 75, 7, 2));
        this.Assortment.put("cappuccino", new Coffee("cappuccino", 200, 12, 100, 6, 3));
    }

    public void HandleAction() {

        boolean repeat = true;

        while (repeat) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    Buy();
                    break;
                case "fill":
                    Fill();
                    break;
                case "take":
                    Take();
                    break;
                case "remaining":
                    PrintStatus();
                    break;
                case "exit":
                    repeat = false;
                    break;
                default:
                    break;
            }
        }


    }

    public void Buy() {

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String selection = scanner.nextLine();

        switch (selection) {
            case "1":
                Brew("espresso");
                break;
            case "2":
                Brew("latte");
                break;
            case "3":
                Brew("cappuccino");
                break;
            case "back":
                break;
            default:
                break;
        }
    }

    public void Brew(String selectionName) {
        Coffee coffee = Assortment.get(selectionName);

        boolean enoughResources = Validate(coffee); // todo

        if (enoughResources) {
            Water -= coffee.RequiredWater;
            Milk -= coffee.RequiredMilk;
            Beans -= coffee.RequiredBeans;
            Money += coffee.Costs;
            DisposableCups--;

            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public boolean Validate(Coffee coffee) {

        if (Water < coffee.RequiredWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (Milk < coffee.RequiredMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (Beans < coffee.RequiredBeans) {
            System.out.println("Sorry, not enough beans!");
            return false;
        } else if (DisposableCups == 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            return true;
        }


    }

    public void Fill() {


        System.out.println("Write how many ml of water you want to add:");
        Water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        Milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        Beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        DisposableCups += scanner.nextInt();
    }

    public void Take() {
        System.out.println("I gave you $ " + Money);
        Money = 0;
    }

    public void PrintStatus() {

        StringBuilder builder = new StringBuilder();

        builder.append("The coffee machine has:\n");
        builder.append(Water + " ml of water\n");
        builder.append(Milk + " ml of milk\n");
        builder.append(Beans + " g of coffee beans\n");
        builder.append(DisposableCups + " disposable cups\n");
        builder.append("$" + Money + " of money\n");

        System.out.println(builder.toString());

    }

}

public class CoffeeMachine {

    public static void main(String[] args) {


        Machine machine = new Machine(new Scanner(System.in));

        machine.HandleAction();


    }

}


