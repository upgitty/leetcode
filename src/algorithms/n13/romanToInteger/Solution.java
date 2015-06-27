package algorithms.n13.romanToInteger;

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.romanToInt("DCXXI"));
	}
    
    private enum Roman {
		I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
		
		public int value;
		
		private Roman(int val) {
			this.value = val;
		}
		
		public static int getValueByString(String s) throws Exception {
			for(Roman t : Roman.values()) {
				if(t.name().equals(s)){
					return t.value;
				}
			}
			throw new Exception("incorrect roman digit !");
		}
		
	}
	
    public int romanToInt(String roman) {
        int result = -1;
		try {
			String[] splits = roman.split("");
			String previous = splits[0];
			int previousValue = Roman.getValueByString(previous);
			result = previousValue;
			for(int i=1; i<splits.length; i++) {
				String current = splits[i];
				int val = Roman.getValueByString(current);
				if(val > previousValue){
					result -= 2*previousValue;
				}
				result += val;
				
				previous = current;
				previousValue = val;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
    }
}