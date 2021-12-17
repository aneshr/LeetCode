import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepChars {
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0;

        Map<Character,Boolean> _map = new HashMap<>();
        int Longestsubstring = 0;
        int substring =0 ;
        while(left < s.length() && right < s.length()){

            // moving right pointer check if char[right] is present in map
            if(_map.containsKey(s.charAt(right))){
                _map.remove(s.charAt(left));
                left++;
                Longestsubstring = Math.max(Longestsubstring,substring);
                substring--;
            }
            else{
                _map.put(s.charAt(right),true);
                substring++;
                right++;
            }

        }
        Longestsubstring = Math.max(Longestsubstring,substring);
        return(Longestsubstring);
    }
}