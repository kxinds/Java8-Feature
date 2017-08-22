package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @Author: kexin
 * @Version: V7.0
 * @Description:
 * @Date: 2017/8/22.
 */
public class Lambda {
    public static void main(String[] args) {
        //1.匿名内部类方法重写
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }).start();
        //使用lambda表达式
        new Thread(()->System.out.println("Hello World")).start();
        String []datas = new String[] {"peng","zha","li"};
        // 2. 使用匿名内部类根据 name 排序 players
        Arrays.sort(datas, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        //lambda表达式   重写compare方法
        Arrays.sort(datas,(v1 , v2) -> Integer.compare(v1.length(), v2.length()));
        //lambda表达式Stream 进行遍历
        Stream.of(datas).forEach(param -> System.out.println(param));



    }
}
