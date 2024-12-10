package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTrasaction extends BaseTransaction {
    public DepositTrasaction(int amount, @NotNull Calendar date){
        super(amount, date);
    }
    private boolean checkDepositAmount(double amt){
        if (amt < 0){
           return false;
        }
        else{
            return  true;
        }
    }

    // Method to print a transaction receipt or details
    public void printTransactionDetails(){
        System.out.println("Deposit Trasaction: "+this.toString());
    }

    public void apply(BankAccount ba){
        double amount = getAmount();
        if (!checkDepositAmount(amount)){
            throw new IllegalArgumentException("Deposit amount not valid");
        }
        double curr_balance = ba.getBalance();
        double new_balance = curr_balance + amount;
        ba.setBalance(new_balance);
        System.out.println("Deposit amount successfully paid (balance): "+new_balance);
    }
}