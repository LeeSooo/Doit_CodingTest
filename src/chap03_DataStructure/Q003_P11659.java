package chap03_DataStructure;

/* 003번 문제 : 수 N개가 주어졌을 때, i번째 수 에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.
 * 
 * <입력>
 * - 1번째 줄(제공되는 숫자의 개수 n)(구간 합을 구해야 하는 줄의 개수 m)
 * 		조건 : 1 <= n <= 100000, 1 <= m <= 100000		(코딩테스트는 항상 "최악의 경우"를 생각하고 풀기!)
 * 		=> 100000의 개수는 모든 구간을 계산할 시간이 없다. => "구간 합" 사용
 * 
 * - 2번째 줄(제공되는 숫자), 그 이후(구간 합을 구할 자리수 2개)
 * 
 * <출력>
 * - 1번째 줄(합계), 그 이후(구간 합)
 */

/* <슈도코드>
 *  (1) 1번째 줄 - 제공되는 숫자의 개수 n, 구간 합을 구해야 하는 줄의 개수 m 입력받기
 *  (2) 2번째 줄 - 합배열 구하기. (s[i] = s[i-1] + a[i])
 *  (3) 그 이후 줄 - 구간합 구하고 출력하기. (s[j] - s[i]) 구간합 최대 자리 수 - 구간합 최소 자리 수
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q003_P11659 {
	public static void main(String[] args) throws IOException {
		// (1) 1번째 줄 - 제공되는 숫자의 개수 n, 구간 합을 구해야 하는 줄의 개수 m 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// (2) 2번째 줄 - 합배열 구하기. (출력 X)
		long[] s = new long[n+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < s.length; i++) {	// (i의 조건 조심하기!)
			s[i] = s[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// (3) 그 이후 줄 - 구간합 구하고 출력하기.
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			System.out.println(s[max] - s[min-1]);
		}
	}
}
