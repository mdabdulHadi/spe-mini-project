package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class Calculator {
//public class of Calculator
    public static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {}

    public static void main(String[] args) {
        
        Calculator cal = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        //declaring variables of number1 and number2
        do{ //following features of calculator are available
            
            System.out.println("Calcuator");    
            //prints calculator
            
            System.out.println("Available functions are \n1 - The Square Root of first number\n2 - The Factorial of first number\n3 - The Natural Log of first number\n4 - There first number Power second number\nAny other number to EXIT");
            // prints Available functions like Square Root of , Factorial of first number, Natural Log of first number, first number Power second number
           
            int Function;

            try{
                Function = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            if (Function < 1 || Function > 4){  
                //Function less than 1 and Function more than 4
                return;
            }

            try{
                System.out.println("Enter first number");
                //enter any number (first number)
                number1 = scanner.nextDouble();
            } catch (InputMismatchException error) {
                return;
            }

            switch(Function){
                case 1:
                    System.out.println("The Square root of first number = " + cal.sqt(number1));
                    //prints sqaure root of first number
                    break;
                case 2:
                    System.out.println("The Factorial of first number =" + cal.factorial(number1));
                    //prints factorial of first number
                    break;
                case 3:
                    System.out.println("The Natural log of first number =" + cal.log(number1));
                    //prints natural log of first number
                    break;
                case 4:
                    try {
                        System.out.print("Enter second number");
                        //enter any other number (second number)
                        number2 = scanner.nextDouble();
                    } catch (InputMismatchException error){
                        return;
                    }
                    System.out.println("The first number power second number = " + cal.power(number1, number2));
                    //prints first number power second number
                    break;
                default:
                    System.out.print("CLOSING");
                    //prints closing
                    return;
            }
        }while(true);
    }


    public static double sqt(double i){
        double temp = 0;
        try {
            logger.info("[SQRT] - " + i);
            if (i < 0) {
                temp = Double.NaN;
                throw new ArithmeticException("CAN'T FIND SQUARE ROOT OF NEGATIVE NUMBERS");
            } else {
                temp = Math.sqrt(i);
            }
        } catch (ArithmeticException error){
            logger.error("[EXCEPTION - SQRT] - CAN'T FIND SQUARE ROOT OF NEGATIVE NUMBERS");
            //Cannot find sqrt of negative numbers
        } finally {
            logger.info("[RESULT - SQRT] = " + temp);
        }
        return temp;
    }

    public static double factorial(double i){
        logger.info("[FACTORIAL] - " + i );
        double temp = 1.0;
        for (int t = 1; t<= i; t++){
            temp *= t;
        }
        logger.info("[RESULT - FACTORIAL] = " + temp);
        //result - factorial
        return temp;
    }
    public static double log(double i){
        Double temp = 0.0;
        try {
            logger.info("[LOG] - " + i);
            if (i < 0){
                temp = Double.NaN;
                throw new ArithmeticException("CAN'T FIND LOG OF NEGATIVE NUMBER");
                //Cannot find log of negative numbers
            }
            else if (i == 0){
                temp = Double.NEGATIVE_INFINITY;
                throw new ArithmeticException("LOG OF 0 IS NEGATIVE INFINITY");
                //Log of 0 is negative infinity
            }
            else {
                temp = Math.log(i);
            }
        } catch (ArithmeticException error){
            logger.error("[EXCEPTION - LOG] - INPUT IS LESS THAN OR EQUAL TO ZERO");
            //input is less than or equal to zero
        } finally {
            logger.info("[RESULT - LOG] = " + temp);
        }
        return temp;
    }
    public static double power(double i, double j){
        logger.info("[POWER] - " + i + ", " + j );
        double temp = Math.pow(i,j);
        //exponential function - power function
        logger.info("[RESULT - POWER] = " + temp);
        return temp;
    }

}
