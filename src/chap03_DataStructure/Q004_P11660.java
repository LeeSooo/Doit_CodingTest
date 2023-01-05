package chap03_DataStructure;

/* 004번 문제 : n * n개의 수가 n * n 크기의 표에 채워져 있다. 표 안의 수 중(x1, y1)에서 (x2, y2)까지의 합을 구하기.
 * - d[x][y] = 원본 배열의 (0, 0)부터 (x, y)까지의 사각형 영역 안에 있는 수의 합
 * 
 *   조건 : 1 <= n <= 1024, 1 <= M <= 100000
 * 			=> "100000번" = 구간마다 합을 매번 계산하면 시간 안에 계산을 못 끝냄. => 구간 합 배열을 이용해야 함.(중요) 
 * 
 * <입력>
 *  (1) 1번째 입력 - 제공되는 숫자의 개수 n, 구간 합을 구해야 하는 줄의 개수 m 입력받기
 *  (2) 2번째 입력 - 질문의 개수 m을 입력받기
 *  (3) 3번째 입력 - n * n 표 안에 채워질 수를 입력받기
 *  (4) 4번째 입력 - 구간합 배열 자리 입력받기(x1, x2, y1, y2)
 * 
 * <출력>
 * - 표에서 (x1, y1)에서 (x2, y2)까지의 합을 출력.
 */

/* <슈도코드>
 *  (1) 1번째 입력받기 - (n : 표의 크기, m : 질문의 개수)
 *  (2) 2번째 입력 - (n * n)표 안에 수를 채워넣는다.
 *  (3) 구간 합 배열을 만든다.
 *  (4) 4번째 입력 - 질문에 대한 입력(구간합 배열 자리 입력받기(x1, x2, y1, y2))을 받고 출력하기.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q004_P11660 {
	public static void main(String[] args) throws IOException{
		
		// (1) 1번째 줄 입력받기 - (n : 표의 크기, m : 질문의 개수)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 표의 크기(행, 열)
		int m = Integer.parseInt(st.nextToken());	// 구해야 하는 질문의 개수
		
		// (2) 2번째 입력 - (n * n)표 안에 수를 채워넣는다.
		int[][] a = new int[n+1][n+1];	
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// (3) 구간 합 배열을 만든다.
		int d[][] = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				// 구간 합 구하기
				d[i][j] = d[i][j-1] + d[i-1][j] - d[i-1][j-1] + a[i][j];
			}
		}
		
		// (4) 4번째 입력 - 질문에 대한 입력(구간합 배열 자리 입력받기(x1, x2, y1, y2))을 받고 출력하기.
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(br.readLine());
			int x2 = Integer.parseInt(br.readLine());
			int y1 = Integer.parseInt(br.readLine());
			int y2 = Integer.parseInt(br.readLine());
			
			// 구간 합 배열로 질의에 답변하기
			int result = d[x2][y2] - d[x1 - 1][y2] - d[x2][y1 - 1] + d[x1 - 1][y1 - 1];
			System.out.println(result);
		}
	}
}
