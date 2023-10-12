package Behavioural.Strategy;

// Strategy interface
interface SortingStrategy {
    void sort(int[] data);
}

// Concrete strategies
class BubbleSort implements SortingStrategy {
    public void sort(int[] data) {
        // Implementation of bubble sort
        System.out.println("Sorting using Bubble Sort");
    }
}

class MergeSort implements SortingStrategy {
    public void sort(int[] data) {
        // Implementation of merge sort
        System.out.println("Sorting using Merge Sort");
    }
}

class QuickSort implements SortingStrategy {
    public void sort(int[] data) {
        // Implementation of quicksort
        System.out.println("Sorting using QuickSort");
    }
}

// Context
class SortingContext {
    private SortingStrategy strategy;

    SortingContext(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    void executeSort(int[] data) {
        strategy.sort(data);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        int[] data = {5, 2, 8, 9, 1};

        SortingContext context = new SortingContext(new BubbleSort());
        context.executeSort(data); // Sorting using Bubble Sort

        context.setStrategy(new MergeSort());
        context.executeSort(data); // Sorting using Merge Sort
    }
}
