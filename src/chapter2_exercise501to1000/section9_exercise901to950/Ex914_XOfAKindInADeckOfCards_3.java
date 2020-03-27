package chapter2_exercise501to1000.section9_exercise901to950;

import java.util.HashMap;
import java.util.Map;

/*给定一副牌，每张牌上都写着一个整数。
        此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
        每组都有 X 张牌。
        组内所有的牌上都写着相同的整数。
        仅当你可选的 X >= 2 时返回 true*/

public class Ex914_XOfAKindInADeckOfCards_3 {
    //先计算每种不同数字卡牌各有多少张。如果要实现分组，则不同数字的卡牌张数之间必须有一个大于1的最大公约数
    //测试用例时间打败88.88%
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck==null||deck.length<2)return false;
        int[] count = new int[10000];
        for (int i=0;i<deck.length;i++)count[deck[i]]++;
        int g = -1;
        for (int i = 0; i < 10000; ++i){
            if (count[i] > 0) {
                if (g == -1){
                    g = count[i];
                }else{
                    g = gcdWork(g, count[i]);
                }
            }
        }
        if(g>1)return true;
        return false;
    }
    //欧几里得GCD算法 x和y顺序不限，递归过程中会自动修正为x大y小
    public int gcdWork(int x,int y){
        if(x%y==0)return y;
        return gcdWork(y,x%y);
    }
}
