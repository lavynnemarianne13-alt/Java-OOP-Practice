public final class BankAccount{

    private final int number; 
    private String holder; 
    private double balance;
    
    public BankAccount (int number, String holder){
        this.number=number;
        this.holder=holder;
        this.balance=0.0;
    }
    public BankAccount (int number, String holder, double balanceInitial){
        this(number,holder);
        deposit(balanceInitial);
    }
    public void setHolder(String holder){
        this.holder=holder;
    }
    public String getHolder(){
        return holder;
    }
    public int getNumber(){
        return number;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }else{
            System.out.println("Transaction unavailable. Deposit amount must be greater than zero");
        }
    }
    public void withdraw(double amount){
        if (balance < amount + 5.0){
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount + 5.0;
    }
    public void transferTo(BankAccount other, double amount){
        if (this == other){
            System.out.println("Transfer cannot be performed: source and destination accounts are the same");
            return;
        }
        if(balance< amount + 2.0){
            System.out.println("Insufficient balance");
            return;
        }
        this.balance -= amount + 2.0;
        other.deposit(amount);
    }
    @Override
    public String toString(){
        return String.format("Account: %d, Holder: %s, Balance: %.2f", number,holder,balance);
    }
}
