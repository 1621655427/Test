package testJava;

import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;

/*
 * 函数式接口编程
 * java.util.function
 * 2019-12-28
 */

public class FunctionTest {
	public static void main(String args[]){
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        System.out.println("All of the numbers：");
        eval(list,n->true);
        System.out.println("Even numbers:");
        eval(list, n-> n%2 == 0);
        System.out.println("Number that greater than 5:");
        eval(list, n -> n >5);
    }
	/*
	 * Predicate 是 Java 提供的一个函数式接口，他接受一个参数 t，并执行断言操作返回一个 boolean。接口内容如下:
	 * @FunctionalInterface
		public interface Predicate<T> {
	   		boolean test(T t);
		}
	 */
	
    public static void eval(List<Integer> list,Predicate<Integer> predicate){
        for(Integer n:list){
            if(predicate.test(n)){
                System.out.println(n);
            }
        }
    }
}
