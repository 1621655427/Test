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
	  * Stream������
	  * 
	  * Stream ��һЩ���ԣ�
	  *  Ԫ�����У�Stream �����е���ʽ�ṩ���ض����͵�Ԫ�صļ��ϡ��������������Ի�úͼ���Ԫ�أ������ᴢ���κ�Ԫ�ء�
	 	Դ��Stream ���Խ����ϡ������ I/O ��Դ��Ϊ����Դ��
	 	�ۼ�������Stream ֧������filter��map��limit��reduce�ȵľۼ�������
	 	��ˮ��������� Stream ���������������������ǵķ���ֵ��������ˮ����ʽ���ڡ���Щ������֮Ϊ�м�������������ǵĹ��ܾ��Ǹ������롢�������Ŀ�������
	 			  collect()������һ���ս������ͨ����������ˮ�߲�����ĩ�ˣ���������Ľ�����
	 	�Զ�������Stream �Ĳ������Ի������ṩ��ԴԪ�ؽ����ڲ��ĵ���������������Ҫ��ʽ�ĵ����� 
	  */
		public static void main(String args[]) {
			/*
			 * ���ϵĽӿ���������������������
			 * stream()���÷�������һ����������ΪԴ����������
			 * parallelStream()���÷�������һ����������ΪԴ�Ĳ�������
			 */
			
			/*
			 * ������ط�����
			 * 
			 * 1��forEach���÷������ڶ� Stream �е�ÿ��Ԫ�ؽ��е���������
			 * ����Ĵ������ʾ�����ʹ�� forEach ������� 10 ���������
			 */
			Random random = new Random();
			random.ints().limit(10).forEach(System.out::println);
			
			/*
			 * 2��map���÷������ڽ�ÿ��Ԫ��ӳ�䵽��Ӧ�Ľ���ϡ�
			 * ����Ĵ������ʾ�������� map �������Ψһ��ĳ������ƽ����
			 */
			
			List<Integer> numbers = Arrays.asList(2,3,3,2,5,2,7);
			List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
			System.out.println("squaresList is " + squaresList);
			
			/*
			 * 3��filter���÷������ڹ�������������Ԫ�ء�����Ĵ������ʾ���������ʹ���˹��˷����Ŀ��ַ���������
			 */
			
			List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
			Long count = strings.stream().filter(string -> string.isEmpty()).count();
			System.out.print("filter count: " + count);
			
			/*
			 * 4��limit���÷������ڼ��� Stream �Ĵ�С������Ĵ������ʾ�����������Ƶ���� 10 ���������
			 */
			
			Random random1 = new Random();
			random1.ints().limit(10).forEach(System.out::println);
			
			/*
			 * sorted���÷������ڶ� Stream ��������Ĵ������ʾ���������������ʽ��� 10 ���������
			 */
			
			Random random2 = new Random();
			random2.ints().limit(10).sorted().forEach(System.out::println);
			
			/*
			 * ���д���
			 * ParallelStream �� Stream ���ڲ��д����һ���������������Ĵ������ʾ�����ʹ������������ַ�����������
			 */
			
			List<String> strings1 = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
			//��ÿ��ַ����ļ���
			long count1 = strings1.parallelStream().filter(String::isEmpty).count();
			System.out.println("ParallelStream count1: " + count1);
			
			/*
			 * Collector
			 * Collector ���ںϲ� Stream ��Ԫ�ش����������������ڷ���һ���ַ����б�
			 */
			
			List<String> strings2 = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
			List<String> filtered = strings2.stream().filter(string -> !strings.isEmpty()).collect(Collectors.toList());
			System.out.println("Filtered List: "+filtered);
			String mergedString = strings2.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
			System.out.println("Merged String: " + mergedString);
			System.out.println();
			
			/*
			 * ͳ�ƹ���
			 * Stream ������ɺ�ʹ�� Collector ��ͳ�����ݡ�
			 */
			
			List<Integer> numbers1 = Arrays.asList(2, 3, 3, 2, 5, 2, 7);
			IntSummaryStatistics stats = numbers1.stream().mapToInt((x) -> x).summaryStatistics();
			System.out.println("Highest number in List : " + stats.getMax());
			System.out.println("Lowest number in List : " + stats.getMin());
			System.out.println("Sum of all numbers : " + stats.getSum());
			System.out.println("Average of all numbers : " + stats.getAverage());
		}
}
