package hashTable;
import java.util.HashMap;
import java.util.Map;

public class Al_594LongestHarmoniousSubsequence {
	/*
	 * Time Complexity: O(n+m) m<=n -> O(2n) at worst case; O(n) at best case
	 * */
	public int findLHS(int[] nums) {
	    Map<Long, Integer> map = new HashMap<>();
	    for (long num : nums) {//O(n)
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }
	    System.out.println("map:" + map.toString());
	    int result = 0;
	    for (long key : map.keySet()) {//O(m)
	        if (map.containsKey(key + 1)) {
	            result = Math.max(result, map.get(key + 1) + map.get(key));
	        }
	    }
	    return result;
	}	
		
	public static void main(String[] args){
//		int[] input = {1,1,1,1};//{1,3,2,2,5,2,3,7};
//		int[] input = {1,3,2,2,5,2,3,7};
//		int[] input  = {1,3,5,7,9,11,13,15,17};
//		int[] input = {1,2,1,3,0,0,2,2,1,3,3};
		int[] input = {2,2,2,2,2,2,2,3,1,0,0,0,3,1,-1,0,1,1,0,0,1,1,2,2,2,0,1,2,2,3,2};
		Al_594LongestHarmoniousSubsequence lhs = new Al_594LongestHarmoniousSubsequence();
		System.out.print(lhs.findLHS(input));
	}
}
