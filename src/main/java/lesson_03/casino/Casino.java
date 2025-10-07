package lesson_03.casino;

import java.util.Scanner;

public class Casino {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String weiter = "n";

        int points = 0;

        Dealer dealer = new Dealer();

        do {
            Card card = dealer.getCard();
            points += card.getValue();
            System.out.println("points: " + card);
            if (points > 21) {
                System.out.println("\npoints: " + points + "\ngame over!");
                break;
            }
            System.out.print("weiter: y/n ");
            weiter = scanner.next();
        }
        while (weiter.equals("y"));

        if (points < 22) {
            System.out.println("\npoints: " + points + "\nyou won!");
        }

        scanner.close();
    }
}
