package org.structural.proxy;

interface Image {
   void display();
}

class RealImage implements Image {
   private String filename;

   public RealImage(String filename) {
      this.filename = filename;
      loadFromDisk();
   }

   private void loadFromDisk() {
      System.out.println("Loading image: " + filename);
   }

   @Override
   public void display() {
      System.out.println("Displaying image: " + filename);
   }
}

class ProxyImage implements Image {
   private String filename;
   private RealImage realImage;

   public ProxyImage(String filename) {
      this.filename = filename;
   }

   @Override
   public void display() {
      if (realImage == null) {
         realImage = new RealImage(filename);
      }
      realImage.display();
   }
}

class Main {
   public static void main(String[] args) {
      Image image = new ProxyImage("image.jpg");

      // The real image is loaded and displayed when needed
      image.display();

      // The real image is not loaded again, it is reused from the proxy
      image.display();
   }
}

