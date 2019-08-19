package medium;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-16
 * time        : 15:33
 * description : https://leetcode.com/problems/merge-intervals/
 * 题意：给一个区间的集合，合并有重叠的区间。
 * 思路一：建立一个 interval 类，存储区间两个端点，构建图，当两个 interval 之间有重叠时，表明这两个节点之间是连通的。
 * 思路二：排序。
 */
public class T56_MergeIntervals {

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(nums);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // 将二维数组封装为 interval 的链表
    public static int[][] merge(int[][] intervals) {
        // 封装
        List<Interval> newIntervals = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            newIntervals.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        List<Interval> merged = mergeCore(newIntervals);
        // 解封装为二维数组
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            Interval temp = merged.get(i);
            result[i] = new int[]{temp.start, temp.end};
        }
        return result;
    }

    private static List<Interval> mergeCore(List<Interval> intervals) {
        buildGraph(intervals);
        buildComponents(intervals);
        List<Interval> merged = new LinkedList<>();
        for (int comp = 0; comp < nodesInComp.size(); comp++) {
            merged.add(mergeNodes(nodesInComp.get(comp)));
        }
        return merged;
    }

    // 根据区间集合（链表）构建图
    private static Map<Interval, List<Interval>> graph;

    private static void buildGraph(List<Interval> intervalList) {
        graph = new HashMap<>();
        for (Interval interval : intervalList) {
            graph.put(interval, new LinkedList<>());
        }
        // 将有重叠的区间相互添加到其对应的链表中
        for (Interval interval1 : intervalList) {
            for (Interval interval2 : intervalList) {
                if (hasOverLapping(interval1, interval2)) {
                    graph.get(interval1).add(interval2);
                    graph.get(interval2).add(interval1);
                }
            }
        }
    }

    private static Map<Integer, List<Interval>> nodesInComp;
    private static Set<Interval> visited;

    private static void buildComponents(List<Interval> intervals) {
        nodesInComp = new HashMap<>();
        visited = new HashSet<>();
        int compNumber = 0;
        for (Interval interval : intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber);
                compNumber++;
            }
        }
    }

    private static Interval mergeNodes(List<Interval> nodes) {
        int minStart = nodes.get(0).start;
        int maxEnd = nodes.get(0).end;

        for (Interval node : nodes) {
            minStart = Math.min(minStart, node.start);
            maxEnd = Math.max(maxEnd, node.end);
        }
        return new Interval(minStart, maxEnd);
    }

    private static void markComponentDFS(Interval start, int compNumber) {
        Stack<Interval> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            Interval node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);

                if (nodesInComp.get(compNumber) == null) {
                    nodesInComp.put(compNumber, new LinkedList<>());
                }
                nodesInComp.get(compNumber).add(node);
                for (Interval child : graph.get(node)) {
                    stack.add(child);
                }
            }
        }
    }

    // 判断两个区间类是否有重叠
    private static boolean hasOverLapping(Interval a, Interval b) {
        return a.start <= b.end && b.start <= a.end;
    }


    public static int[][] merge2(int[][] intervals) {

        return null;
    }


}

class Interval implements Comparator<Interval>, Comparable<Interval>{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        return 0;
    }

    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.start < o2.start) return -1;
        else if (o1.start > o2.start) {
            return 1;
        } else {
            if (o1.end > o2.end) return 1;
            else if (o1.end == o2.end) return 0;
            else return -1;
        }
    }
}


