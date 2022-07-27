public class Solution {
    public int RemoveDuplicates(int[] nums) {
        
        //Returning how many non duplicate items in this array
        int count = 1;        
        //Getting a temporary int to hold the first value
        int temp = nums[0];        
        for (int i = 0; i < nums.Length;i++) {           
            if (nums[i] != temp) {                
                temp = nums[i];
                nums[count] = temp;
                count++;
            }            
        }        
        return count;
    }
}