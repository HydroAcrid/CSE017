public class Test {
    public static void main(String[] args) {
        int[] list = {67,33,21,84,49,50,75};

        //Selection sort - O(n^2)
        System.out.println("Unsorted: ");
        Sort.printArray(list);
        System.out.println("Sorted Selection: ");
        Sort.selectionSort(list);
        Sort.printArray(list);

        //Insertion sort - O(n^2)
        System.out.println("Unsorted: ");
        Sort.shuffleArray(list);
        Sort.printArray(list);
        System.out.println("Sorted Insertion: ");
        Sort.insertionSort(list);
        Sort.printArray(list);

        //Bubble sort - O(n^2)
        System.out.println("Unsorted: ");
        Sort.shuffleArray(list);
        Sort.printArray(list);
        System.out.println("Sorted Bubble");
        Sort.bubbleSort(list);
        Sort.printArray(list);

        //Merge sort - O(n log n) 
        System.out.println("Unsorted: ");
        Sort.shuffleArray(list);
        Sort.printArray(list);
        System.out.println("Sorted Bubble");
        Sort.mergeSort(list);
        Sort.printArray(list);





    }
    
}
