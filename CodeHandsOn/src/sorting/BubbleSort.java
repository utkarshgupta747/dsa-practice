package sorting;

import java.util.Scanner;

public class BubbleSort {

    public static void bubbleSort(int[] arr, int n){
        for(int pass=0; pass<n; pass++) {
            for(int i=0; i<n-1-pass; i++) { //here, i<n-1-pass as ''n-1' to avoid out of bound as we are comparing next element
                                    // and 'n-1-pass' as with every pass the largest element will be placed at last so we can skip that position with every pass

                if(arr[i]>arr[i+1]) { //not in correct order as we want in ascending order
                    //swap elements
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    public static void optimisedBubbleSort(int[] arr, int n){
        boolean isSwapped = false; //to check if swapping is done in a pass
        for(int pass=0; pass<n; pass++) {
            for (int i = 0; i < n - 1 - pass; i++) {
                if (arr[i] > arr[i + 1]) {
                    //swap elements
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    isSwapped = true;
                }
            }
            if (!isSwapped) { //to check if array is already sorted because if no swapping is done that means array is already sorted
                //no more sorting is required
                return;
            }
        }
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of array: ");
        for(int i=0; i<size; i++){
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
        }

        System.out.println("The elements of the array before sorting: ");
        printArray(arr);

//        bubbleSort(arr, size);
        optimisedBubbleSort(arr, size);

        System.out.println('\n' + "The elements of the array after sorting: ");
        printArray(arr);

    }
}
