package org.behavioural.strategy;

interface SortingStrategy {
   void sort(int[] array);
}

class BubbleSortStrategy implements SortingStrategy {
   @Override
   public void sort(int[] array) {
      System.out.println("Sorting array using Bubble Sort");
      // Bubble Sort implementation
   }
}

class QuickSortStrategy implements SortingStrategy {
   @Override
   public void sort(int[] array) {
      System.out.println("Sorting array using Quick Sort");
      // Quick Sort implementation
   }
}

class Context {
   private SortingStrategy sortingStrategy;

   public void setSortingStrategy(SortingStrategy sortingStrategy) {
      this.sortingStrategy = sortingStrategy;
   }

   public void performSort(int[] array) {
      sortingStrategy.sort(array);
   }
}

class Main {
   public static void main(String[] args) {
      Context context = new Context();

      SortingStrategy bubbleSortStrategy = new BubbleSortStrategy();
      context.setSortingStrategy(bubbleSortStrategy);
      int[] array1 = {5, 2, 7, 1, 9};
      context.performSort(array1);

      SortingStrategy quickSortStrategy = new QuickSortStrategy();
      context.setSortingStrategy(quickSortStrategy);
      int[] array2 = {3, 8, 4, 6, 0};
      context.performSort(array2);
   }
}

