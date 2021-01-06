package com.yanhuan.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 二叉堆的实现
 *
 * @author YanHuan
 * @date 2021-01-06 22:29
 */
public class BinaryHeap {
    /**
     * d=2  表示二叉堆
     */
    private static final int d = 2;

    /**
     * 数组实现
     */
    private int[] heap;

    /**
     * 堆的大小
     */
    private int heapSize;

    /**
     * 初始化
     * This will initialize our heap with default size.
     */
    public BinaryHeap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    /**
     * 父节点索引
     *
     * @param i 当前节点
     * @return 父节点索引
     */
    private int parent(int i) {
        return (i - 1) / d;
    }

    /**
     * 子节点索引
     *
     * @param i 父节点
     * @param k 子节点位置
     * @return 索引值
     */
    private int kthChild(int i, int k) {
        return d * i + k;
    }

    /**
     * 插入元素
     * Inserts new element in to heap
     * Complexity: O(log N)
     * As worst case scenario, we need to traverse till the root
     */
    public void insert(int x) {
        if (isFull()) {
            throw new NoSuchElementException("Heap is full, No space to insert new element");
        }
        //新元素插入到堆尾
        heap[heapSize] = x;
        heapSize++;
        //向上调整位置
        heapifyUp(heapSize - 1);
    }

    /**
     * 删除某个索引位置元素  （例如堆顶）
     * Deletes element at index x
     * Complexity: O(log N)
     */
    public int delete(int x) {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty, No element to delete");
        }
        //取出堆顶元素
        int maxElement = heap[x];
        //将堆尾元素放置到堆顶
        heap[x] = heap[heapSize - 1];
        //容量减一
        heapSize--;
        //将置换上来的元素向下调整
        heapifyDown(x);
        return maxElement;
    }

    /*** Maintains the heap property while inserting an element.*/

    private void heapifyUp(int i) {
        //新增元素的值
        int insertValue = heap[i];
        //如果新增元素的值大于父节点的值
        while (i > 0 && insertValue > heap[parent(i)]) {
            //将父节点的值赋值在当前新元素的位置，等于父节点下移
            heap[i] = heap[parent(i)];
            //当前节点索引改为父节点的索引
            i = parent(i);
        }
        //当前节点值改为新增的值
        heap[i] = insertValue;
    }

    /*** Maintains the heap property while deleting an element.*/

    private void heapifyDown(int i) {
        int child;
        //当前节点值赋给临时变量
        int temp = heap[i];
        //只要子节点索引小于总容量就循环--》子节点的最大索引不可能大于总容量
        while (kthChild(i, 1) < heapSize) {
            child = maxChild(i);
            //当前节点值大于等于所有子节点值 退出循环
            if (temp >= heap[child]) {
                break;
            }
            //子节点的值赋给当前节点
            heap[i] = heap[child];
            //当前节点下移
            i = child;
        }
        //最初的值赋给当前节点
        heap[i] = temp;
    }

    /**
     * 找出当前节点的子节点中较大的那个节点
     *
     * @param i 父节点索引
     * @return 子节点索引
     */
    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    /**
     * 打印堆中所有的元素
     * Prints all elements of the heap
     */
    public void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    /**
     * 找出堆中的最大值-->即堆顶元素  数组中的第一个值
     * This method returns the max element of the heap
     * complexity: O(1)
     */
    public int findMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        return heap[0];
    }

    public static void main(String[] args) {
        BinaryHeap maxHeap = new BinaryHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.printHeap();
        maxHeap.delete(5);
        maxHeap.printHeap();
        maxHeap.delete(2);
        maxHeap.printHeap();
    }
}