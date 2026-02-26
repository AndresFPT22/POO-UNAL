package com.mycompany.ejercicio2_5;

import java.util.Scanner;

public class Ejercicio2_5 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingrese su nombre:");
        String names = input.nextLine();
        
        System.out.println("Ingrese sus apellidos:");
        String lastNames = input.nextLine();
        
        System.out.println("Ingrese su número de cuenta:");
        long accountNumber = input.nextLong();
        
        System.out.println("Ingrese su tipo de cuenta(ahorros o corriente):");
        String type = input.next().toUpperCase();
        CuentaBancaria.type accountType = CuentaBancaria.type.valueOf(type);
        
        System.out.println("\n");
        
        var BankAccount = new CuentaBancaria(names, lastNames, accountNumber, accountType);
        
        do{
            System.out.println("Ingrese '1' si desea consultar el saldo de su cuenta:");
            System.out.println("Ingrese '2' si desea ver el estado general de su cuenta:");
            System.out.println("Ingrese '3' si desea consignar dinero a su cuenta:");
            System.out.println("Ingrese '4' si desea retirar dinero de su cuenta:");
            System.out.println("Ingrese 'salir' si desea salir del sistema:");
            String value = input.next().toLowerCase().trim();
            
            System.out.println("\n");
            
            if(value.equals("1")){
                
                System.out.println("Saldo en la cuenta "+accountNumber+" es: "+BankAccount.Balance());
                System.out.println("\n");
                
            }
            
            if(value.equals("2")){
                
                BankAccount.print();
                System.out.println("\n");
                
            }
            
            if(value.equals("3")){
                
                System.out.println("Ingrese cuanto desea consignar a la cuenta "+accountNumber);
                long addedMoney = input.nextLong();
                BankAccount.ConsignMoney(addedMoney);
                System.out.println("\n");
                
            }
            
            if(value.equals("4")){
                
                System.out.println("Ingrese cuanto desea retirar de la cuenta "+accountNumber);
                long moneyTaken = input.nextLong();
                BankAccount.WithdrawMoney(moneyTaken);
                System.out.println("\n");
                
            }
            
            if(value.equals("salir")){
                
                System.out.println("Saliste exitosamente del sistema");
                break;
                
            }
            
        }while(true);  
    }
}
