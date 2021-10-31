package machine;

import java.util.Scanner;

public class Machine {
    int water;
    int milk;
    int coffeeBeans;
    int cups;
    int cash;

    public Machine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.cash = 550;
    }

    public String buyCoffee (KindOfCoffee coffee) {
        if (this.water < coffee.getWater()) {return "Sorry, not enough water!";}
        if (this.milk < coffee.getMilk()) {return "Sorry, not enough milk!";}
        if (this.coffeeBeans < coffee.getCoffeeBeans()) {return "Sorry, not enough coffee!";}
        if (this.cups == 0) {return "Sorry, not enough cups!";}

        this.water -= coffee.getWater();
        this.milk -= coffee.getMilk();
        this.coffeeBeans -= coffee.getCoffeeBeans();
        this.cups -= 1;
        this.cash += coffee.getCost();
        return "I have enough resources, making you a coffee!";
    }

    @Override
    public String toString() {
        return "The coffee machine has : \n" +
                this.water +" ml of water \n" +
                this.milk + " ml of milk \n" +
                this.coffeeBeans + " g of coffee beans \n" +
                this.cups + " disposable cups \n" +
                "$" + this.cash + " of money";
    }

    public String takeMoney () {
        String result = "I gave you $" + this.cash;
        this.cash = 0;
        return result;
    }

    public void fill () {

        Scanner fillInput = new Scanner(System.in);
        int waterToFill;
        int milkToFill;
        int coffeeBeansToFill;
        int cupsToAdd;

        System.out.println("Write how many ml of water you want to add: ");
        waterToFill = Integer.parseInt(fillInput.nextLine());
        System.out.println("Write how many ml of milk you want to add: ");
        milkToFill = Integer.parseInt(fillInput.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeansToFill = Integer.parseInt(fillInput.nextLine());
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cupsToAdd = Integer.parseInt(fillInput.nextLine());

        this.water += waterToFill;
        this.milk += milkToFill;
        this.coffeeBeans += coffeeBeansToFill;
        this.cups += cupsToAdd;
    }
}
