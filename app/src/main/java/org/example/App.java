package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollCalculator {

    // Constants for payroll calculations
    private static final double hourlyPay = 16.78; 
    //total tax 14%, 6%, 5%     
    private static final double taxPay = 0.25;           
    private static final double perDependant = 15.00; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get hours worked
            System.out.print("Enter hours worked: ");
            double hoursWorked = scanner.nextDouble();
            if (hoursWorked < 0) {
                System.out.println("Must enter a positive number");
                return;
            }


            // Get number of dependents
            System.out.print("Enter number of dependents: ");
            int dependents = scanner.nextInt();
            if (dependents < 0) {
                System.out.println("Must enter a positive number");
                return;
            }


            final double overtimePay = 1.5;
            final double averageHours = 40.0;

            //double regHours = Math.min(hoursWorked, averageHours);
            double overtimeHours = Math.max(0, hoursWorked - averageHours);
            // Calculate pay
            double regularPay = hoursWorked * hourlyPay;
            double overtime = overtimeHours * hoursWorked * overtimePay;
            double grossPay = regularPay + overtime;
            // deductions and netPay
            double taxAmount = grossPay * taxPay;
            double dependentDeduction = dependents * perDependant;
            double totalDeductions = taxAmount + dependentDeduction;
            double netPay = grossPay - totalDeductions;

            // Display Calculations
            System.out.println(" ");
            System.out.println("-----Total Calculations----");
            System.out.println(" ");
            System.out.printf("Work Hours: %.2f%n", hoursWorked);
            System.out.printf( "Overtime Rate: $%.2f%n", overtimePay);
            System.out.printf("Hourly Rate: $%.2f%n", hourlyPay);
            System.out.printf("Gross Pay: $%.2f%n", grossPay);
            System.out.printf("Tax (%.0f%%): -$%.2f%n", taxPay * 100, taxAmount);
            System.out.printf("Dependent Deduction ($%.2f each): -$%.2f%n", perDependant, dependentDeduction);
            System.out.printf("Total Deductions: -$%.2f%n", totalDeductions);
            System.out.printf("Net Pay: $%.2f%n", netPay);

        } catch (InputMismatchException e) {
            System.out.println("Enter positive numbers only.");
        } finally {
            scanner.close();
        }
    }
}

