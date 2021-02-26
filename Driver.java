
import java.util.Random;
import java.util.Scanner;

public class Driver {

    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*make a determination of which sequence is appropriate for
            i. Small arrays < 5000 elements
            ii. Larger arrays of 10,000, 50,000, 100,000, 1,000,000 etc
            iii. Random, Partial Sort, Inverse Sort
        A) It seems the comb sort did better in every try, while the other 3
        make similar amounts of swaps. The only time the Sedgwick sequence did
        better compared to Hibbard and Knuth was with a large array of random 
        numbers. With partially sorted
        arrays the swaps maintained around 500 even with large size arrays.*/
        int[] Array;
        int[] sequence;
        int size = 0;
        char type;
        int sort;
        String resp;

        do {

            System.out.println("Enter the size of the array: ");
            size = sc.nextInt();

            System.out.println("Enter I for inverse array, R for random array "
                    + "or P for partially sorted array");
            type = sc.next().charAt(0);

            System.out.println("With what sequence do you want to sort it:"
                    + "\n1.Comb Sort\n2.Hibbard\n3.Sedgwick\n4.Knuth");
            sort = sc.nextInt();

            switch (sort) {
                case 1: {
                    Array = generateRandom(size, type);
                    System.out.println(CombSort(Array) + " Swaps were made.");

                    break;
                }

                case 2: {
                    System.out.println("\nArray Sorted with Hibbard");
                    Array = generateRandom(size, type);
                    sequence = hibbard(Array.length);
                    System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

                    break;
                }

                case 3: {
                    System.out.println("\nArray Sorted with Sedgwick");
                    Array = generateRandom(size, type);
                    sequence = merge(sedgwick1(Array.length), sedgwick2(Array.length));
                    System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

                    break;
                }

                case 4: {
                    System.out.println("\nArray Sorted with Knuth");
                    Array = generateRandom(size, type);
                    sequence = knuth(Array.length);
                    System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

                    break;
                }
            }

            System.out.println("Do you want to sort another array? y/n");
            resp = sc.next();

        } while (!resp.equals("n"));

        //20 SORTS SIZE <= 5000 AND RANDOM ARRAY
        /*for (int i = 0; i < 20; i++) {
            System.out.println("------------------------------------------------");
            size += 250;
            System.out.println("Array size: " + size);

            Array = generateRandom(size, 'R');
            System.out.println(CombSort(Array) + " Swaps were made.");

            System.out.println("\nArray Sorted with Hibbard");
            Array = generateRandom(size, 'R');
            sequence = hibbard(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Sedgwick");
            Array = generateRandom(size, 'R');
            sequence = merge(sedgwick1(Array.length), sedgwick2(Array.length));
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Knuth");
            Array = generateRandom(size, 'R');
            sequence = knuth(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");
            System.out.println("------------------------------------------------");
        }
        System.out.println("------------------------------------------------");*/
        //20 SORTS SIZE > 5000 AND RANDOM ARRAY
        /*for (int i = 0; i < 20; i++) {
            System.out.println("------------------------------------------------");
            size +=50000; 
            System.out.println("Array size: " + size);
            
            Array = generateRandom(size, 'R');
            System.out.println(CombSort(Array) + " Swaps were made.");
            

            System.out.println("\nArray Sorted with Hibbard");
            Array = generateRandom(size, 'R');
            sequence = hibbard(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Sedgwick");
            Array = generateRandom(size, 'R');
            sequence = merge(sedgwick1(Array.length), sedgwick2(Array.length));
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Knuth");
            Array = generateRandom(size, 'R');
            sequence = knuth(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");
            System.out.println("------------------------------------------------");
        }*/
        //20 SORTS SIZE <= 5000 AND INVERSELY SORTED ARRAY
        /*for (int i = 0; i < 20; i++) {
            System.out.println("------------------------------------------------");
            size += 250;
            System.out.println("Array size: " + size);

            Array = generateRandom(size, 'I');
            System.out.println(CombSort(Array) + " Swaps were made.");

            System.out.println("\nArray Sorted with Hibbard");
            Array = generateRandom(size, 'I');
            sequence = hibbard(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Sedgwick");
            Array = generateRandom(size, 'I');
            sequence = merge(sedgwick1(Array.length), sedgwick2(Array.length));
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Knuth");
            Array = generateRandom(size, 'I');
            sequence = knuth(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");
            System.out.println("------------------------------------------------");
        }
        System.out.println("------------------------------------------------");*/
        //20 SORTS SIZE > 5000 AND INVERSE ARRAY
        /*for (int i = 0; i < 20; i++) {
            System.out.println("------------------------------------------------");
            size +=50000; 
            System.out.println("Array size: " + size);
            
            Array = generateRandom(size, 'I');
            System.out.println(CombSort(Array) + " Swaps were made.");
            

            System.out.println("\nArray Sorted with Hibbard");
            Array = generateRandom(size, 'I');
            sequence = hibbard(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Sedgwick");
            Array = generateRandom(size, 'I');
            sequence = merge(sedgwick1(Array.length), sedgwick2(Array.length));
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Knuth");
            Array = generateRandom(size, 'I');
            sequence = knuth(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");
            System.out.println("------------------------------------------------");
        }*/
        //20 SORTS SIZE <= 5000 AND PARTIALLY SORTED ARRAY
        /*for (int i = 0; i < 20; i++) {
            System.out.println("------------------------------------------------");
            size += 250;
            System.out.println("Array size: " + size);

            System.out.println("\nArray Sorted with Hibbard");
            Array = generateRandom(size, 'P');
            sequence = hibbard(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Sedgwick");
            Array = generateRandom(size, 'P');
            sequence = merge(sedgwick1(Array.length), sedgwick2(Array.length));
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Knuth");
            Array = generateRandom(size, 'P');
            sequence = knuth(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");
            System.out.println("------------------------------------------------");
        }*/
        //20 SORTS SIZE > 5000 AND PARTIALLY SORTED ARRAY
        /*for (int i = 0; i < 20; i++) {
            System.out.println("------------------------------------------------");
            size += 50000;
            System.out.println("Array size: " + size);

            System.out.println("\nArray Sorted with Hibbard");
            Array = generateRandom(size, 'P');
            sequence = hibbard(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Sedgwick");
            Array = generateRandom(size, 'P');
            sequence = merge(sedgwick1(Array.length), sedgwick2(Array.length));
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");

            System.out.println("\nArray Sorted with Knuth");
            Array = generateRandom(size, 'P');
            sequence = knuth(Array.length);
            System.out.println(ShellSort(Array, sequence) + " Swaps were made.");
            System.out.println("------------------------------------------------");
        }*/
    }

    public static int ShellSort(int[] a, int[] sequence) {

        int temp, n;

        int k = sequence.length - 1;
        int gap;
        int SwapCount = 0;

        for (int j = sequence.length - 1; j >= 0; j--) {
            gap = sequence[j];
            for (int i = gap; i < a.length; i += 1) {

                n = i;
                temp = a[i];

                while (n >= gap && a[n - gap] > temp) {
                    a[n] = a[n - gap];
                    n -= gap;
                    SwapCount++;
                }

                if (a[n] != temp) {
                    a[n] = temp;
                }

            }

        }

        /*while (k >= 1) {

            for (int i = gap; i < a.length; i += 1) {

                n = i;
                temp = a[i];

                while (n >= gap && a[n - gap] > temp) {
                    a[n] = a[n - gap];
                    n -= gap;
                    SwapCount++;
                }

                if (a[n] != temp) {
                    a[n] = temp;
                }

            }
            k--;
            gap = sequence[k];
        }*/
        System.out.println();
        System.out.println("Array sorted by Shell Sort");
        print(a);
        return SwapCount;
    }

    public static int CombSort(int[] a) {
        int SwapCount = 0;
        int countE = a.length;
        int gap = countE;
        boolean switched = true;
        int temp;
        while (switched || gap != 1) {
            switched = false;

            gap = (int) (gap / 1.3);
            if (gap < 1) {
                gap = 1;
            }

            for (int i = 0; i < countE - gap; i++) {
                if (a[i] > a[i + gap]) {

                    temp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = temp;
                    switched = true;
                    SwapCount++;
                }
            }

            if (!switched) {
                break;
            }
            //countE--;
        }

        System.out.println();
        System.out.println("Array sorted by Comb Sort");
        print(a);

        return SwapCount;
    }

    public static int[] hibbard(int size) {

        int h = 1;
        int value;
        int count = 0;

        count = (int) (Math.log(size + 1) / Math.log(2));
        int[] sequence = new int[count];

        for (int i = 0; i < count; i++) {
            value = (int) ((Math.pow(2, h)) - 1);
            sequence[i] = value;
            h++;
        }

        System.out.println();
        System.out.println("Hibbard Sequence");
        print(sequence);
        return sequence;
    }

    public static int[] sedgwick1(int size) {

        int h;
        int value = 0;
        int count = 0;
        while (value <= size) {

            value = (int) (9 * ((Math.pow(4, count) - Math.pow(2, count))) + 1);
            count++;
        }
        int[] sequence = new int[count - 1];

        for (int i = 0; i < sequence.length; i++) {
            value = (int) (9 * ((Math.pow(4, i) - Math.pow(2, i))) + 1);
            sequence[i] = value;
        }

        System.out.println();
        System.out.println("Sedgewick 1 Sequence");
        print(sequence);
        return sequence;
    }

    public static int[] sedgwick2(int size) {

        int h;
        int value = 0;
        int count = 0;
        while (value <= size) {

            value = (int) ((Math.pow(2, (count + 2))) * (Math.pow(2, (count + 2)) - 3) + 1);
            count++;
        }
        int[] sequence = new int[count - 1];

        for (int i = 0; i < sequence.length; i++) {
            value = (int) ((Math.pow(2, (i + 2))) * (Math.pow(2, (i + 2)) - 3) + 1);
            sequence[i] = value;
        }
        System.out.println();
        System.out.println("Sedgewick 2 Sequence");
        print(sequence);

        return sequence;
    }

    public static int[] knuth(int size) {

        int h = 1;
        int value = 0;
        int count = 0;
        while (value <= size) {

            value = (int) (((Math.pow(3, h)) - 1) / 2);
            h++;
            count++;
        }
        int[] sequence = new int[count - 1];
        h = 1;

        for (int i = 0; i < sequence.length; i++) {
            value = (int) (((Math.pow(3, h)) - 1) / 2);
            sequence[i] = value;
            h++;

        }
        System.out.println();
        System.out.println("Knuth Sequence");
        print(sequence);

        return sequence;
    }

    public static int[] generateRandom(int size, char t) {
        int[] array = new int[size];

        switch (t) {
            case 'R': {
                for (int i = 0; i < array.length; i++) {
                    array[i] = rand.nextInt(1000) + 1;
                }
                break;
            }
            case 'I': {
                int temp = 0;
                for (int i = 0; i < array.length; i++) {
                    array[i] = rand.nextInt(1000) + 1;
                }

                for (int i = 0; i < array.length; i++) {
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[i] < array[j]) {
                            temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }
                }

                break;
            }

            case 'P': {
                int temp;
                for (int i = 0; i < array.length; i++) {
                    array[i] = rand.nextInt(1000) + 1;
                }

                for (int i = 0; i < array.length; i++) {
                    for (int j = i + 1; j < array.length; j++) {
                        if (array[i] > array[j]) {
                            temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }
                }

                for (int i = 0; i < array.length - 1; i += 2) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("Array");
        print(array);
        return array;
    }

    public static int[] merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            merged[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }

        while (i < a.length) {
            merged[k++] = a[i++];
        }

        while (j < b.length) {
            merged[k++] = b[j++];
        }

        System.out.println();
        System.out.println("Merged Sedgwick");
        print(merged);
        return merged;
    }

    public static void print(int[] a) {
        for (int l = 0; l < a.length; l++) {
            if (l == 0) {
                System.out.print(a[l]);
            } else {
                System.out.print(", " + a[l]);
            }
        }
        System.out.println("");
    }
}
