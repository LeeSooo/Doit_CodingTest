package chap01;

/* < 시간 복잡도 정의 >
 * 빅-오메가 : 최선일 때의 연산 횟수를 나타낸 표기법
 * 빅-세타 : 보통일 때의 연산 횟수를 나타낸 표기법
 * 빅-오 : 최악일 때의 연산 횟수를 나타낸 표기법 
 */

/* < 시간 복잡도 예제 코드 >
 * 빅-오메가 표기법 : 1번
 * 빅-세타 표기법 : 2/N번
 * 빅-오 표기법 : N번
 * */

// 코딩테스트는 "빅-오 표기법"을 기준으로 수행시간을 계산하는 것이 좋다.

public class Ex01_TimeComplexityExample1 {
	public static void main(String[] args) {
		// 1~100 사이의 램덤 선택
		int findNumber = (int)(Math.random() * 100);
        
		for (int i = 0; i < 100; i++) {
            if (i == findNumber) {
                System.out.println(i);
                break;
            }
        }
    }
}