package org.behavioural.momento;

class Memento {
   private final String state;

   public Memento(String state) {
      this.state = state;
   }

   public String getState() {
      return state;
   }
}

class Originator {
   private String state;

   public void setState(String state) {
      this.state = state;
   }

   public String getState() {
      return state;
   }

   public Memento saveStateToMemento() {
      return new Memento(state);
   }

   public void restoreStateFromMemento(Memento memento) {
      state = memento.getState();
   }
}

class Caretaker {
   private Memento memento;

   public void saveMemento(Memento memento) {
      this.memento = memento;
   }

   public Memento retrieveMemento() {
      return memento;
   }
}

class Main {
   public static void main(String[] args) {
      Originator originator = new Originator();
      Caretaker caretaker = new Caretaker();

      originator.setState("State 1");
      caretaker.saveMemento(originator.saveStateToMemento());

      originator.setState("State 2");
      caretaker.saveMemento(originator.saveStateToMemento());

      originator.setState("State 3");
      System.out.println("Current state: " + originator.getState());

      originator.restoreStateFromMemento(caretaker.retrieveMemento());
      System.out.println("Restored state: " + originator.getState());
   }
}

