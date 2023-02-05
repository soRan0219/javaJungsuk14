package ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2_2 {
	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random()*100)+1; //(람다식으로) 1~100 난수
		Function<Integer, Integer> f = i -> i/10*10; //(람다) i의 1의 자리를 없앰
		
		List<Integer> list = new ArrayList<Integer>(); //list 생성
		makeRandomList3(list, s); //list를 랜덤값으로 채움
		System.out.println("list: " + list);
		List<Integer> newList = doSomething3(f, list); //list입력받아 newList 생성
		                                         //newList에 list 값의 1의 자리 제거
		System.out.println("newList: " + newList);
		System.out.println();
		
		List<Integer> list2 = new ArrayList<>();
		makeRandomList3(list2, s);
		System.out.println("list2: " + list2);
		List<Integer> newList2 = new ArrayList<>(list2);
		System.out.println("newList2: " + doSomething3(f, newList2));
	} //main
	
	//list 생성하고 Function 적용한 값 채워넣은 뒤 반환
	static <T> List<T> doSomething3(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());
		for(T t:list) {
			newList.add(f.apply(t));
		} //for
		return newList;
	} //doSomething
	
	//Supplier에서 반환하는 값 길이 10짜리 list에 넣음
	static <T> void makeRandomList3(List<T> list, Supplier<T> s) {
		for(int i=0; i<10; i++) {
			list.add(s.get());
		}
	} //makeRandomList
}

