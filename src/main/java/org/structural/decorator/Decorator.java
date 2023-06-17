package org.structural.decorator;

interface Pizza {
   String getDescription();
   double getCost();
}

class Margherita implements Pizza {
   @Override
   public String getDescription() {
      return "Margherita Pizza";
   }

   @Override
   public double getCost() {
      return 8.99;
   }
}

abstract class PizzaDecorator implements Pizza {
   protected Pizza pizza;

   public PizzaDecorator(Pizza pizza) {
      this.pizza = pizza;
   }

   @Override
   public String getDescription() {
      return pizza.getDescription();
   }

   @Override
   public double getCost() {
      return pizza.getCost();
   }
}

class CheeseDecorator extends PizzaDecorator {
   public CheeseDecorator(Pizza pizza) {
      super(pizza);
   }

   @Override
   public String getDescription() {
      return pizza.getDescription() + ", Cheese";
   }

   @Override
   public double getCost() {
      return pizza.getCost() + 2.0;
   }
}

class TomatoDecorator extends PizzaDecorator {
   public TomatoDecorator(Pizza pizza) {
      super(pizza);
   }

   @Override
   public String getDescription() {
      return pizza.getDescription() + ", Tomato";
   }

   @Override
   public double getCost() {
      return pizza.getCost() + 1.5;
   }
}

class Main {
   public static void main(String[] args) {
      Pizza margherita = new Margherita();
      System.out.println(margherita.getDescription() + " - Cost: $" + margherita.getCost());

      Pizza cheeseMargherita = new CheeseDecorator(margherita);
      System.out.println(cheeseMargherita.getDescription() + " - Cost: $" + cheeseMargherita.getCost());

      Pizza deluxePizza = new TomatoDecorator(new CheeseDecorator(new Margherita()));
      System.out.println(deluxePizza.getDescription() + " - Cost: $" + deluxePizza.getCost());
   }
}

