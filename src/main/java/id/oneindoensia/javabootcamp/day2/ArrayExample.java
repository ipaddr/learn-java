package id.oneindoensia.javabootcamp.day2;

public class ArrayExample {
    public static void main(String[] args) {
        // declares an Array of integers.
        int[] arr;

        // allocating memory for 5 integers.
        arr = new int[5];

        // initialize the first elements of the array
        arr[0] = 10;

        // initialize the second elements of the array
        arr[1] = 20;

        //so on...
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        // accessing the elements of the specified array
        for (int i = 0; i < arr.length; i++)
            System.out.println("Element at index " + i +
                    " : "+ arr[i]);

        // student
        // declares an Array of integers.
        Student[] arrStudent;

        // allocating memory for 5 objects of type Student.
        arrStudent = new Student[5];

        // initialize the first elements of the array
        arrStudent[0] = new Student(1,"Budi");

        // initialize the second elements of the array
        arrStudent[1] = new Student(2,"Andi");

        // so on...
        arrStudent[2] = new Student(3,"Susi");
        arrStudent[3] = new Student(4,"Tony");
        arrStudent[4] = new Student(5,"Tono");

        // accessing the elements of the specified array
        for (int i = 0; i < arrStudent.length; i++)
            System.out.println("Element at " + i + " : " +
                    arrStudent[i].roll_no +" "+ arrStudent[i].name);

        /**
         * Multi dimension array
         */

        // declaring and initializing 2D array
        int arrMulti[][] = { {2,7,9},{3,6,1},{7,4,2} };

        // printing 2D array
        for (int i=0; i< 3 ; i++)
        {
            for (int j=0; j < 3 ; j++)
                System.out.print(arrMulti[i][j] + " ");

            System.out.println();
        }

        /**
         * clone array
         */
        int intArray[] = {1,2,3};

        int cloneArray[] = intArray.clone();

        // will print false as deep copy is created
        // for one-dimensional array
        System.out.println(intArray == cloneArray);

        for (int i = 0; i < cloneArray.length; i++) {
            System.out.print(cloneArray[i]+" ");
        }

    }

    public static class Student
    {
        public int roll_no;
        public String name;
        Student(int roll_no, String name)
        {
            this.roll_no = roll_no;
            this.name = name;
        }
    }
}
