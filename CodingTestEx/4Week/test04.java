// Improvements
class Solution {
    public int solution (int delay, int capacity, int[] times) {
        int currentTime = 0;
        int currentQueue = 0;
        int result = 0; // 소실 갯수
        for (int time: times) {
            currentTime += time; // 자료가 들어오는 시간
            int sent = currentTime / delay; // 보낼 수 있는 메세지 갯수
            currentQueue = Math.max(0, currentQueue - sent);
            if (currentQueue == capacity) {
                result++;
            } else {
                currentQueue++;
            }
            currentTime %= delay;
        }
        return result;
    }
}
