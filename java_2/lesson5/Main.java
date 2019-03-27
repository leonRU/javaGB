package lesson5;

import java.util.Arrays;

public class Main{

    private static final int size = 1000000;
    private static final int h = size / 2;
    private static float[] arr = new float[size];

    public static void main(String[] args){
        Arrays.fill(arr, 1);
        withoutThreads();
        withThreads();

        /*RESULT
        ##### withoutThreads #####
        975
        ##### withThreads #####
        4*/

    }

    private static void withoutThreads(){
        System.out.println("##### withoutThreads #####");

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void withThreads(){
        System.out.println("##### withThreads #####");

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        new Thread(new MyRunnable(arr1, 0)).start();
        new Thread(new MyRunnable(arr2, h)).start();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);
    }

    static class MyRunnable implements Runnable{

        private float[] arr;
        private int offset;

        MyRunnable(float[] array, int offset){
            this.arr = array;
            this.offset = offset;
        }
        @Override
        public void run() {
            for(int i = 0; i < arr.length; i++){
                arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + (i + offset) / 2));
            }
        }
    }
}