package problem;

import java.util.*;
import java.io.*;

public class SWEA_1206 {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] buildings = new int[n];
            boolean[] b =new boolean[n];

            int[] distance = { -2, -1, 1, 2};
            int result = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                buildings[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 2; j< n-2; j++) {
                int min = 256;
                if(!b[j]) {
                    for (int d : distance) {
                        int height = buildings[j] - buildings[j + d];
                        if(height < 0) {
                            min = -1;
                        } else {
                            b[j + d] = true;
                            if (height < min) {
                                min = height;
                            }
                        }
                    }
                    if(min > 0) {
                        result += min;
                    }
                }
            }

            System.out.println("#" + i + " " + result);
        }
    }
}