/*
[MY TIL]
1. 중복 허용하지 않기 때문에 set으로 선언
2. Collection의 sort 내 Comperator 활용
3. compareTo 메소드 -> 각각의 문자열에서 가장 낮은 아스키코드의 차이값 리턴
4. 인텔리제이 버전 오류로 BufferedReader로 값을 읽어오는데 오류를 겪다가,,오류 없는 버전으로 재설치해서 해결했다.
*/

import java.io.*;
import java.util.*;

public class b_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List list = new ArrayList(set);
        Collections.sort(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        for (Object str : list) {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}