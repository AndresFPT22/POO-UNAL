package com.mycompany.ejercicio2_5;

public class CuentaBancaria {
    
    String names;
    String lastNames;
    long accountNumber;
    public enum type{AHORROS, CORRIENTE}
    type accountType;
    double balance=0;
    
    public CuentaBancaria(String names, String lastNames, long accountNumber, type accountType){
        
        this.names = names;
        this.lastNames = lastNames;
        this.accountNumber = accountNumber;
        this.accountType = accountType;

    }
    
    public void print(){
        
        System.out.println("Nombres del titular: "+names);
        System.out.println("Apellidos del titular: "+lastNames);
        System.out.println("Número de cuenta: "+accountNumber);
        System.out.println("Tipo de cuenta: "+accountType);
        System.out.println("Saldo disponible: "+balance);
    }
    
    public double Balance(){
        return balance;
    }
    
    public void ConsignMoney(long addedMoney){
        
        if(addedMoney<0){
            System.out.println("No puedes consignar dinero negativo");
        }
        
        else{
            balance+=addedMoney;
            System.out.println("Ingresaste $"+addedMoney+" exitosamente a la cuenta "+accountNumber+", el nuevo saldo es: $"+balance);
        }
    }
    
    public void WithdrawMoney(long moneyTaken){
        
        if(moneyTaken>balance && moneyTaken>0){
            System.out.println("No cuenta con saldo suficiente para efectuar este retiro");
        }
        else{
            balance-=moneyTaken;
            System.out.println("Retiraste $"+moneyTaken+" exitosamente de la cuenta "+accountNumber+", el nuevo saldo es: $"+balance);
        }
    }
}
