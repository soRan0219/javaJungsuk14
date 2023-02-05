package ch14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_5 {

	public static void main(String[] args) {
//		List<Integer> list = Arrays.asList(1,2,3,4,5);
//		Stream<Integer> intStream = list.stream(); //list를 Stream으로 변환
//		intStream.forEach(System.out::print); //forEach()는 최종연산
//		
//		//stream은 1회용. stream에 대해 최종연산을 하면 stream이 닫힘
//		intStream = list.stream(); //list로부터 Stream을 생성
//		intStream.forEach(System.out::print);
		
		String[] strArr = {"a", "b", "c"};
//		Stream<String> strStream = Stream.of(strArr);
		Stream<String> strStream = Arrays.stream(strArr);
		strStream.forEach(System.out::println);
		
		int[] intArr = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArr); //기본형 stream
//		intStream.forEach(System.out::println);
//		System.out.println("count = " + intStream.count()); //최종연산
//		System.out.println("sum = " + intStream.sum());
		System.out.println("average = " + intStream.average());
		
//		Integer[] intArr = {1,2,3,4,5}; //오토박싱
//		Stream<Integer> intStream = Arrays.stream(intArr); //객체stream
//		intStream.forEach(System.out::println);
//		System.out.println("count = " + intStream.count());
		
		
	}

}
