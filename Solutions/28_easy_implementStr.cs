public class Solution {
    public int StrStr(string haystack, string needle) {
       if (needle == null || needle == "" || needle.Length > haystack.Length)
           return -1;
    
        int i = 0, j= 0, ans = -1;
        
        while (i < haystack.Length && j < needle.Length) {
            if (haystack[i] == needle[j]) {
                ans = i;
                while (j < needle.Length && i < haystack.Length) {
                    if(haystack[i] != needle[j]) {
                        i = ans+1;
                        ans = -1;
                        j = 0;
                        break;
                    }
                        i++;
                        j++;
                }                
            }   
            else
                i++;   
        } 
        
        if (j != needle.Length  && ans != -1) 
            return -1;
        
        return ans;
    }
}