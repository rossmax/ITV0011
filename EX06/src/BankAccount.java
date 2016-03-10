/**
 * The Class BankAccount.
 */
public class BankAccount {

  /** The balance. */
  private double balance;

  /**
   * Adds the money.
   *
   * @param amount the amount
   */
  public void addMoney(double amount) {
    balance += amount;
  }

  /**
   * Transfer money to.
   *
   * @param targetAccount the target account
   * @param amount the amount
   * @return true, if successful
   */
  public boolean transferMoneyTo(BankAccount targetAccount, double amount) {
    if (balance < amount + (0.01 * amount)) {
      return false; // System.out.println("Not enough money for transfer");
    }

    if (targetAccount == null) {
      return false; // System.out.println("This bank account does not exist");
    } else {
      balance -= amount + (0.01 * amount);
      targetAccount.balance += amount;
      return true;
    }
  }

  /**
   * Withdraw money.
   *
   * @param amount the amount
   * @return the double
   */
  public double withdrawMoney(double amount) {
    if (balance >= amount) {
      balance -= amount;

      return balance;
    } else {

      // System.out.println("Not enough money for withdraw");
      return Double.NaN;
    }
  }

  /**
   * Gets the balance.
   *
   * @return the balance
   */
  public double getBalance() {
    if (balance > -1) {
      return balance;
    } else {
      return Double.NaN;
    }
  }
}

