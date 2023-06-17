package org.creational.abstractfactory;

// Abstract product interface
interface Button {
   void render();
}

// Concrete product classes
class WindowsButton implements Button {
   @Override
   public void render() {
      System.out.println("Rendering a button in Windows style.");
   }
}

class MacOSButton implements Button {
   @Override
   public void render() {
      System.out.println("Rendering a button in macOS style.");
   }
}

// Abstract factory interface
interface GUIFactory {
   Button createButton();
}

// Concrete factory classes
class WindowsFactory implements GUIFactory {
   @Override
   public Button createButton() {
      return new WindowsButton();
   }
}

class MacOSFactory implements GUIFactory {
   @Override
   public Button createButton() {
      return new MacOSButton();
   }
}

// Client code
class Application {
   private GUIFactory factory;
   private Button button;

   public Application(GUIFactory factory) {
      this.factory = factory;
   }

   public void createUI() {
      button = factory.createButton();
   }

   public void renderUI() {
      button.render();
   }
}

class Main {
   public static void main(String[] args) {
      // Create an application with the Windows factory
      Application windowsApp = new Application(new WindowsFactory());
      windowsApp.createUI();
      windowsApp.renderUI();

      // Create an application with the macOS factory
      Application macOSApp = new Application(new MacOSFactory());
      macOSApp.createUI();
      macOSApp.renderUI();
   }
}

