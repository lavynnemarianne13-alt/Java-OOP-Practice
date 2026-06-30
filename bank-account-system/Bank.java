import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("");
        System.out.print("Enter the first account number: ");
        int number1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the account holder for the first account: ");
        String holder1 = sc.nextLine();
        System.out.print("Is there na initial deposit (y/n)? ");
        char choice = sc.next().charAt(0);

        BankAccount bankaccount1;
        BankAccount bankaccount2;

        if (choice == 'y' || choice == 'Y'){
            System.out.print("Enter initial deposit value: ");
            double depositInicial1= sc.nextDouble();
            while (depositInicial1 <= 0){
                System.out.print("Transaction unavailable. Please enter a valid value: ");
                depositInicial1=sc.nextDouble();
            }    
            bankaccount1 = new BankAccount(number1, holder1, depositInicial1);       
        }else{
            bankaccount1 = new BankAccount(number1, holder1);
        }

        System.out.println("");
        System.out.print("Enter the second account number: ");
        int number2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the account holder for the second account: ");
        String holder2 = sc.nextLine();
        System.out.print("Is there na initial deposit (y/n)? ");
        choice = sc.next().charAt(0);

        if (choice == 'y' || choice == 'Y'){
            System.out.print("Enter initial deposit value: ");
            double depositInicial2= sc.nextDouble();
            while (depositInicial2 <= 0){
                System.out.print("Transaction unavailable. Please enter a valid value: ");
                depositInicial2=sc.nextDouble();
            }    
            bankaccount2 = new BankAccount(number2, holder2, depositInicial2);       
        }else{
            bankaccount2 = new BankAccount(number2, holder2);
        }

        int choice2;

        do{
        System.out.println("");
        System.out.println(" BANKING OPERATIONS ");
        System.out.println("1. DEPOSIT");
        System.out.println("2. WITHDRAW");
        System.out.println("3. TRANSFER"); 
        System.out.println("4. RETURN");
        System.out.print("Enter the desired operation: ");
        choice2 = sc.nextInt();

        switch (choice2) {
            case 1:
            System.out.println("");
            System.out.print("Acoount number: ");
            int accNumber = sc.nextInt();
            BankAccount chosen = (accNumber == bankaccount1.getNumber()) ? bankaccount1 : bankaccount2;
            System.out.print("Enter a deposit value: ");
            double amount = sc.nextDouble();
            chosen.deposit(amount);
            break;
            case 2:
                System.out.println("");
                System.out.print("Acoount number: ");
                accNumber = sc.nextInt();
                chosen = (accNumber == bankaccount1.getNumber()) ? bankaccount1 : bankaccount2;
                System.out.print("Enter a withdraw value: ");
                amount = sc.nextDouble();
                
                chosen.withdraw(amount);
            break;
            case 3:
                System.out.print("From account number: ");
                int fromNumber = sc.nextInt();
                System.out.print("To account number: ");
                int toNumber = sc.nextInt();
                System.out.print("Transfer amount: ");
                amount = sc.nextDouble();

                BankAccount from = (fromNumber == bankaccount1.getNumber()) ? bankaccount1 : bankaccount2;
                BankAccount to = (toNumber == bankaccount1.getNumber()) ? bankaccount1 : bankaccount2;

                System.out.println("Transferring $ " + String.format("%.2f", amount)+ " from " + from.getHolder() + " to " + to.getHolder() + "...");
                from.transferTo(to, amount);
            break;
            case 4: 
            break;
        } 
    }while(choice2 != 4);

    System.out.println("");
    System.out.println(bankaccount1);
    System.out.println(bankaccount2);

                        
    sc.close();
                        
    }

}

