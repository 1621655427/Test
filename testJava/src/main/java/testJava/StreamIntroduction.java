package testJava;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class StreamIntroduction {
	 /*
	  * 
	  * Stream流介绍
	  * 
	  * Stream 的一些特性：
	  *  元素序列：Stream 以序列的形式提供了特定类型的元素的集合。根据需求，它可以获得和计算元素，但不会储存任何元素。
	 	源：Stream 可以将集合、数组和 I/O 资源作为输入源。
	 	聚集操作：Stream 支持诸如filter、map、limit、reduce等的聚集操作。
	 	流水技术：许多 Stream 操作返回了流本身，故它们的返回值可以以流水的行式存在。这些操作称之为中间操作，并且它们的功能就是负责输入、处理和向目标输出。
	 			  collect()方法是一个终结操作，通常存在于流水线操作的末端，来标记流的结束。
	 	自动迭代：Stream 的操作可以基于已提供的源元素进行内部的迭代，而集合则需要显式的迭代。 
	  */
		public static void main(String args[]) {
			/*
			 * 集合的接口有两个方法来产生流：
			 * stream()：该方法返回一个将集合视为源的连续流。
			 * parallelStream()：该方法返回一个将集合视为源的并行流。
			 */
			
			/*
			 * 其他相关方法：
			 * 
			 * 1、forEach：该方法用于对 Stream 中的每个元素进行迭代操作。
			 * 下面的代码段演示了如何使用 forEach 方法输出 10 个随机数。
			 */
			Random random = new Random();
			random.ints().limit(10).forEach(System.out::println);
			
			/*
			 * 2、map：该方法用于将每个元素映射到对应的结果上。
			 * 下面的代码段演示了怎样用 map 方法输出唯一的某个数的平方。
			 */
			
			List<Integer> numbers = Arrays.asList(2,3,3,2,5,2,7);
			List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
			System.out.println("squaresList is " + squaresList);
			
			/*
			 * 3、filter：该方法用于过滤满足条件的元素。下面的代码段演示了怎样输出使用了过滤方法的空字符串数量。
			 */
			
			List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
			Long count = strings.stream().filter(string -> string.isEmpty()).count();
			System.out.print("filter count: " + count);
			
			/*
			 * 4、limit：该方法用于减少 Stream 的大小。下面的代码段演示了怎样有限制地输出 10 个随机数。
			 */
			
			Random random1 = new Random();
			random1.ints().limit(10).forEach(System.out::println);
			
			/*
			 * sorted：该方法用于对 Stream 排序。下面的代码段演示了怎样以有序的形式输出 10 个随机数。
			 */
			
			Random random2 = new Random();
			random2.ints().limit(10).sorted().forEach(System.out::println);
			
			/*
			 * 并行处理
			 * ParallelStream 是 Stream 用于并行处理的一种替代方案。下面的代码段演示了如何使用它来输出空字符串的数量。
			 */
			
			List<String> strings1 = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
			//获得空字符串的计数
			long count1 = strings1.parallelStream().filter(String::isEmpty).count();
			System.out.println("ParallelStream count1: " + count1);
			
			/*
			 * Collector
			 * Collector 用于合并 Stream 的元素处理结果。它可以用于返回一个字符串列表。
			 */
			
			List<String> strings2 = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
			List<String> filtered = strings2.stream().filter(string -> !strings.isEmpty()).collect(Collectors.toList());
			System.out.println("Filtered List: "+filtered);
			String mergedString = strings2.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
			System.out.println("Merged String: " + mergedString);
			System.out.println();
			
			/*
			 * 统计工具
			 * Stream 处理完成后使用 Collector 来统计数据。
			 */
			
			List<Integer> numbers1 = Arrays.asList(2, 3, 3, 2, 5, 2, 7);
			IntSummaryStatistics stats = numbers1.stream().mapToInt((x) -> x).summaryStatistics();
			System.out.println("Highest number in List : " + stats.getMax());
			System.out.println("Lowest number in List : " + stats.getMin());
			System.out.println("Sum of all numbers : " + stats.getSum());
			System.out.println("Average of all numbers : " + stats.getAverage());
		}
}
