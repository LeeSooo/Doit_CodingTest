package chap03_DataStructure;

/* 002번 문제 : 새로운 평균(성적 / 최고점수 * 100) 을 구해서 출력하시오.
 * 
 * 입력 : 1번째 줄(시험을 본 과목의 개수 n), 2번째 줄(모든과목의 성적)
 * 출력 : 새로운 평균(성적 / 최고점수 * 100)을 출력.(실제 정답과 출력값의 절대 오차 또는 상대 오차가 0.01 이하이면 정답.)
 */

/* <슈도코드>
 *  (1) 1번째 줄 - 시험을 본 과목의 개수 n을 입력받기.
 *  (2) 2번째 줄 - 시험 성적을 순서대로 입력받기.
 *  (3)	최고점수와 총 시험성적을 구하기.
 *  (4) 새로운 평균을 구하여 출력하기.
 */

import java.util.Scanner;

public class Q002_P1546 {
	public static void main(String[] args) {
		// (1) 1번째 줄 - 시험을 본 과목의 개수 n을 입력받기.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// (2) 2번째 줄 - 시험 성적을 순서대로 입력받기.
		// (3) 최고점수와 총 합계 구하기.
		int[] arr = new int[n];
		
		// ** 자료형 범위 오류를 방지하기 위해서 long형 선언 **
		long sum = 0;
		long max = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			
			// 최고 점수 구하기.
			if (max < arr[i])
				max = arr[i];
			
			// 합계 구하기.
			sum += arr[i];
		}
		sc.close();
		
		// (4) 새로운 평균을 구하여 출력하기. (100.0 => 출력결과가 소수로 나오게 하기 위함.)
		System.out.println(sum * 100.0 / max / n);
	}
}
