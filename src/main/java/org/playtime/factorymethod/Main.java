package org.playtime.factorymethod;


import java.util.Arrays;

interface ICalculation {
   double compute(int ... a);
}

class XRayCalculation implements ICalculation {

   public XRayCalculation() {
   }

   @Override
   public double compute(int ... Voltage) {
      if (Voltage.length == 1) {
         double ENERGY_CONSTANT = 1.60217662 * 10e-19;
         return ENERGY_CONSTANT * Voltage[0];
      }
      double sum = Arrays.stream(Voltage).asDoubleStream().sum();
      return 1.60217662*10e-19*sum;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

}

class AddCalculation implements ICalculation {

   public AddCalculation() {
   }

   public double compute(int... a){
      int sum = 0;
      for (int j : a) {
         sum += j;
      }
      return sum;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public boolean equals(Object obj) {
      return super.equals(obj);
   }

}


abstract class CalculationFactory {
   public abstract ICalculation createCalculation();

   public void executeCompute() {
      ICalculation icalc = createCalculation();
      icalc.compute();
   }
}

class XRayCalculationFactory extends CalculationFactory {

   @Override
   public ICalculation createCalculation() {
      return new XRayCalculation();
   }
}

class MyAddCalculationFactory extends CalculationFactory {

   @Override
   public ICalculation createCalculation() {
      return new AddCalculation();
   }
}


public class Main {
   public static void main(String[] args) {
      CalculationFactory xrayFac = new XRayCalculationFactory();
      System.out.println("xray: " + xrayFac.createCalculation().compute(200));

      CalculationFactory addFac  = new MyAddCalculationFactory();
      System.out.println("xray: " + addFac.createCalculation().compute(1,1,1));
   }
}
