package ch14;

import java.util.stream.Stream;

public class Ex14_6 {

	public static void main(String[] args) {
//		IntStream intStream = new Random().ints(); //무한스트림
//		IntStream intStream = new Random().ints(10, 5, 10); //개수, 범위 지정 가능
//		
//		intStream
//		.limit(10) //10개만 자르기
//		.forEach(System.out::println);
		
		//Iterator(T seed, UnaryOperator f) 단항 연산자
		Stream<Integer> intStream = Stream.iterate(1, n -> n+2);
		intStream.limit(10).forEach(System.out::println);
		
		//generate(Supplier s): 주기만 함. 입력x, 출력o
		Stream<Integer> oneStream = Stream.generate(() -> 1);
		oneStream.limit(10).forEach(System.out::println);
		
		Stream emptyStream = Stream.empty();
		long count = emptyStream.count();
		System.out.println("count: " + count);
	}

}
