package hashTable;
import java.util.Map;
import java.util.HashMap;
public class Al_1TwoSum {
	  public int[] solution(int[] nums, int target){
	    int[] result = new int[2];
	    Map<Integer, Integer> cp = new HashMap<Integer, Integer>();
	    if(nums.length <= 1) return null;
	    for(int i=0; i< nums.length; i++){
	      int temp = target - nums[i];
	      if(cp.containsKey(temp)){
	        result[1] = i + 1;
	        result[0] = cp.get(target - nums[i]);
	        return result;
	      }
	      cp.put(nums[i], i + 1);
	    }
	    return result;
	  }
	  
	  public static void main(String[] args){
	    Al_1TwoSum test =  new Al_1TwoSum();
	    int[] input = {-2, 12, 8, 11};
	    int target = 9;
	    int[] return1 = new int[2];
	    return1 =  test.solution(input, target);
	    for(int i : return1)
	    	System.out.println("return: " + i);
	  }
	  
	}
