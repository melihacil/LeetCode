public class Solution {
    public int MyAtoi(string s) {        
        //if (string.IsNullOrEmpty(s)) return 0;
        s = s.Trim();
        int sign = 1;
        long answer = 0;
        int index = 0;
        if (string.IsNullOrEmpty(s)) return 0;        
        if (s[0] == '-' || s[0] == '+')
        {
            sign = s[0] == '+' ? 1 : -1;
            index++;
        }       
        for (int i = index; i < s.Length; i++) {
            if (char.IsNumber(s[i])) {
                answer = answer * 10 + s[i] - '0';
                if (answer > int.MaxValue)
                    break;
            }
            else 
                break;
            
        }
        if (answer * sign > int.MaxValue)
            return int.MaxValue;
        if (answer * sign < int.MinValue)
            return int.MinValue;
        
        return (int)answer * sign;        
    }
}