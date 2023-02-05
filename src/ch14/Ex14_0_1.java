package ch14;

import java.util.function.Function;
import java.util.function.Supplier;

public class Ex14_0_1 {

	public static void main(String[] args) {
//		Function<String, Integer> ff = (String s) -> Integer.parseInt(s);
//		Function<String, Integer> ff = 클래스이름::메서드이름;
		Function<String, Integer> ff = Integer::parseInt; //메서드 참조
		System.out.println(ff.apply("100")+200);
		
		//메서드 참조 -> 람다식 연습 해보기
		
		//Supplier는 입력x, 출력o
//		Supplier<MyClass> s = () -> new MyClass();
//		Supplier<MyClass> s = MyClass::new;
		
		Function<Integer, MyClass> f = (i) -> new MyClass(i);
//		Function<Integer, MyClass> f = MyClass::new;
		
		System.out.println(f.apply(100).iv);
		MyClass mc = f.apply(100);
		System.out.println(mc.iv);
		
//		Function<Integer, int[]> f2 = (i) -> new int[i];
		Function<Integer, int[]> f2 = int[]::new;  //메서드 참조
		
		System.out.println(f2.apply(100).length);
		int[] arr = f2.apply(100);
		System.out.println(arr.length);
	} //main
}

class MyClass {
	int iv;
	
	MyClass(int iv) {
		this.iv = iv;
	}
}