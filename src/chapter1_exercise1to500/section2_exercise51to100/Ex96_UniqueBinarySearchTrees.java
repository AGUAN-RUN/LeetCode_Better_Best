package chapter1_exercise1to500.section2_exercise51to100;
/*Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
*/
public class Ex96_UniqueBinarySearchTrees {
    //未优化，下一轮优化将把已计算的n,numTrees(int n)保存在map中，如果map中能直接取到对于输入n，函数的值，将直接在map中取值
    //测试用例时间3702 ms 在所有 Java 提交中击败了 5.00% 的用户
    public int numTrees(int n) {
        if(n==0||n==1)return 1;
        int result=0;
        for(int i=1;i<=n;i++){
            result+=numTrees(i-1)*numTrees(n-i);
        }
        return result;
    }
}
