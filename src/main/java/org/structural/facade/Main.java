package org.structural.facade;

// Complex subsystem classes
class SubsystemA {
   public void operationA() {
      System.out.println("Subsystem A: Operation A");
   }
}

class SubsystemB {
   public void operationB() {
      System.out.println("Subsystem B: Operation B");
   }
}

class SubsystemC {
   public void operationC() {
      System.out.println("Subsystem C: Operation C");
   }
}

// Facade class
class Facade {
   private SubsystemA subsystemA;
   private SubsystemB subsystemB;
   private SubsystemC subsystemC;

   public Facade() {
      subsystemA = new SubsystemA();
      subsystemB = new SubsystemB();
      subsystemC = new SubsystemC();
   }

   public void performOperations() {
      System.out.println("Facade: Performing operations...");
      subsystemA.operationA();
      subsystemB.operationB();
      subsystemC.operationC();
   }
}

// Client code
class Main {
   public static void main(String[] args) {
      Facade facade = new Facade();
      facade.performOperations();
   }
}


