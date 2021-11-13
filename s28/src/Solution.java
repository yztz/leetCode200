public class Solution {
    /*
        一共五个状态（代码中隐含最后一个）:初始(0), 首字母大写(1), 全体大写(2), 全体小写(3), 错误(4)
     */
    public boolean detectCapitalUse(String word) {
        int state = 0;
        for (char c : word.toCharArray()) {
            boolean U = Character.isUpperCase(c);
            switch (state){
                case 0: state = U ? 1 : 3;break;
                case 1: state = U ? 2 : 3;break;
                case 2: if (!U) return false;break;
                case 3: if (U) return false;break;
            }
        }
        return true;
    }
}
