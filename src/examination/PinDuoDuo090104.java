package examination;

import algorithms.HeapSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/1
 * time        : 14:57
 * description :
 */
public class PinDuoDuo090104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        Heap nums = new Heap(k);
        for (int i = n; i > 0; i--) {
            for (int j = m; j > 0; j--) {
                nums.add(i * j);
            }
        }
        System.out.println(nums.last());
    }

    private static class Heap {
        private int capacity;
        private int[] data;
        private int size;

        Heap(int capacity) {
            this.capacity = capacity;
            data = new int[capacity];
        }

        public int last() {
            int last = Integer.MAX_VALUE;
            for (int i = size - 1; i > (size - 1) / 2; i--) {
                last = Math.min(last, data[i]);
            }
            return last;
        }

        public void add(int n) {
            if (size < capacity) {
                data[size] = n;
                size++;
                swiftUp();
            } else {
                for (int i = size - 1; i > (size - 1) / 2; i--) {
                    if (data[i] < n) {
                        data[i] = n;
                        swiftUp();
                        break;
                    }
                }
            }
        }

        private void swiftUp() {
            int index = (size - 1) / 2;
            for (; index >= 0; index--) {
                int temp = 2 * index + 1;
                if (temp < size) {
                    int max = data[temp];
                    if (temp + 1 < size && max < data[temp + 1]) {
                        max = data[temp + 1];
                        temp++;
                    }
                    if (max > data[index]) swap(temp, index);
                }
            }
        }

        private void swap(int i, int j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

}
