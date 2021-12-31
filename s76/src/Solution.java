public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int count = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count += i + num / i;
            }
        }
        return num == count;
    }
}

//class Solution {
//    public boolean checkPerfectNumber(int num) {
//        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
//    }
//}
