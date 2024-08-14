// Problem link: https://leetcode.com/problems/text-justification/description/

package Strings;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;
        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;
            
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            
            StringBuilder line = new StringBuilder();
            int gaps = last - index - 1;

            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int extraSpaces = (maxWidth - totalChars) % gaps;
                
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + (i - index < extraSpaces ? 1 : 0)); j++) {
                            line.append(" ");
                        }
                    }
                }
            }
            
            result.add(line.toString());
            index = last;
        }
        
        return result;
    }
}