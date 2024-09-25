package com.chavvicalc;

import java.util.*;

/*
 * Chavvi Calc calculator
 */
public class ChavviCalcApp {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Character command = '_';

    printMenu();  // Print the menu initially

    // loop until user quits
    while (command != 'q') {
      System.out.print("Enter a command: ");
      command = menuGetCommand(scan);
      if (command != 'q') {
        executeCommand(scan, command);
        printMenu();  // Only print menu after a command has been executed
      }
    }

    System.out.println("Thank you for using Chavvi Calc");
    scan.close();
  }

  // Menu functions
  private static void printMenuLine() {
    System.out.println("----------------------------------------------------------");
  }

  private static void printMenuCommand(Character command, String desc) {
    System.out.printf("%s\t%s\n", command, desc);
  }

  // Prints the menu
  public static void printMenu() {
    printMenuLine();
    System.out.println("ChavviCalc");
    printMenuLine();

    printMenuCommand('a', "Add");
    printMenuCommand('s', "Subtract");
    printMenuCommand('m', "Multiply");
    printMenuCommand('d', "Divide");
    printMenuCommand('q', "Quit");
    printMenuLine();
  }

  // Get first character from input
  private static Character menuGetCommand(Scanner scan) {
    Character command = '_';
    String rawInput = scan.nextLine();
    if (rawInput.length() > 0) {
      rawInput = rawInput.toLowerCase();
      command = rawInput.charAt(0);
    }
    return command;
  }

  // Calculator functions
  private static Boolean executeCommand(Scanner scan, Character command) {
    Boolean success = true;

    switch (command) {
      case 'a':
        performOperation(scan, '+');
        break;
      case 's':
        performOperation(scan, '-');
        break;
      case 'm':
        performOperation(scan, '*');
        break;
      case 'd':
        performOperation(scan, '/');
        break;
      default:
        System.out.println("ERROR: Unknown command");
        success = false;
    }
    return success;
  }

  private static void performOperation(Scanner scan, char operation) {
    System.out.print("Enter first number: ");
    double num1 = scan.nextDouble();  // Reads first double
    scan.nextLine();  // Clears the buffer
    System.out.print("Enter second number: ");
    double num2 = scan.nextDouble();  // Reads second double
    scan.nextLine();  // Clears the buffer again to handle next input properly

    switch (operation) {
      case '+':
        System.out.println("Result: " + (num1 + num2));
        break;
      case '-':
        System.out.println("Result: " + (num1 - num2));
        break;
      case '*':
        System.out.println("Result: " + (num1 * num2));
        break;
      case '/':
        if (num2 != 0) {
          System.out.println("Result: " + (num1 / num2));
        } else {
          System.out.println("Error: Division by zero");
        }
        break;
    }
    printMenuLine(); // To separate results from the next input prompt
  }
}
