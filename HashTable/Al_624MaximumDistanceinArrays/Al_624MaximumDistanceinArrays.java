package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Al_624MaximumDistanceinArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        
        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        
        return result;
    }
    public static void main(String[] args){
    	List<List<Integer>> input = new ArrayList<List<Integer>>();
    	List<Integer> input1 = Arrays.asList(1,2,3);
    	List<Integer> input2 = Arrays.asList(4,5);
    	List<Integer> input3 = Arrays.asList(1,2,3);
    	input = Arrays.asList(input1,input2,input3);
    	Al_624MaximumDistanceinArrays maxDis = new Al_624MaximumDistanceinArrays();
    	System.out.println(maxDis.maxDistance(input));
    	
    }
}
