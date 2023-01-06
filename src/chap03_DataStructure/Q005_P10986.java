package chap03_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q005_P10986 {
	public static void main(String args[]) throws IOException {
        // 1. N(수의 개수), M(나누기 할 수) 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2. N개의 수 입력받으면서 누적합 배열 S 생성하기
        st = new StringTokenizer(br.readLine());
        int[] s = new int[n+1];
        for(int i=1; i<n+1; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }

        // 3. 구간 합(S[j]-S[i-1])를 M으로 나누었을 때 나머지가 0이 되는 (i,j) 쌍의 개수 계산
        int cnt = 0;
        for(int i=1; i<n+1; i++) {
            for(int j=i; j<n+1; j++) {
                if((s[j] - s[i-1]) % m == 0) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}