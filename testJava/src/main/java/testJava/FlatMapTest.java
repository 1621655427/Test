package testJava;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapTest {
		/*
		 * FlatMap
		 * FlatMap 用于将多个流合并为一个流，使用 FlatMap 时，表达式的返回值必须是 Stream 类型。而 Map 用于将一种流转化为另外一个流。
		 */
	
		public static void mian(String args[]) {
			Stream<String> stringStream1 = Stream.of("shi yan", "shi yan lou","lou yan shi");
			Stream<String> stringStream2 = Stream.of("shi yan", "shi yan lou","lou yan shi");
			Stream<String[]> mapStream = stringStream1.map(v -> v.split(" "));
			Stream<String> flatMapStream =stringStream2.flatMap(v -> Arrays.stream(v.split(" ")));
			System.out.println("mapStream打印：");
			//map将一种类型的流 转换为另外一个类型的流   这里转换为了string[] 流
			//这并不是我们想要的，我们想要的是stream<String>,而不是Stream<String[]>
			mapStream.peek(System.out::println).count();
			System.out.println("flatMapStream打印：");
//			Arrays.stream将数组转换程成了流 这里将分割后的String[],转换成了Stream<String>，但是我们前面定义了三个字符串
//			所以这里将产生三个Stream<String>，flatMap用于将三个流合并成一个流
			flatMapStream.peek(System.out::println).count();
			
		}
}
