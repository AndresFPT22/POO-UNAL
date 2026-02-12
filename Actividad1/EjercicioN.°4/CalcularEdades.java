package com.mycompany.ejercicioresueltonro4;

public class CalcularEdades {

    public static double CalcularEdAlber(double EDJUAN){
        double EDALBER=(2*EDJUAN)/3;
        return EDALBER;
    }
    
    public static double CalcularEdAna(double EDJUAN){
        double EDANA=(4*EDJUAN)/3;
        return EDANA;
    }
    
    public static double CalcularEdMama(double EDANA, double EDJUAN, double EDALBER){
        double EDMAMA=EDANA+EDJUAN+EDALBER;
        return EDMAMA;
    }
}



