package testJava;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String args[]) {
		System.out.println("Using Java 8: ");
		
		//ͳ�ƿ��ַ���������
		List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
		System.out.println("List: " + strings);
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("strings isempty count��" + count);
		
		//ͳ���ַ������ȴ���3���ַ���
		count = strings.stream().filter(string -> string.length() > 3).count();
		System.out.println("strings length > 3: " + count);
		
		//������ַ�����ͬʱʹ�ö�������
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("mergedString is: " + mergedString);
		
		//��ò�ͬ���ֵ�ƽ�����б�
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		IntSummaryStatistics stat = integers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("integers: " + integers);
		System.out.println("Highest number in List : " + stat.getMax());
		System.out.println("Lowest number in List : " + stat.getMin());
		System.out.println("Sum of all numbers : " + stat.getSum());
		System.out.println("Average of all numbers : " + stat.getAverage());
		
		//���10�������
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);
		
		//���д���
		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("empty string: " + count);
	}
}
