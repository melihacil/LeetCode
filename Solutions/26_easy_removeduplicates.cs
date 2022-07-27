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

    //Two pointer solution
     public int RemoveDuplicatesTwoPointer(int[] nums) {
        
        
        //Becuase nums is sorted two pointer method could be used
        //Left and right pointers starts from the first index
        int leftptr = 1,rightptr =1;
        
        
        //Loop until right pointer reaches the end
        while (rightptr < nums.Length) {
            //if its duplicate continue
            if (nums[rightptr] == nums[rightptr -1]) 
                rightptr++;
            else {
                //If its not a duplicate then change it with left pointer then continue
                nums[leftptr] = nums[rightptr];
                leftptr++;
                rightptr++;                
            }            
        }
        //As we started from 1 leftpointer counted how many non-duplicate items in the array
        //And we can return this answer.
        return leftptr;
    }
}