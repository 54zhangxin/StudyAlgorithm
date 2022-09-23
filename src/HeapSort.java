import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] aar = {9, 8, 7, 6, 5,10, 4, 3, 2, 1};
        sort(aar);
        System.out.println(Arrays.toString(aar));

    }

    private static void sort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }

    }

    public static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i节点的左子节点开始，也就是2i+1出开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子节点小于右子节点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，姜子节点赋值给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp放到最终的位置
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
