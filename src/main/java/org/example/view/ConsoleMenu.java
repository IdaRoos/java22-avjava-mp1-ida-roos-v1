package org.example.view;

import org.example.model.Clock;

import java.util.Scanner;

public class ConsoleMenu {
    private  Clock clock;
    private Scanner scanner;

    public ConsoleMenu(Clock clock) {
        this.clock = clock;
      this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        String userInput = "";

        while (!userInput.equals("q")) {
            System.out.println("Current state - " + clock.getCurrentState());

            if (clock.getCurrentState() == Clock.STATE.DisplayTime) {
                if (displayTimeMenu()) {
                    break;
                }
            }else if (clock.getCurrentState() == Clock.STATE.DisplayDate) {
                if (displayDateMenu()) {
                    break;
                }
            } else if (clock.getCurrentState() == Clock.STATE.ChangeTime) {
                if(changeTimeMenu()){
                    break;
                }
            } else if (clock.getCurrentState() == Clock.STATE.ChangeDate) {
                if(changeDateMenu()) {
                    break;
                }
            }
        }
    }

    private boolean displayTimeMenu() {
        System.out.println("Enter one of the alternatives: ");
        System.out.println("1. Display Time");
        System.out.println("2. Change Time");
        System.out.println("3. Display Date");
        System.out.println("4. Quit application");

        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println(clock.getTime());
                break;
            case "2":
                clock.readyToSet();
                break;
            case "3":
                clock.changeMode();
                break;
            case "4":
                System.out.println("Exiting application.");
                return true;

            default:
                System.out.println("Invalid choice");
        }
        return false;
    }

        private boolean displayDateMenu() {
            System.out.println("Enter one of the alternatives: ");
            System.out.println("1. Display Date");
            System.out.println("2. Change Date");
            System.out.println("3. Display Time");
            System.out.println("4. Quit application");

            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    System.out.println(clock.getDate());
                    break;
                case "2":
                    clock.readyToSet();
                    break;
                case "3":
                    clock.changeMode();
                    break;
                case "4":
                    System.out.println("Exiting application.");
                   return true;
                default:
                    System.out.println("Invalid choice");
            }return false;
        }

    private boolean changeTimeMenu() {
        System.out.println("1. Change Time");
        System.out.println("2. Display Time");
        System.out.println("3. Quit application");

        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("Enter new time (HH:mm:ss): ");
                String newTimeInput = scanner.nextLine();
                try {
                    clock.setTime(newTimeInput);
                    System.out.println("Time set successfully!");
                } catch (Exception e) {
                    System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
                }
                break;
            case "2":
                clock.set();
                break;
            case "3":
                System.out.println("Exiting application.");
               return true;

            default:
                System.out.println("Invalid choice");
        }return false;
    }

    private boolean changeDateMenu() {
        System.out.println("1. Change Date");
        System.out.println("2. Display Date");
        System.out.println("3. Quit application");

        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("Enter new date (yyyy-MM-dd): ");
                String newDateInput = scanner.nextLine();
                try {
                    clock.setDate(newDateInput);
                    System.out.println("Date set successfully!");
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
                }
                break;
            case "2":
                clock.set();
                break;
            case "3":
                System.out.println("Exiting application.");
                return true;
            default:
                System.out.println("Invalid choice");
        } return false;
    }


}
