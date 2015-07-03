/**
 * 
 */
package algorithms.n0068.TextJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author upgitty
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 0;
		
//		String[] words = {""};
//		int maxWidth = 0;
		
		List<String> justifiedLines = solution.fullJustify(words, maxWidth);
		
		justifiedLines.forEach(line -> System.out.println(line));
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> lines = new ArrayList<>();
		
		StringBuilder line = new StringBuilder();
		int numberOfSpacesInLine = 0;
		for(String word : words) {
			if(line.length() + word.length() > maxWidth) {
				justifyLine(line, maxWidth, numberOfSpacesInLine);
				lines.add(line.toString());
				line = new StringBuilder();
				numberOfSpacesInLine = 0;
			}
			
			line.append(word);
			if(line.length() < maxWidth - 1) {				
				line.append(" ");
				numberOfSpacesInLine++;
			}
			
		}
		
		justifyLine(line, maxWidth, numberOfSpacesInLine);
		lines.add(line.toString());
		
		return lines;
    }
	
	private void justifyLine(StringBuilder line, int maxWidth, int numberOfSpacesInLine) {
		if(line.length() > 0 && line.charAt(line.length() - 1) == ' ') {
			line.deleteCharAt(line.length() - 1);
			numberOfSpacesInLine--;	//Because we trim and remove the last space			
		}
		
		if(numberOfSpacesInLine > 0) {			
			int numberOfSpacesNeeded = maxWidth - line.length();
			int spaceMultiplicant = numberOfSpacesNeeded / numberOfSpacesInLine;
			
			
			for(int index = 0; index < line.length() && line.length() != maxWidth; index++) {
				if(line.charAt(index) == ' ') {
					if(spaceMultiplicant > 0) {							
						int count = 0;
						while(line.length() != maxWidth && count < spaceMultiplicant) {
							line.insert(index, ' '); 
							count++;
							index++;
						}
					}else {
						line.insert(index, ' '); 
						index++;
					}
				}
			}
			
		}
		
	}
}
