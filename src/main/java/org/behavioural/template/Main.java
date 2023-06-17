package org.behavioural.template;


   abstract class AbstractClass {
      public void templateMethod() {
         step1();
         step2();
         step3();
      }

      protected abstract void step1();

      protected abstract void step2();

      protected abstract void step3();
   }

   class ConcreteClass extends AbstractClass {
      @Override
      protected void step1() {
         System.out.println("ConcreteClass: Step 1");
      }

      @Override
      protected void step2() {
         System.out.println("ConcreteClass: Step 2");
      }

      @Override
      protected void step3() {
         System.out.println("ConcreteClass: Step 3");
      }
   }

   class Main {
      public static void main(String[] args) {
         AbstractClass abstractClass = new ConcreteClass();
         abstractClass.templateMethod();
      }
   }
