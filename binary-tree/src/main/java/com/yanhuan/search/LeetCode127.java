package com.yanhuan.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 单词接龙
 *
 * @author YanHuan
 * @date 2021-01-23 16:00
 */
public class LeetCode127 {

    /**
     * 解法1. 广度优先遍历
     * 时间复杂度：O(N*C^2) N为wordList的长度，C为列表单词的平均长度
     * * 建图过程中，对于每一个单词，我们需要枚举他连接到的所有虚拟节点，时间复杂度为O(C)，将这些单词加入到哈希表中，时间复杂度为O(N*C),因此总的时间复杂度为O(N*C)。
     * * 广度优先搜索的时间复杂度最坏情况下是O(N*C)，每个单词需要扩展出O(C)个虚拟节点，因此节点数O(N*C)。
     * 空间复杂度：O(N*C^2) N为wordList的长度，C为列表单词的平均长度，哈希表中包含 (N*C) 个节点，每个节点占用空间 O(C)，因此总的空间复杂度为 O(N×C^2)。
     *
     * @param beginWord 开始
     * @param endWord   结束
     * @param wordList  字典
     * @return 长度
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //1.将wordList放入哈希表中，便于判断某个单词是否在wordList里
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        //2.图的广度优先遍历，必须使用队列和表示是否访问过的visited哈希表
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        //3.开始广度优先遍历，初始化步数为1
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //一次遍历当前队列中的单词
                String currentWord = queue.poll();
                //如果currentWord能够修改1个字符与endWord相同，则返回step+1
                if (change(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean change(String currentWord, String endWord, LinkedList<String> queue, HashSet<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            //先保存，后恢复
            char c = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == c) {
                    //相同，跳过本次
                    continue;
                }
                //不相同，替换
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                //在字典当中
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        //相等，直接返回
                        return true;
                    }
                    //不相等，没访问过，加到队列当中，下一轮外层访问
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            //恢复原字符串
            charArray[i] = c;
        }
        return false;
    }
}
