package sorting;

import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        int[] sizes = {100, 200, 400, 800};

        for (int size : sizes) {
            System.out.println("\n----------------");
            System.out.println("Array size: " + size);
            System.out.println("------------------------------");

            int[] testInput = randomArray(size);

            
            TestSuite.run(testInput, 1000);
        }
    }

    public static int[] randomArray(int length)
    {
        Random rand = new Random();
        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = rand.nextInt(10_000); 
        }
        return a;
    }
}
