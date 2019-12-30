package testJava;

import java.util.stream.Stream;

public class MergerStream {
	/*
	 * 1���½���������磺

		Stream<Integer> stream1 = Stream.of(1, 2, 3);	
		Stream<Integer> stream2 = Stream.of(4, 5, 6);
		Stream<Integer> stream3 = Stream.of(7, 8, 9);
		
		2��ʹ�� flatMap �ϲ������Ϊһ����
	 */
		public static void main(String args[]) {
			Stream<Integer> stream1 = Stream.of(1, 2, 3);
			Stream<Integer> stream2 = Stream.of(4,5,6);
			Stream<Integer> stream3 = Stream.of(7,8,9);
			Stream<Integer> mergerStream = Stream.of(stream1,stream2,stream3).flatMap((i) -> i);
			mergerStream.forEach(System.out::println);
		}
}
