public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int answer = numBottles;
        while (numBottles >= numExchange) {
            int newEhg = numBottles / numExchange;
            int rest = numBottles % numExchange;
            answer += newEhg;
            numBottles = newEhg + rest;
        }

        return answer;
    }
}
