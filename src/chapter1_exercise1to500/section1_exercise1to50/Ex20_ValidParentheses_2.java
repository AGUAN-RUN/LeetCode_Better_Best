package chapter1_exercise1to500.section1_exercise1to50;

public class Ex20_ValidParentheses_2 {
    public boolean isValid(String s) {
       /* 数据容器ArrayList改为stack
        多个if  else语句   改为  使用一个switch语句
        */
        char[] strings = s.toCharArray();
        char[] stack = new char[strings.length+1];
        int top = 0;
        boolean isValid = true;
        for (int i =0;i<strings.length;i++){
            switch (strings[i]){
                case '(':
                    top++;
                    stack[top] ='(';

                    break;
                case ')':
                    if (stack[top]!='('){
                        isValid = false;
                    }else {
                        top--;
                    }
                    break;
                case '{':
                    top++;
                    stack[top] ='{';
                    break;
                case '}':
                    if (stack[top]!='{'){
                        isValid = false;
                    }else {
                        top--;
                    }
                    break;
                case '[':
                    top++;
                    stack[top] ='[';
                    break;
                case ']':
                    if (stack[top]!='['){
                        isValid = false;
                    }else {
                        top--;
                    }
                    break;
            }
        }
        if (isValid&&top==0){
            return true;
        }else {
            return false;
        }
    }
}
