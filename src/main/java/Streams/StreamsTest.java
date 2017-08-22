package Streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: kexin
 * @Version: V7.0
 * @Description:
 * @Date: 2017/8/22.
 */

/**
 * 流接口(Streams)
 */
public class StreamsTest {
    static List<String> stringCollection = new ArrayList<>();

    static {
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }
    //java8的Collections类已经被扩展
    // 可以简单的调用Collection.stream()或者Collection.parallelSteam()来创建流

    /**
     * Filter接受一个predicate来过滤流中所有的元素。操作时连续，可以让我们在结果上调用另外一个流操作
     */
    //先过滤、再排序
    @Test
    public void Filter() {
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        //结果 aaa2   aaa1
    }

    //  先排序，再过滤，再遍历
    @Test
    public void Sorted() {
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::print);
    }

    /**
     * map方法
     * 连续性操作map通过指定的方法将流中的每个元素转换
     */
    //先转换为大写，再排序,再遍历
    @Test
    public void Map() {
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::print);
    }

    /**
     * 各种匹配操作检测是否和流中元素相匹配
     * 中断该操作
     */
    @Test
    public void Match() {
        boolean anyStartWithA =
                stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartWithA);
        boolean allstartWithA =
                stringCollection.stream().allMatch((s) -> s.startsWith("a"));
        System.out.println(allstartWithA);
        boolean nonestartWithA =
                stringCollection.stream().noneMatch((s) -> s.startsWith("a"));
        System.out.println(nonestartWithA);
    }

    /**
     * Count统计数量方法.中断流操作
     */
    @Test
    public void Count(){
    long startWithB=stringCollection.stream().filter((s)->s.startsWith("b"))
            .count();
        System.out.println(startWithB);
    }
    /**
     *optional  可以返回为NULL，避免空指针错误
     */
    @Test
    public void Reduce(){
        Optional<String> optional=
                stringCollection.stream()
                .sorted().reduce((s1,s2)->(s1+"#"+s2));

        optional.ifPresent(System.out::print);
    }
}
