class Solution {
    public long solution(int price, int money, int count) {
        long answer = (price * ((long)count * (count+1)) / 2) - money;
        return answer < 0 ? 0 : answer;
    }
}