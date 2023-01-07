package chap03_DataStructure;

/* 005번 문제 : 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 * (시간 제한 1초)
 * 
 *<슈도코드>
 *  <입력>
 *  (1) 1번째 입력 - 제공되는 숫자의 개수 N, 연속된 부분의 합이 m으로 나누어 떨어지는 구간의 개수 M 입력받기
 *  (2) 2번째 입력 - N개의 숫자 입력받기 => 합 배열 S 생성하기
 *  
 *  <분석 계산>
 * 	(1) (S[j] − S[i−1]) % M 			// 합 배열 S의 모든 값을 M으로 나머지 연산을 수행한다.
 * 	(2) (S[j] % M) − (S[i−1] % M) = 0	// 여기서 S[i] % M == 0 인 수를 세어 결과 값에 더한다.
 * 	(3)  S[j] % M = S[i−1] % M			// 나머지 값이 같은 인덱스 중 2개를 뽑는 모든 경우의 수를 구한다.  
 * 
 *	<출력>
 *  (1) 출력 : 결과 값을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q005_P10986 {
	public static void main(String args[]) throws IOException {
        // 1. N(수의 개수), M(나누기 할 수) 입력받기.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수의 개수(입력)
        int M = Integer.parseInt(st.nextToken());   // 나누기 할 수(입력)
        
        long[] S = new long[N + 1];                 // 합배열 (처리)
        long[] C = new long[M];                   	// 같은 나머지의 인덱스를 카운트하는 배열 (처리)
        
        long answer = 0;                            // M으로 나누어떨어지는 (i,j) 쌍의 개수(출력)

        // 2. N개의 수 입력받으면서 누적합을 M으로 나눈 나머지를 배열 S에 저장한다.
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
            // 0~i까지의 합을 M으로 나눈 나머지가 0인 경우의 수 카운팅
            if(S[i] == 0) {
                answer++;
            }
            // 나머지가 같은 인덱스의 수 카운팅
            C[(int) S[i]]++;
        }

        // 3. S[j] % M == S[i-1] % M 을 만족하는 (i,j)의 수를 결과값에 더한다.
        // 즉, cnt[i](i가 나머지인 인덱스의 수)에서 2가지를 뽑는 경우의 수 카운팅한다.
        for(int i=0; i<M; i++) {
            if(C[i] > 1) {
                answer += (C[i]* (C[i]-1) / 2);
            }
        }
        System.out.println(answer);
    }
}