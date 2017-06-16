package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Al609_FindDuplicateFileinSystem {
	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> result = new ArrayList<List<String>>();
		int n = paths.length;
		if (n == 0)
			return result;

		Map<String, Set<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] strs = path.split("\\s+");
			for (int i = 1; i < strs.length; i++) {
				int idx = strs[i].indexOf("(");
				String content = strs[i].substring(idx);
				System.out.println("-->cotent: " + content);
				String filename = strs[0] + "/" + strs[i].substring(0, idx);
				Set<String> filenames = map.getOrDefault(content,
						new HashSet<String>());
				filenames.add(filename);
				map.put(content, filenames);
			}
		}

		for (String key : map.keySet()) {
			if (map.get(key).size() > 1) {
				result.add(new ArrayList<String>(map.get(key)));
			}
		}

		return result;
	}
	public static void main(String[] args){
		String[] input = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		System.out.println("Input: ");
		for(String i:input){
			System.out.print(i + ";");
		}
		System.out.print("\n");
		Al609_FindDuplicateFileinSystem finddup = new Al609_FindDuplicateFileinSystem();
		List<List<String>> output = finddup.findDuplicate(input);
		for (List<String> s : output){
			System.out.println(s.toString());
		}
	}
}
