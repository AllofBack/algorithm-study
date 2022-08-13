// My Code
class Solution {
    public long solution(int[] arr) {
        long answer = -1;
        long left = 0;
        long right = arr.length - 1;

        while ( left <= right ) {
            long mid = (left + right) / 2;

            if ( left == arr.length - 1) {
                left = -1;
                break;
            }
            if( arr[(int)mid] < arr[(int)mid + 1]){
                left = mid + 1;
            } else { right = mid - 1;}
        }
        answer = left;
        return answer;
    }
}

// Improvements - 이분탐색
class Solution {
    public int solution(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left + 1 < right) { //
            int mid = left + (right - left) / 2; // 빼서 더한걸 2로 나눠주어야 오버플로우 방지 가능!!

            if (arr[mid + 1] < arr[mid]) {
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    right = mid;
                }
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
