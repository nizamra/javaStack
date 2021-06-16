public class BankAccount{
    private int accNum;
    private static int numberOfAccounts=1523;
    private float checkingAmount;
    private float savingsAmount;
    private float balance;


    public BankAccount(){
        numberOfAccounts++;
        accNum=numberOfAccounts;
        checkingAmount=0;
        savingsAmount=0;
        balance=0;
    }
    public BankAccount(double money){
        numberOfAccounts++;
        accNum=numberOfAccounts;
        checkingAmount=0;
        savingsAmount=0;
        balance= (float) money;
    }

    // displaying your account number
    public int getAccNum(){
        return this.accNum;
    }
    
    // checking and savings amount, total amount. Of course
    public void getCheckingAmount(){
        System.out.println(this.checkingAmount);
    }
    public void getSavingsAmount(){
        System.out.println(this.savingsAmount);
    }

    // depositing a check
    public void depositeCheck(int money){
        this.balance+=money;
    }

    // checking your balance
    public float getBalance(){
        return this.balance;
    }

    // withdrawing money
    public void withdraw(int money){
        this.balance-=money;
    }
}