package org.creational.factorymethod;

// Product interface
interface Animal {
   void speak();
}

// Concrete product classes
class Dog implements Animal {
   @Override
   public void speak() {
      System.out.println("Dog says: Woof!");
   }
}

class Cat implements Animal {
   @Override
   public void speak() {
      System.out.println("Cat says: Meow!");
   }
}

// Creator class
abstract class AnimalFactory {
   public abstract Animal createAnimal();

   public void performSpeak() {
      Animal animal = createAnimal();
      animal.speak();
   }
}

// Concrete creator classes
class DogFactory extends AnimalFactory {
   @Override
   public Animal createAnimal() {
      return new Dog();
   }
}

class CatFactory extends AnimalFactory {
   @Override
   public Animal createAnimal() {
      return new Cat();
   }
}

// Client code
class Main {
   public static void main(String[] args) {
      AnimalFactory dogFactory = new DogFactory();
      dogFactory.performSpeak();

      AnimalFactory catFactory = new CatFactory();
      catFactory.performSpeak();
   }
}

