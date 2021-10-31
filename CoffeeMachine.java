package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Machine machine = new Machine();
        Actions action;
        KindOfCoffee kind;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String input = in.nextLine();
            action = Actions.valueOf(input.toUpperCase());
            switch (action) {
                case BUY:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String optionToBuy = in.nextLine();
                    switch (optionToBuy) {
                        case "1":
                            System.out.println(machine.buyCoffee(KindOfCoffee.ESPRESSO));
                            break;
                        case "2":
                            System.out.println(machine.buyCoffee(KindOfCoffee.LATTE));
                            break;
                        case "3": ;
                            System.out.println(machine.buyCoffee(KindOfCoffee.CAPPUCCINO));
                            break;
                        default:
                            break;
                    }
                    break;
                case FILL:
                    machine.fill();
                    break;
                case TAKE:
                    System.out.println(machine.takeMoney());
                    break;
                case REMAINING:
                    System.out.println(machine.toString());
                    break;
                case EXIT:
                    break;
            }
        } while (action != Actions.EXIT);

    }
}
