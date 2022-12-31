package chap03_DataStructure;

/* 001번 문제 : 입력한 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
 * 시간 제한 : 1초
 * 입력 : 1번째 줄(숫자의 개수)[1 ~ 100], 2번째 줄(숫자n개가 공백 없이 주어진다.)
 * 출력 : 입력으로 주어진 숫자 n개의 합을 출력한다.
 */

/* <슈도코드>
 *  (1) 1번째 줄 - 숫자의 개수 입력받기.
 *  (2) 2번째 줄 - 숫자 n개를 공백 없이 입력받기.
 *  (3) 문자열 -> 문자배열로 형 변환하기.
 *  (4) 출력해야 할 변수(합계) 선언하기.
 *  (5) n개의 숫자 더하기.
 *  (6) 결과 출력하기
 */

import java.util.Scanner;

public class Q001_P11720 {
	public static void main(String[] args) {
		// (1) 1번째 줄 - 숫자의 개수 입력받기.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// (2) 2번째 줄 - 숫자 n개를 공백 없이 입력받기.
		String sNum = sc.next();
		sc.close();
		
		// (3) 문자열 -> 문자배열로 형 변환하기.
		char[] cNum = sNum.toCharArray();
		
		// (4) 출력해야 할 변수(합계) 선언하기.
		int sum = 0;
		
		// (5) n개의 숫자 더하기.
		for(int i = 0; i < n; i++) {
			sum += cNum[i] - '0';	// 문자 배열 -> 정수형으로 변환하는 방법.
		}
		
		// (6) 결과 출력하기
		System.out.print(sum);
	}
}
