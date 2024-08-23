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
        System.out.println("Write action (buy, fill, take): ");
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
            default:
                break;
        }
    }

    public void Buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int selection = scanner.nextInt();
        String selectionName = "";

        switch (selection) {
            case 1:
                selectionName = "espresso";
                break;
            case 2:
                selectionName = "latte";
                break;
            case 3:
                selectionName = "cappuccino";
                break;
            default:
                break;
        }

        Coffee coffee = Assortment.get(selectionName);

        Water -= coffee.RequiredWater;
        Milk -= coffee.RequiredMilk;
        Beans -= coffee.RequiredBeans;
        Money += coffee.Costs;
        DisposableCups--;

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
        machine.PrintStatus();
        machine.HandleAction();
        machine.PrintStatus();

    }
    
}


