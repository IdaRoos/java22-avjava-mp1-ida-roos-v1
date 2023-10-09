package com.idaroos.view;

import com.idaroos.model.Clock;

import java.util.Scanner;

public class ConsoleMenu {
    private  Clock clock = new Clock();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        String userInput = "";

        while (!userInput.equals("q")) {
            System.out.println("Current state -" + clock.getCurrentState());
            System.out.println("Enter one of the alternatives: ");
            System.out.println("1. Display Time");
            System.out.println("2. Display Date");
            System.out.println("3. Change Time");
            System.out.println("4. Change Date");
            System.out.println("5. Quit application");

            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    clock.displayTime();
                    break;
                case "2":
                    clock.displayDate();
                    break;
                case "3":
                    System.out.println("Enter new time");
                    userInput = scanner.nextLine();
                    clock.changeTime(userInput);

                    break;
                case "4":
                    System.out.println("Enter new date");
                    userInput = scanner.nextLine();
                    clock.changeDate(userInput);
                    break;

                case "5":
                    System.out.println("Exiting application.");
                    userInput = "q";

                default:
                    System.out.println("Invalid choice");
            }
        }
    }


}
