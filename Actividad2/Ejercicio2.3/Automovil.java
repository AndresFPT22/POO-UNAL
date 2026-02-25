package com.mycompany.ejercicio2_3;

public class Automovil {
    
    String carBrand;
    int model;
    int motor;
    enum tipoCombustible{GASOLINA, BIOETANOL, DIESEL, BIODISEL, GAS_NATURAL}
    tipoCombustible fuelType;
    enum tipoAutomovil{CIUDAD, COMPACTO, SUBCOMPACTO, FAMILIAR, EJECUTIVO, SUV}
    tipoAutomovil carType;
    int numberOfDoors;
    int numberOfSeats;
    int maximumSpeed;
    enum tipoColor{BLANCO, NEGRO, ROJO, NARANJA, AMARILLO, VERDE, AZUL, VIOLETA}
    tipoColor colorType;
    int currentSpeed=0;
    
    Automovil(String carBrand, int model, int motor, tipoCombustible fuelType, tipoAutomovil carType, 
            int numberOfDoors, int numberOfSeats){
        
        this.carBrand = carBrand;
        this.model = model;
        this.motor = motor;
        this.fuelType = fuelType;
        this.carType = carType;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        
    }
    public void accelerate(int incrementoVelocidad){
        
        if(incrementoVelocidad+currentSpeed<maximumSpeed){
            currentSpeed+=incrementoVelocidad;
            System.out.println("Velocidad actual:"+currentSpeed);
        }
        
        else{
            System.out.println("El incremento de velocidad no puede superar la velocidad máxima");
        }
    }
    
    public void decelerate(int decrementoVelocidad){
        
        if(currentSpeed-decrementoVelocidad>=0){
            currentSpeed-=decrementoVelocidad;
            System.out.println("Velocidad actual:"+currentSpeed);
        }
        
        else{
            System.out.println("La velocidad no puede ser negativa");
        }
    }
    
    public void break_(boolean sino){
        
        if(sino){
            currentSpeed=0;
        }
    }
    
    public void calculateTime(int distancia){
        if (this.currentSpeed != 0){
            double time = (double) distancia / this.currentSpeed; 
            System.out.println("El automovil tardará " + time + " horas en llegar");
        } else {
            System.out.println("El automóvil nunca llegará");
        }
    }
    
    public void print(){
        
        System.out.println("La marca del automóvil es: "+carBrand);
        System.out.println("El modelo es: "+model);
        System.out.println("El volumen en litros del cilindraje del motor del automóvil: "+motor);
        System.out.println("El tipo de combustible del vehículo es: "+fuelType);
        System.out.println("El tipo de automóvil es: "+carType);
        System.out.println("El número de puertas del vehículo es: "+numberOfDoors);
        System.out.println("La cantidad de asientos del vehículo es: "+numberOfSeats);
        
        
    }
    
    int getMaximumSpeed(){
        return maximumSpeed;
    }
    
    tipoColor getColorType(){
        return colorType;
    }
    
    int getCurrentSpeed(){
        return currentSpeed;
    }

    void setMaximumSpeed(int maximumSpeed){
        this.maximumSpeed = maximumSpeed;
    }
    
    void setColorType(tipoColor colorType){
        this.colorType = colorType;
    }
    
    void setCurrentSpeed(int currentSpeed){
        this.currentSpeed = currentSpeed;
    }
}
