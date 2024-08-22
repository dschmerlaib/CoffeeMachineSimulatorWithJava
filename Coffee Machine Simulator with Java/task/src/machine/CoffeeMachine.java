package machine;

import java.util.*;

public class CoffeeMachine {

    public static ArrayList<String> steps = new ArrayList<String>();


    public static void main(String[] args) {
        AddSteps();
        MakeCoffee();
    }

    private static void AddSteps() {

        steps.add(" Starting to make a coffee");
        steps.add(" Grinding coffee beans");
        steps.add(" Boiling water");
        steps.add(" Mixing boiled water with crushed coffee beans");
        steps.add(" Pouring coffee into the cup");
        steps.add("  Pouring some milk into the cup");
        steps.add(" Coffee is ready !");
    }

    private static void MakeCoffee() {

        for (String step : steps) {
            System.out.println(step);
        }

    }

}


