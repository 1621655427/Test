package testJava;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class PredicateDemo {
	/*
	 * Predicate �� Java �ṩ��һ������ʽ�ӿڣ�������һ������ t����ִ�ж��Բ�������һ�� boolean���ӿ���������:
	 * @FunctionalInterface
		public interface Predicate<T> {
	   		boolean test(T t);
		}
	 */
	public static void main(String args[]) {
		//��ʹ�ã��ж�a�Ƿ����5
		Predicate<Integer> predicate = a -> a > 50;
		System.out.println(predicate.test(52));
		//���ֻ����int���ͣ�����ֱ��ʹ��Intpredicate
		IntPredicate intPredicate = a -> a > 50;
		IntStream.of(10,11,44,59,46,55,99,88,50).filter(intPredicate).peek(System.out::println).count();
	}
}
