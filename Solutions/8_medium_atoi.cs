public class Solution {
    public int MyAtoi(string s) {  
        //String to integer (C/C++ atoi func)      
        //if (string.IsNullOrEmpty(s)) return 0;
        /* 
           Trim and check if the string is empty
           create answer to be returned
           and create an int to hold the index 
        */
        s = s.Trim();
        int sign = 1;
        long answer = 0;
        int index = 0;
        if (string.IsNullOrEmpty(s)) return 0;    
        //Checking positive or negative sign after trimming    
        if (s[0] == '-' || s[0] == '+')
        {
            sign = s[0] == '+' ? 1 : -1;
            index++;
        }
        //Starts from one or two then will go on through until 
        //it is not a digit. A while loop can be used here rather than for       
        for (int i = index; i < s.Length; i++) {
            if (char.IsNumber(s[i])) {
            //If its a digit add and check if it has passed max value
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