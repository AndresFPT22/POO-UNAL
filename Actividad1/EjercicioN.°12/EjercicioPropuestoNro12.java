package com.mycompany.ejerciciopropuestonro12;

public class EjercicioPropuestoNro12 {

    public static void main(String[] args) {
        double horasTrabajadas;
        double tarifa;
        double salarioBruto;
        double retencionFuente;
        double salarioNeto;
        
        horasTrabajadas=48;
        tarifa=5000;
        
        salarioBruto = CalcularSalario.salarioBruto(horasTrabajadas, tarifa);
        retencionFuente = CalcularSalario.retencionFuente(salarioBruto);
        salarioNeto = CalcularSalario.salarioNeto(salarioBruto, retencionFuente);
        
        System.out.println("El salario bruto es: "+salarioBruto+", la retención de la fuente es: "+retencionFuente+" y el salario neto es: "+salarioNeto);
    }
}
