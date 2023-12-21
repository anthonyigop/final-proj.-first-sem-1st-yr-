/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.compoundinterest;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Compoundinterest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Welcome to Compound Interest Calculator");
        System.out.println("Press enter to continue");
        scanner.nextLine();

        while (true) {
            // P
            System.out.print("Enter the principal amount: $");
            double principal = scanner.nextDouble();

            while (principal <= 0) {
                System.out.println("Invalid input. Principal must be a positive value.");
                System.out.print("Enter the principal amount: $");
                principal = scanner.nextDouble();
            }

            // r
            System.out.print("Enter the annual interest rate (in percentage, not including the percentage sign): ");
            double annualRate = scanner.nextDouble();

            while (annualRate == 0 || annualRate >= 101) {
                if (annualRate == 0) {
                    System.out.println("Invalid input.");
                } else {
                    System.out.println("Too much high.");
                }
                System.out.print("Enter the annual interest rate (in percentage): ");
                annualRate = scanner.nextDouble();
            }

            // t
            System.out.print("Enter the time period (years, months, weeks): ");
            String timeUnit = scanner.next().toLowerCase();

            System.out.print("Enter the time value: ");
            double timeValue = scanner.nextDouble();

            while (timeValue <= 0) {
                System.out.println("Invalid input. Time must be a positive value.");
                System.out.print("Enter the time value: ");
                timeValue = scanner.nextDouble();
            }

            switch (timeUnit) {
                case "years":
                    break;
                case "months":
                    timeValue /= 12;
                    break;
                case "weeks":
                    timeValue /= 52;
                    break;
                default:
                    System.out.println("Invalid time unit. Using years as default.");
                    break;
            }

            // Cf
            System.out.println("Select compounding frequency:");
            System.out.println("1. Daily (360/yr)");
            System.out.println("2. Daily (365/yr)");
            System.out.println("3. Monthly (12/yr)");
            System.out.println("4. Quarterly (4/yr)");
            System.out.println("5. Semi-Annually (2/yr)");
            System.out.println("6. Annually (1/yr)");
            System.out.print("Enter your choice: ");
            int compoundingChoice = scanner.nextInt();

            int compoundsPerYear;
            switch (compoundingChoice) {
                case 1:
                    compoundsPerYear = 360;
                    break;
                case 2:
                    compoundsPerYear = 365;
                    break;
                case 3:
                    compoundsPerYear = 12;
                    break;
                case 4:
                    compoundsPerYear = 4;
                    break;
                case 5:
                    compoundsPerYear = 2;
                    break;
                case 6:
                    compoundsPerYear = 1;
                    break;
                default:
                    System.out.println("Invalid choice. Using Annually (1/yr) as default.");
                    compoundsPerYear = 1;
                    break;
            }

            double ratePerPeriod = annualRate / 100 / compoundsPerYear;
            double totalCompounds = compoundsPerYear * timeValue;
            double compoundInterest = principal * Math.pow((1 + ratePerPeriod), totalCompounds) - principal;

            System.out.println("\nCompound Interest: $" + compoundInterest);

            System.out.println("\nDo you want to calculate again?");
            System.out.println("Type 1 for YES \nType 2 for NO");
            int choice = scanner.nextInt();

            if (choice != 1) {
                System.out.println("Thank you for using!");
                break;
            }
        }
    }
}
