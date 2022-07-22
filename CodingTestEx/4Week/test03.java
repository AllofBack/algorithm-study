// Improvements
class Solution {
    int i = 0; // 멤버 변수로 초기화

    public String solution(String code) {
        return recursive(code); // 습관적으로 재귀는 밖에 따로 구현하기
    }

    public String recursive(String s)
    { // 재귀호출로 활용하기
        StringBuilder sb = new StringBuilder(); // 효율성 테스트
        String temp; // 반복 {} 발생 시, 내부값 구하기 위한 변수

        int num = 0; // 반복 숫자 초기화

        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) { // 숫자인지 확인
                num = Character.getNumericValue(s.charAt(i)); // 숫자로 값 가져오기
                i++;
            } else if(s.charAt(i)=='{') {
                i++;
                temp = recursive(s);
                sb.append(temp.repeat(num));
            } else if(s.charAt(i)=='}') {
                i++;
                break;
            }
            else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}