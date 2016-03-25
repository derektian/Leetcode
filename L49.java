/*L49 Group Anagrams
Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/
import java.util.*;
public class L49 {
/*	//遍历两次，简单粗暴算法
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<List<String>>();
		//sign用来标明当前string是否已经被加入到group中。
		 
		int[] sign = new int[strs.length];
		for(int i = 0; i < strs.length; i++) {
			sign[i] = 0;
		}
		
		for(int i = 0; i < strs.length; i++) {
			if(sign[i] == 0) {
				char[] temp = strs[i].toCharArray();
				Arrays.sort(temp);
				String tempStr = String.valueOf(temp);
				LinkedList<String> group = new LinkedList<String>();
				group.add(strs[i]);
				for(int j = i + 1; j < strs.length; j++) {
					if(sign[j] == 0) {
						char[] tempNext = strs[j].toCharArray();
						Arrays.sort(tempNext);
						String tempNextStr = String.valueOf(tempNext);
						if(tempStr.equals(tempNextStr)) {
							sign[j] = 1;
							if(strs[j].compareTo(strs[i]) >= 0) {
								group.add(strs[j]);
							} else {
								group.addFirst(strs[j]);
							}
						}
					}
				}
				result.add(group);
			}
		}
		return result;
    }
*/	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, LinkedList<String>> hashmap = new HashMap<String,LinkedList<String>>();
		
		for(int i = 0; i < strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String tempStr = String.valueOf(temp);
			if(hashmap.containsKey(tempStr)) {
//				if(strs[i].compareTo(hashmap.get(tempStr).getLast()) >= 0) {
//					hashmap.get(tempStr).add(strs[i]);
//				} else {
//					hashmap.get(tempStr).addFirst(strs[i]);
//				}
				hashmap.get(tempStr).add(strs[i]);

			} else{
				LinkedList<String> group = new LinkedList<String>();
				group.add(strs[i]);
				hashmap.put(tempStr, group);
			}
		}
		
		//不知道具体hashmap的keys，没法用普通的for来遍历。
		//那么利用foreach来循环
		for(LinkedList<String> group: hashmap.values()) {
			Collections.sort(group);
			result.add(group);
		}
			
		return result;
	}
	
	
	public static void main(String[] args) {
		String[] strs = {"tea","and","ate","eat","den"};
		
		L49 test = new L49();
		System.out.println(test.groupAnagrams(strs));
	}
}


