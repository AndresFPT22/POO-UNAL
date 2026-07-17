package co.unal.edu.Ejercicio6_6;

public class CalculosNumericos {


    static double logaritmoNeperiano(Double numero){

        if(numero<0){

            throw new ArithmeticException("El logaritmo neperiano de un número negativo no esta definido, vuelva a intentarlo.");
        }
        else{

            return Math.log(numero);
        }
    }

    static double raizCuadrada(Double numero){

        if(numero<0){

            throw new ArithmeticException("La raiz cuadrada de un número negativo no esta definida, vuelva a intentarlo.");

        }

        else{

            return Math.sqrt(numero);
        }
    }
}
