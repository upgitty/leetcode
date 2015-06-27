package algorithms.n15.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = {-2,0,1,1,2};
		List<List<Integer>> result = solution.threeSum(array);
		for(List<Integer> l : result) {			
			System.out.println("(" + l.get(0) + ", " + l.get(1) + ", " + l.get(2) + ")");
		}
	}
	
	
	public List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(arr.length < 3) {
			//Skip
	    }else {
	    	Arrays.sort(arr);
	    	int i = 0;
		    int j = 1;
		    int k = arr.length - 1; 
		    
		    for(i = 0; i < arr.length; i++) {
		        int sum = arr[i];
		        j = i + 1;
		        k = arr.length - 1;

		        if(arr[i] > 0) {
		            break;
		        }
		        
		        while( j < k ) {
		            int twoSum = arr[j] + arr[k];
		            if(twoSum + sum == 0) {
		                List<Integer> list = new ArrayList<Integer>();
		                list.add(arr[i]);
		                list.add(arr[j]);
		                list.add(arr[k]);
		                result.add(list);
		                j++; k--;
		            } else if(twoSum + sum < 0) {
		                j++;
		                if(i == j) j++;
		            }else {
		                k--;
		                if(i == k) k--;
		            }
		        }
		    }
	    }
		
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		for(List<Integer> l : result) { 
			set.add(l);
		}
		
		List<List<Integer>> setList = new ArrayList<>();
		for(List<Integer> elem : set) {
			setList.add(elem);
		}
		return setList;
	}
	
	
	public boolean thressSumExists (int[] arr) {

	    if(arr.length < 3) {
	        return false; 
	    }
	        
	    Arrays.sort(arr);
	    
	    int i = 0;
	    int j = 1;
	    int k = arr.length - 1; 
	    
	    for(i = 0; i < arr.length; i++) {
	        int sum = arr[i];
	        j = i + 1;
	        k = arr.length - 1;

	        if(arr[i] > 0) {
	            break;
	        }
	        
	        while( j < k ) {
	            int twoSum = arr[j] + arr[k];
	            if(twoSum + sum == 0) {
	                 return true;
	            } else if(twoSum + sum < 0) {
	                j++;
	                if(i == j) j++;
	            }else {
	                k--;
	                if(i == k) k--;
	            }
	        }
	    }
	    
	    return false;
	}
	
}
