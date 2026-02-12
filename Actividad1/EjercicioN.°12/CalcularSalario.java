package com.mycompany.ejerciciopropuestonro12;

public class CalcularSalario {
    
    public static double salarioBruto(double horas, double tarifa){
        return horas*tarifa;
    }
    
    public static double retencionFuente(double salario){
        return salario*0.125;
    }
    
    public static double salarioNeto(double salario, double retencion){
        return salario-retencion;
    }
}
