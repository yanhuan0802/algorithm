package com.yanhuan.queue;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 前K个高频元素
 *
 * @author YanHuan
 * @date 2021-01-11 23:16
 */
public class LeetCode347 {

    /**
     * 解法1.小根堆
     * 时间复杂度：O(nlogK) n为数组长度  k为堆的大小
     * 空间复杂度：O(n)
     *
     * @param nums 数组
     * @param k    统计数
     * @return 高频值
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return new int[0];
        }
        //按照出现频次统计
        Map<Integer, Integer> map = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        //定义小根堆  由出现频率从小到大排列
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(map::get));
        //遍历集合  如果元素没到K个就放入 如果到K个就去除顶部元素  频次相比
        map.forEach((num, count) -> {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (map.get(queue.peek()) < count) {
                queue.poll();
                queue.offer(num);
            }
        });
        int[] res = new int[k];
        int index = 0;
        for (Integer num : queue) {
            res[index++] = num;
        }
        return res;
    }
}
