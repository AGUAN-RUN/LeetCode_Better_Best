package chapter1_exercise1to500.section4_exercise151to200;

import java.util.ArrayList;
import java.util.List;

/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
//先进后出
//测试用时6ms ,击败98%的用户
public class Ex155_MinStack {
    private List<Integer> nums=new ArrayList<>();
    //先初始化为int最大值
    private int min=Integer.MAX_VALUE;
    public Ex155_MinStack() {

    }
    public void push(int x) {
        nums.add(x);
        if(x<this.min)this.min=x;
    }

    public void pop() {
        if(nums.remove(nums.size()-1)==this.min){
            int min=Integer.MAX_VALUE;
            for(int i:nums){
                if(i<min)min=i;
            }
            this.min=min;
        }
    }

    public int top() {
        return nums.get(nums.size()-1);
    }

    public int getMin() {
        return this.min;
    }
}
