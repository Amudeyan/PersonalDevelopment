import java.util.stream.IntStream;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int count = 0;
        System.out.println("Non-Zero elements are: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        System.out.println("Zero elements are: ");
        while (count < arr.length) {
            arr[count] = 0;
            count++;
        }
        System.out.println("Array elements are: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


        //Simplification or eNHANCEMENT
        count = 0;
        arr = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        System.out.println("\nNon-Zero elements are: ");
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i];
        System.out.println("Zero elements are: ");
        while (count < arr.length)
            arr[count++] = 0;
        System.out.println("Array elements are: ");
        for (int num : arr)
            System.out.print(num + " ");


        //Streams
        System.out.println("\nMove to Zero in Streams ");
        final int[] arrStream = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        IntStream.concat(IntStream.of(arrStream).filter(num -> num != 0),
                IntStream.of(arrStream).filter(num -> num == 0))
                .forEach(num -> System.out.print(num + " "));
    }}

