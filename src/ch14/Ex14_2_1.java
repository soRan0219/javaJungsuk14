package ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2_1 {
	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random()*100)+1; //(람다식으로) 1~100 난수
		Consumer<Integer> c = i -> System.out.print(i + ", "); //(람다식) i출력
		Predicate<Integer> p = i -> i%2==0; //(람다식) 짝수인지 검사
		Function<Integer, Integer> f = i -> i/10*10; //(람다) i의 1의 자리를 없앰
		
		List<Integer> list = new ArrayList<Integer>(); //list 생성
		makeRandomList2(list, s); //list를 랜덤값으로 채움
		System.out.println("list: " + list);
		printEvenNum2(list, c, p); //list에서 짝수 출력
		List<Integer> newList = doSomething2(f, list); //list입력받아 newList 생성
		                                         //newList에 list 값의 1의 자리 제거
		System.out.println("newList: " + newList);
	} //main
	
	//list 생성하고 Function 적용한 값 채워넣은 뒤 반환
	static <T> List<T> doSomething2(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());
		for(T t:list) {
			newList.add(f.apply(t));
		} //for
		return newList;
	} //doSomething
	
	//list값 하나씩 입력 받아 Predicate이 true를 반환하는 값 Consumer적용해 결과 출력
	static <T> void printEvenNum2(List<T> list, Consumer<T> c, Predicate<T> p) {
		System.out.print("[");
		for(T t:list) {
			if(p.test(t))
				c.accept(t);
		} //for
		System.out.println("]");
	} //printEvenNum
	
	//Supplier에서 반환하는 값 길이 10짜리 list에 넣음
	static <T> void makeRandomList2(List<T> list, Supplier<T> s) {
		for(int i=0; i<10; i++) {
			list.add(s.get());
		}
	} //makeRandomList
}

