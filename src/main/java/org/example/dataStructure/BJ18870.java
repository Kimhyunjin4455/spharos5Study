package org.example.dataStructure;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] inputArr = new int[N];
        int[] sortedArr = new int[N];

        HashMap<Integer, Integer> rankMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++){
            inputArr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedArr);

        int rank = 0;
        for (int i=0; i<N; i++){
            if(!rankMap.containsKey(sortedArr[i])) {
                rankMap.put(sortedArr[i], rank);
                rank++;
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int key: inputArr){
            //sb.append(rankMap.get(key) + " ");
            sb.append(rankMap.get(key)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

//        System.out.println(sb);

    }
}
