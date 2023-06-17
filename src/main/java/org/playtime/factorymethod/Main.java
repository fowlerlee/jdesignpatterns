package org.playtime.factorymethod;


import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.Math.pow;

interface ICalculation {
   double value = 0;
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
class EnsteinCalculation implements ICalculation {

   public EnsteinCalculation() {
   }

   @Override
   public double compute(int... a) {
      synchronized (this){
         double LIGHT_SPEED_SQUARED = pow(299_792_458, 2);
         if (a.length == 1) {
            return LIGHT_SPEED_SQUARED * a[0];
         }
         double sum = Arrays.stream(a).asDoubleStream().sum();
         return LIGHT_SPEED_SQUARED * sum;
      }
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

class EnsteinCalculationFactory extends CalculationFactory {
   public ICalculation createCalculation() {
      return new EnsteinCalculation();
   }

}


public class Main {
   public static void main(String[] args) {
      CalculationFactory xrayFac = new XRayCalculationFactory();
      System.out.println("xray: " + xrayFac.createCalculation().compute(200));

      CalculationFactory addFac  = new MyAddCalculationFactory();
      System.out.println("add calc: " + addFac.createCalculation().compute(1,1,1));

      CalculationFactory einstein = new EnsteinCalculationFactory();
      System.out.println("enstein calc: " +  einstein.createCalculation().compute(1000));

      CalculationFactory speedy = new EnsteinCalculationFactory();
      final ICalculation spC = speedy.createCalculation();
      Runnable a = () -> System.out.println("Enstein From A: " + spC.compute(1000));
      Runnable b = () -> System.out.println("Enstein From B: " + spC.compute(500));

      final ExecutorService executorService = Executors.newFixedThreadPool(2);
      executorService.submit(a);
      executorService.submit(b);

      executorService.shutdown();
   }
}
