package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeMachine {
    public static void main(String[] args) throws IOException {
        int waterForCup = 200;
        int milkForCup = 50;
        int beansForCup = 15;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterSupply = Integer.parseInt(reader.readLine());

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkSupply = Integer.parseInt(reader.readLine());

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beansSupply = Integer.parseInt(reader.readLine());

        System.out.println("Write how many cups of coffee you will need: ");
        int cups = Integer.parseInt(reader.readLine());
        // how many cups machine can make now
        int w = waterSupply / waterForCup;
        int m = milkSupply / milkForCup;
        int b = beansSupply / beansForCup;
        // search minimum for correct count of cups machine can make
        int min;
        if (w<m) {
            min = w < b ? w : b;
        } else {
            min = m < b ? m : b;
        }
        if (waterForCup * cups > waterSupply ||
                milkForCup * cups > milkSupply ||
                beansForCup * cups > beansSupply) {
            System.out.println("No, I can make only " + min + " cup(s) of coffee");
        } else if (waterForCup * cups <= waterSupply &&
                milkForCup * cups <= milkSupply &&
                beansForCup * cups <= beansSupply) {
            if (waterSupply / waterForCup * cups > cups &&
                    milkSupply / milkForCup * cups > cups &&
                    beansSupply / beansForCup * cups > cups) {
                System.out.println("Yes, I can make that amount of coffee (and even " + (min - cups) + " more than that)");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        }

    }
}
