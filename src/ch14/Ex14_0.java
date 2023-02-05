package ch14;

public class Ex14_0 {

	public static void main(String[] args) {
//		Object obj = (a, b) -> a>b ? a : b //람다식. 익명객체
		Object obj = new Object() {
			int max(int a, int b) {
				return a>b ? a : b;
			}
		}; //Object
		
//		int value = obj.max(3, 5); //참조변수 타입(Object)에 없는 메소드!
								   // 함수형 인터페이스 필요
		
		MyFunction f = new MyFunction() {
			public int max(int a, int b) { //오버라이딩 - 접근제어자 좁게 못바꿈
				return a>b ? a : b;
			}
		}; //MyFunction
		
		int value = f.max(3, 5);
		System.out.println(value);
		
		//람다식(익명 객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 함
		MyFunction f2 = (a, b) -> a>b ? a : b;
		
		int i = f2.max(3, 5); //함수형 인터페이스
		System.out.println("value = " + i);
		
	} //main

}

@FunctionalInterface  //함수형 인터페이스는 단 하나의 추상메서드만 가짐
interface MyFunction {
	public abstract int max(int a, int b);
//  int max(int a, int b);  public abstract 생략 가능 - 함수형 인터페이스라는 애너테이션 넣어줬으니까..	
}
