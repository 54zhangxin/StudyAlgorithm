package Practice;

import java.beans.PropertyVetoException;
import java.util.HashSet;

public class dsdd<T> {
    private  T data;
    public  dsdd(T t){}

    public  T getData(){

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        return  data;
    }


    public static void main(String[] args) {

//        for (int i = 0; i<2; i++){
//            System.out.println(i);
//        }
//        System.out.println("---------------");
//        for (int i = 0; i<2; ++i){
//            System.out.println(i);
//        }
        
        
        
        int[] nums = new int[]{1,2,54,4,254,12,674,1};
        HashSet<Integer> set = new HashSet();

        for (int num : nums) {
            set.add(num);
        }

        for (Integer i : set) {
            System.out.println(i);
        }
    }



}
