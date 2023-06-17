package org.behavioural.state;

interface State {
   void doAction(Context context);
}

class StateA implements State {
   @Override
   public void doAction(Context context) {
      System.out.println("State A: Performing action and transitioning to State B");
      context.setState(new StateB());
   }
}

class StateB implements State {
   @Override
   public void doAction(Context context) {
      System.out.println("State B: Performing action and transitioning back to State A");
      context.setState(new StateA());
   }
}

class Context {
   private State currentState;

   public Context() {
      currentState = new StateA(); // Initial state
   }

   public void setState(State state) {
      currentState = state;
   }

   public void performAction() {
      currentState.doAction(this);
   }
}

class Main {
   public static void main(String[] args) {
      Context context = new Context();

      context.performAction();
      context.performAction();
      context.performAction();
   }
}
