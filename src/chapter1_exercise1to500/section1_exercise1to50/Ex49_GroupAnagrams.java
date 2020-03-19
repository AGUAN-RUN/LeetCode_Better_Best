package chapter1_exercise1to500.section1_exercise1to50;

import java.util.*;

public class Ex49_GroupAnagrams {
    //建立一个辅助Map，来保存一种字母异位词类型，和对应的List列表,对于返回值的处理作一定的优化
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length<1)return null;
        Map<String,List<String>> strMap= new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++){
            char[]strChar=strs[i].toCharArray();
            Arrays.sort(strChar);
            String str=new String(strChar);
            if(strMap.containsKey(str)){
                strMap.get(str).add(strs[i]);
            }else{
                strMap.put(str,new ArrayList<String>());
                strMap.get(str).add(strs[i]);
            }
        }
        return new ArrayList(strMap.values());
    }
}
