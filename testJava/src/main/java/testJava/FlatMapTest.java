package testJava;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapTest {
		/*
		 * FlatMap
		 * FlatMap ���ڽ�������ϲ�Ϊһ������ʹ�� FlatMap ʱ�����ʽ�ķ���ֵ������ Stream ���͡��� Map ���ڽ�һ����ת��Ϊ����һ������
		 */
	
		public static void mian(String args[]) {
			Stream<String> stringStream1 = Stream.of("shi yan", "shi yan lou","lou yan shi");
			Stream<String> stringStream2 = Stream.of("shi yan", "shi yan lou","lou yan shi");
			Stream<String[]> mapStream = stringStream1.map(v -> v.split(" "));
			Stream<String> flatMapStream =stringStream2.flatMap(v -> Arrays.stream(v.split(" ")));
			System.out.println("mapStream��ӡ��");
			//map��һ�����͵��� ת��Ϊ����һ�����͵���   ����ת��Ϊ��string[] ��
			//�Ⲣ����������Ҫ�ģ�������Ҫ����stream<String>,������Stream<String[]>
			mapStream.peek(System.out::println).count();
			System.out.println("flatMapStream��ӡ��");
//			Arrays.stream������ת���̳����� ���ｫ�ָ���String[],ת������Stream<String>����������ǰ�涨���������ַ���
//			�������ｫ��������Stream<String>��flatMap���ڽ��������ϲ���һ����
			flatMapStream.peek(System.out::println).count();
			
		}
}
