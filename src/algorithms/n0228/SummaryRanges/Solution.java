package algorithms.n0228.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> result = solution.summaryRanges(new int[]{0,1,2,4,5,7});
		System.out.println(result);
	}

	public List<String> summaryRanges(int[] array) {
		
		List<String> result = new ArrayList<String>();
		
		if(array.length == 0 )  {
			//Do Nothing
		}else if(array.length == 1) {
			result.add(String.valueOf(array[0]));
		}else if(array.length == 2){
			if(array[1] == array[0] + 1) {				
				result.add(array[0] + "->" + array[1]);
			}else {
				result.add(String.valueOf(array[0]));
				result.add(String.valueOf(array[1]));
			}
		}else {
			int i=0;
			int j=0;
			
			while(i<array.length && j<array.length) {
				if(j+1 < array.length && array[j+1] == array[j] + 1){
					j++;
				}else {
					if(i == j) {
						result.add(array[i] + "");
						i++; j++;
					}else {
						result.add(array[i] + "->" + array[j]);
						i = j+1;
						j = j+1;
					}
				}
				
			}
		}
		
		return result;
	}

}
