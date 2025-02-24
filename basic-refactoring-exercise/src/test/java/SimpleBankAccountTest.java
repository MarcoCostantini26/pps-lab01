import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final int INITIAL_MONEY = 0;
    public static final int ID_USER_1 = 1;
    public static final int AMOUNT_100_MONEY = 100;
    public static final int WRONG_USER_ID = 2;
    public static final int AMOUNT_50_MONEY = 50;
    public static final int AMOUNT_70_MONEY = 70;
    public static final int AMOUNT_30_MONEY = 30;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void initAccount(){
        accountHolder = new AccountHolder("Mario", "Rossi", ID_USER_1);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_MONEY);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_MONEY, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT_100_MONEY);
        assertEquals(AMOUNT_100_MONEY, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT_100_MONEY);
        bankAccount.deposit(WRONG_USER_ID, AMOUNT_50_MONEY);
        assertEquals(AMOUNT_100_MONEY, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT_100_MONEY);
        bankAccount.withdraw(accountHolder.getId(), AMOUNT_70_MONEY);
        assertEquals(AMOUNT_30_MONEY, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AMOUNT_100_MONEY);
        bankAccount.withdraw(WRONG_USER_ID, AMOUNT_70_MONEY);
        assertEquals(AMOUNT_100_MONEY, bankAccount.getBalance());
    }
}
