import javax.swing.JOptionPane;

public class BankAccountProgram {
    public static void main(String[] args) {
        int numDeposits = 0;
        int numWithdrawals = 0;

        double initialBalance = getAccountBalance();
        double accountBalance = initialBalance;

        String transactionAction = getTransactionAction();

        while (!transactionAction.equals("Q")) {
            if (transactionAction.equals("D")) {
                numDeposits++;
            } else if (transactionAction.equals("W")) {
                numWithdrawals++;
            }

            double transactionAmount = getTransactionAmount();
            accountBalance = calculateNewAccountBalance(transactionAction, transactionAmount, accountBalance);

            printAccountBalance(accountBalance);

            transactionAction = getTransactionAction();
        }

        printTransactionSummary(initialBalance, accountBalance, numDeposits, numWithdrawals);
    }

    public static double getAccountBalance() {
        double accountBalance = 0;

        while (true) {
            try {
                accountBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter the account balance:"));
                if (accountBalance >= 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Account balance must be a number greater than or equal to 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Please enter a valid number.");
            }
        }

        return accountBalance;
    }

    public static String getTransactionAction() {
        String transactionAction = "";

        while (true) {
            transactionAction = JOptionPane.showInputDialog("Enter the transaction action (D for Deposit, W for Withdrawal, Q for Quit):");
            transactionAction = transactionAction.toUpperCase();

            if (transactionAction.equals("D") || transactionAction.equals("W") || transactionAction.equals("Q")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Error! Please enter (D) for Deposit, (W) for Withdrawal, or (Q) for Quit");
            }
        }

        return transactionAction;
    }

    public static double getTransactionAmount() {
        double transactionAmount = 0;

        while (true) {
            try {
                transactionAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the transaction amount:"));
                if (transactionAmount > 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Transaction amount must be a number greater than 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error! Please enter a valid number.");
            }
        }

        return transactionAmount;
    }

    public static double calculateNewAccountBalance(String transactionAction, double transactionAmount, double accountBalance) {
        if (transactionAction.equals("D")) {
            accountBalance += transactionAmount;
        } else if (transactionAction.equals("W")) {
            accountBalance -= transactionAmount;
        }

        return accountBalance;
    }

    public static void printAccountBalance(double accountBalance) {
        JOptionPane.showMessageDialog(null, "The balance in your account is: " + accountBalance);
    }

    public static void printTransactionSummary(double initialBalance, double accountBalance, int numDeposits, int numWithdrawals) {
        String message = "The initial balance in your account was: " + initialBalance + "\n";
        message += "The final balance in your account is: " + accountBalance + "\n";
        message += "Number of Deposits: " + numDeposits + "\n";
        message += "Number of Withdrawals: " + numWithdrawals;

        JOptionPane.showMessageDialog(null, message);
    }
}