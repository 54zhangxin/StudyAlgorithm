package sort;

import java.util.Arrays;

/**
 * 在待排序的数列中，我们首先要找一个数字作为基准数（这只是个专用名词）。为了方便，我们一般选择第 1 个数字作为基准数
 * （其实选择第几个并没有关系）。接下来我们需要把这个待排序的数列中小于基准数的元素移动到待排序的数列的左边，
 * 把大于基准数的元素移动到待排序的数列的右边。这时，左右两个分区的元素就相对有序了；接着把两个分区的元素分别按照上
 * 面两种方法继续对每个分区找出基准数，然后移动，直到各个分区只有一个数时为止。
 *
 *
 * 分治思想
 */
public class 快排 {

    public static void main(String[] args) {
        quickSort(new int[]{39,28,55,87,66,3,17,39});
    }
    public static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int middle;
        if (left < right) {
            middle = partition(arr, left, right);
            quickSort(arr, left, middle - 1);
            quickSort(arr, middle + 1, right);
        }
    }

    //对每一个数组进行分化的代码如下：
    //初始化pivot为数组第一个元素；
    //只要left还小于right就进行循环；
    //外层循环内部如下：
    //先从右边找一个比枢轴元素小的元素；
    //将当前left所指元素赋值为找到的元素；
    //再从左边找一个比枢轴元素大的元素；
    //将当前right所指元素赋值为找到的元素；
    //当left和right相等将枢轴元素赋值在此。
    //最后返回中间元素的索引。

//28,55,87,66,3,17
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            System.out.println(" arr[left]:   "+arr[left]+" arr[right]:  "+arr[right]);
            while (left < right && arr[right] >= pivot) {//先从右边扫描，大于枢轴值就继续扫描
                System.out.println("right pre :   "+right+"   "+arr[right]+"   "+pivot);
                right--;
                System.out.println("right tail :   "+right+"   "+arr[right]+"   "+pivot);
            }
            System.out.println("---------");
            arr[left] = arr[right];
            System.out.println("一次调整 arr[left]:   "+arr[left]+" arr[right]:  "+arr[right]);
            while (left < right && arr[left] <= pivot) {
                System.out.println("left pre :   "+left+"   "+arr[left]+"   "+pivot);
                left++;
                System.out.println("left tail :   "+left+"   "+arr[left]+"   "+pivot);
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;//最后将基准填入移完的空内
        return left;
    }
}
