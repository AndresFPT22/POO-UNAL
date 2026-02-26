package com.mycompany.ejercicio2_3;

import java.util.Scanner;

public class Ejercicio2_3 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingrese la marca del autómovil:");
        String carBrand = input.nextLine();
        
        System.out.println("Ingrese el modelo:");
        int model = input.nextInt();
        
        System.out.println("Ingrese el volumen en litros del cilindraje del motor del automóvil:");
        int motor = input.nextInt();
        
        input.nextLine();
        
        System.out.println("Ingrese el tipo de combustible(gasolina, bioetanol, diesel, biodiesel o gas_natural:");
        String fuel = input.nextLine().toUpperCase();
        Automovil.tipoCombustible fuelType = Automovil.tipoCombustible.valueOf(fuel);
        
        System.out.println("Ingrese el tipo de automóvil(ciudad, compacto, subcompacto, familiar, ejecutivo o SUV");
        String car = input.nextLine().toUpperCase();
        Automovil.tipoAutomovil carType = Automovil.tipoAutomovil.valueOf(car);
        
        System.out.println("Ingrese la cantidad de puertas del vehículo:");
        int numberOfDoors = input.nextInt();
                
        System.out.println("Ingrese el número de asientos del vehículo:");
        int numberOfSeats = input.nextInt();
        
        var carro = new Automovil(carBrand, model, motor, fuelType, carType, numberOfDoors, numberOfSeats);
        
        System.out.println("Ingrese la velocidad maxima del vehículo en km/h:");
        int maximumSpeed = input.nextInt();
        carro.setMaximumSpeed(maximumSpeed);
        
        input.nextLine();
        
        System.out.println("Ingrese el color del automóvil(blanco, negro, rojo, naranja, amarillo, verde, azul o violeta):");
        String color = input.nextLine().toUpperCase();
        Automovil.tipoColor colorType = Automovil.tipoColor.valueOf(color);
        carro.setColorType(colorType);
        
        System.out.println("Ingrese la velocidad actual del vehículo:");
        int currentSpeed = input.nextInt();
        carro.setCurrentSpeed(currentSpeed);
        
        System.out.println("\n");
        
        System.out.println("Ingrese cuanto desea aumentar la velocidad en km/h");
        int speedIncrease = input.nextInt();
        
        System.out.println("Ingrese cuanto desea disminuir la velocidad en km/h");
        int speedDecrease = input.nextInt();
        
        System.out.println("Ingrese la distancia en kilómetros que recorrera el automóvil: ");
        int distance = input.nextInt();
        
        System.out.println("\n"); 
        
        carro.accelerate(speedIncrease);
        carro.decelerate(speedDecrease);
        
        System.out.println("Ingrese 'true' si quiere frenar o 'false' de lo contrario");
        boolean sino = input.nextBoolean();
        carro.break_(sino);
        
        System.out.println("\n");
        
        carro.print();
        
        System.out.println("La velocidad máxima del vehículo es: "+carro.getMaximumSpeed());
        System.out.println("El color del automóvil es: "+carro.getColorType());
        
        System.out.println("La velocidad actual del vehículo es: "+carro.getCurrentSpeed());
        
        carro.calculateTime(distance);
        
    }
}
