import java.util.Scanner;

class LessBalanceException extends Exception{
    private static final long serialVersionUID = 1L;
    LessBalanceException(String s) {
        super(s);
    }
}
class Account{
    double balance;
    public void checkBalance(){
        System.out.println("Available Balance is: Rs. "+balance+"\n");
    }
    public void deposit(double deposit_money){
        balance=balance+deposit_money;
        System.out.println("Rs. "+deposit_money+" has been successfully deposited into your Account");
        System.out.println("Available Balance is: Rs. "+balance+"\n");
    }
    public void withdraw(double withdraw_money) throws LessBalanceException{
        if(balance-withdraw_money<500)
            throw new LessBalanceException("Withdraw Amount is not Valid\n");
        else{
            balance=balance-withdraw_money;
            System.out.println("Rs. "+withdraw_money+" has been successfully withdrawn from your Account");
            System.out.println("Available Balance is: Rs. "+balance+"\n"); 
        }    
    }
}
public class Q7 {
    public static void main(String[] args) {
        Account A1 = new Account();
        System.out.print("_________________________\n|                        |\n");
        System.out.print("|  WELCOME TO KIIT BANK  |\n");
        System.out.print("|________________________|\n\n");

        Scanner sc = new Scanner(System.in);
        boolean flag=true; 
        while(flag){
            
            System.out.println("Press 1 to Deposit Money into your Account");
            System.out.println("Press 2 to Withdraw Money from your Account");
            System.out.println("Press 3 to Check Available Balance of your Account");
            System.out.println("Press 4 to Exit");
            
            System.out.print("\nEnter your chocie: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter how much money you want to deposit: ");
                    double deposit_money = sc.nextDouble(); 
                    A1.deposit(deposit_money);  
                break;
                case 2:
                    System.out.print("Enter how much money you want to withdraw: ");
                    double withdraw_money = sc.nextDouble();
                    try{
                        A1.withdraw(withdraw_money);
                    }
                    catch(LessBalanceException e){
                        System.out.println("Exception Occured: "+e);
                    }
                    break;
                case 3:
                    A1.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our Service...\n");
                    flag=false;
                break;
                default:
                    System.out.println("Wrong Chocie!! Please Enter again\n");
            }
        }
        sc.close();
    }
}
