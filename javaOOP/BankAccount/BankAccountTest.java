public class BankAccountTest{
    public static void main(String[] args){
        BankAccount xXx = new BankAccount();
        BankAccount xy = new BankAccount(135.65);
        BankAccount yx = new BankAccount(354.3);


        xXx.getAccNum();
        xy.getAccNum();
        yx.getAccNum();
        System.out.println(xXx.getBalance());
        xXx.depositeCheck(542);
        xXx.depositeCheck(358);
        System.out.println(xXx.getBalance());
        System.out.println(xy.getBalance());
        System.out.println(yx.getBalance());
        xXx.withdraw(200);
        System.out.println(xXx.getBalance());
    }
}