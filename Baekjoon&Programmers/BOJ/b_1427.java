package BOJ;

/*
[MY TIL]
1. Collections.sort(list, Collections.reverseOrder));
   2번째 파라미터로 내림차순 정렬을 나타내는 Comparator 전달해서, ArrayList 내림차순 정렬하기
 */

import java.io.*;
import java.util.*;

public class b_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n.length(); i++) {
            list.add(Integer.valueOf(n.substring(i,i+1)));
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < n.length(); i++) {
            bw.write(list.get(i).toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
