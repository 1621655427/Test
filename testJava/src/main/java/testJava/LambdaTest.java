package testJava;

import java.util.Arrays;

public class LambdaTest {
		/*
		 * lambada��ϰ
		 *  ����һ������1, 23, 4, 4, 22, 34, 45, 11, 33
			ʹ�� lambda ��������е���С��
			������ȥ�أ�����ȥ�غ������ÿ��Ԫ�س��� 2����������� 2 �������ĺͣ���������1,2,3,3��ȥ�غ�Ϊ1,2,3������ 2 ��Ϊ2,4,6�����ĺ�Ϊ12��
		 */
		public static void main(String args[]) {
			int arr[] = {1, 23, 4, 4, 22, 34, 45, 11, 33};
			System.out.println("��С����"+Arrays.stream(arr).min());
			System.out.println("����ȥ�س�2��ͣ�" + Arrays.stream(arr).distinct().map((i) -> i * 2).sum());
			
		}
}
