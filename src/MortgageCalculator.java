import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        double amount = 0;
        double interest_rate = 0;
        double monthly_payment = 0;
        double remaing_balance = 0;
        int loan_year;

        System.out.printf("Enter the loan amount: "); //
        amount = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        interest_rate = keyboard.nextDouble();

        System.out.printf("Enter the term (years) for the loan payment: ");
        loan_year = keyboard.nextInt();

        System.out.printf("\n======================================\n");
        keyboard.close();

        /* using processMonthlyPayment method calculating the monthly payment
            we have to give 3 values the loan amount, interest rate and loan year
            finally it return the monthly payment
         */
        monthly_payment = processMonthlyPayment(amount, interest_rate, loan_year);

        //calculate interest plus loan amount that mean real loan amount that a customer owe the bank.
        remaing_balance = -(monthly_payment*(loan_year*12));

        System.out.format("%-30s$%-+10.2f%n", "Balance owed to bank: ", remaing_balance);
        System.out.format("%-30s$%-+10.2f%n", "Minimum monthly payment: ", monthly_payment);
    }


    public static double processMonthlyPayment(double amount, double interest_rate, int loan_year) {
        // calculates the monthly payment
        double rate = (interest_rate/ 100) / 12;
        double base = (1 + rate);
        double months = loan_year* 12;
        double result = 0.0;
        result = ((rate * amount) / (1 - Math.pow(base, -months)));
        return result;
    }
}
