package testJava;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class PredicateDemo {
	/*
	 * Predicate 是 Java 提供的一个函数式接口，他接受一个参数 t，并执行断言操作返回一个 boolean。接口内容如下:
	 * @FunctionalInterface
		public interface Predicate<T> {
	   		boolean test(T t);
		}
	 */
	public static void main(String args[]) {
		//简单使用，判断a是否大于5
		Predicate<Integer> predicate = a -> a > 50;
		System.out.println(predicate.test(52));
		//如果只断言int类型，可以直接使用Intpredicate
		IntPredicate intPredicate = a -> a > 50;
		IntStream.of(10,11,44,59,46,55,99,88,50).filter(intPredicate).peek(System.out::println).count();
	}
}
