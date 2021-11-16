package 代码随想录.贪心;

/**
 * 860. 柠檬水找零
 */
public class LeetCode860 {

    public static void main(String[] args) {
        System.out.println(new LeetCode860().lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }

    public boolean lemonadeChange(int[] bills) {

        int numOfChange5 = 0;
        int numOfChange10 = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5:
                    numOfChange5++;
                    break;
                case 10:
                    if(numOfChange5 >= 1){
                        numOfChange5--;
                        numOfChange10++;
                    }else{
                        return false;
                    }
                    break;
                case 20:
                    if(numOfChange10 >= 1 && numOfChange5 >= 1){
                        numOfChange10--;
                        numOfChange5--;
                    }else if(numOfChange5 >= 3){
                        numOfChange5 -= 3;
                    }else{
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
