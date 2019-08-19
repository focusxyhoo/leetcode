package algorithms;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-15
 * time        : 10:10
 * description : 堆排序
 * 一定要搞清楚堆排序的思路：
 * 1. 首先建立大顶堆（从倒数第一个非叶子节点开始向上调整），
 * 2. 然后将堆顶元素依次与最后一个元素交换，得到排序结果
 * 几个事实：序列长度为 n，则：
 * 对于当前节点 i，其左右子节点分别是：2 * i + 1，2 * i + 2
 * 倒数第一个非叶子节点：n / 2 - 1；
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {9, 5, 3, 6, 8, 1, 7, 4, 2};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] nums) {
        if (null == nums || nums.length == 0) return;
        // build  max heap
        for (int i = nums.length / 2 - 1; i >= 0; i--) { // 从倒数第一个非叶子节点开始向上调整
            adjustHeap(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums)); // 打印构建好的大顶堆
        for (int i = nums.length - 1; i > 0; i--) {
            BubbleSort.swap(nums, 0, i); // 将堆顶与最后一个元素交换
            adjustHeap(nums, 0, i); // 重新调整堆
        }

    }

    private static void adjustHeap(int[] nums, int index, int length) {
        int temp = nums[index];
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) { // 依次将 temp 与其孩子节点进行比较
            // 左右子节点分别为 2 * i + 1，2 * i + 2
            if (i + 1 < length && nums[i] < nums[i + 1]) i++; // 取左右子节点中最大的那一个
            if (nums[i] > temp) { // 比较，若 temp 小，交换值，只会沿交换过的子树那一边遍历下去
                nums[index] = nums[i];
                index = i;
            } else break; // 若不小于，则说明当前节点比起子树的各个节点都要大，无需任何操作
        }
        nums[index] = temp;
    }
}
