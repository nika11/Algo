package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Al_599MinimumIndexSumofTwoLists_2 {
	public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = null;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        
        //not effective
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        
        for (int i = 0; i < list1.length; i++) {
            if (map2.containsKey(list1[i])) {
                int sum = map1.get(list1[i]) + map2.get(list1[i]);
                if (sum < min) {
                    min = sum;
                    result = new ArrayList<String>();
                    result.add(list1[i]);
                }
                else if (sum == min) {
                    result.add(list1[i]);
                }
            }
        }
        
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
}
