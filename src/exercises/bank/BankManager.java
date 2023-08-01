package exercises.bank;

//  8. Model a BankManager
public class BankManager {
    private Bank bank;

//  8.  Ensure the BankManager can access the Bank’s vault.
    public double getVault() {
        return this.bank.getVault(); // it work's
    }
}
