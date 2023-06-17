package org.creational.builder;

// Product class
class Car {
   private String brand;
   private String model;
   private String color;
   private int year;
   private int price;

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public void setYear(int year) {
      this.year = year;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   // Other methods and business logic
}

// Abstract builder class
abstract class CarBuilder {
   protected Car car;

   public Car getCar() {
      return car;
   }

   public void createNewCar() {
      car = new Car();
   }

   public abstract void buildBrand();

   public abstract void buildModel();

   public abstract void buildColor();

   public abstract void buildYear();

   public abstract void buildPrice();
}

// Concrete builder classes
class SedanCarBuilder extends CarBuilder {
   public void buildBrand() {
      car.setBrand("Toyota");
   }

   public void buildModel() {
      car.setModel("Camry");
   }

   public void buildColor() {
      car.setColor("Silver");
   }

   public void buildYear() {
      car.setYear(2022);
   }

   public void buildPrice() {
      car.setPrice(25000);
   }
}

class SportsCarBuilder extends CarBuilder {
   public void buildBrand() {
      car.setBrand("Ferrari");
   }

   public void buildModel() {
      car.setModel("488 GTB");
   }

   public void buildColor() {
      car.setColor("Red");
   }

   public void buildYear() {
      car.setYear(2021);
   }

   public void buildPrice() {
      car.setPrice(300000);
   }
}

// Director class
class CarManufacturer {
   private CarBuilder carBuilder;

   public void setCarBuilder(CarBuilder carBuilder) {
      this.carBuilder = carBuilder;
   }

   public Car getCar() {
      return carBuilder.getCar();
   }

   public void constructCar() {
      carBuilder.createNewCar();
      carBuilder.buildBrand();
      carBuilder.buildModel();
      carBuilder.buildColor();
      carBuilder.buildYear();
      carBuilder.buildPrice();
   }
}

// Client code
class Main {
   public static void main(String[] args) {
      CarManufacturer carManufacturer = new CarManufacturer();

      CarBuilder sedanCarBuilder = new SedanCarBuilder();
      carManufacturer.setCarBuilder(sedanCarBuilder);
      carManufacturer.constructCar();
      Car sedanCar = carManufacturer.getCar();

      CarBuilder sportsCarBuilder = new SportsCarBuilder();
      carManufacturer.setCarBuilder(sportsCarBuilder);
      carManufacturer.constructCar();
      Car sportsCar = carManufacturer.getCar();

      System.out.println("Sedan Car: " + sedanCar);
      System.out.println("Sports Car: " + sportsCar);
   }
}

