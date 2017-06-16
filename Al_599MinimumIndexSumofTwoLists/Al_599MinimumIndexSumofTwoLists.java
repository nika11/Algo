package hashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Al_599MinimumIndexSumofTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
	    Map<String, Integer> map = new HashMap<>();
	    List<String> res = new LinkedList<>();
	    int minSum = Integer.MAX_VALUE;
	    for (int i=0;i<list1.length;i++) map.put(list1[i], i);
	    for (int i=0;i<list2.length;i++) {
	        Integer j = map.get(list2[i]);
	        if (j != null && i + j <= minSum) {
	            if (i + j < minSum) {//reset whenever there is smaller one 
	            	res = new LinkedList<>(); 
	            	minSum = i+j; 
	            	}
	            res.add(list2[i]);
	        }
	    }
	    return res.toArray(new String[res.size()]);
	}
	public static void main(String[] args){
		String[] input1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] input2 = {"Tapioca Express", "Shogun","The Grill at Torrey Pines", "Hungry Hunter Steakhouse"};
		Al_599MinimumIndexSumofTwoLists findRt = new Al_599MinimumIndexSumofTwoLists();
		String[] output = findRt.findRestaurant(input1, input2);
		for (String s : output){
			System.out.println(s);
		}
	}
}