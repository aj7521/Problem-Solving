class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int transaction: bills){
            if (transaction == 5) fives++;
            else if (transaction == 10){
                if (fives >= 1){
                    fives--;
                    tens++;
                }
                else return false;
            }
            else if (transaction == 20){
                if (fives >= 1 && tens >= 1){
                    fives--;
                    tens--;
                }
                else if (fives >= 3) fives -= 3;
                else return false;
            }
        }
        return true;
    }
}