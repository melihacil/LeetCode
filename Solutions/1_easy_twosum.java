import java.util.Scanner;
import java.util.Arrays;


class Solution {

    /* Brute force method running time is O(N^2) because of the two for loops */
    
    public int[] twoSumBruteForce(int[] nums, int target) { //Two sum solution using Brute force
        int i,j;
        int[] arr = new int[2];
        for (i = 0 ; i < nums.length; i++) {        //Using two loops to check every item 
            for (j= i+1 ; j < nums.length; j++) {   //Until reaching the target
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }

    /* Hashmap method uses complementary numbers to 
    find the answer and its running time is O(N)  */

    public int[] twoSumHashMap(int[] nums, int target) {    //Two sum with using a hash map
        Map<Integer, Integer> numberMap = new HashMap<>();  //A hashmap to hold the index and complementary number
        int [] answer = new int[2];                         
        for (int i = 0; i < nums.length; i++) {             
            int complement = target - nums[i];              //Complementary number
            if (numberMap.containsKey(complement)) {        //If this number found in hashmap then 
                answer[0] = numberMap.get(complement);      //Result will be returned
                answer[1] = i;
                break;
            } 
            else {
                numberMap.put(nums[i], i);                  //Puts complementary number to the hashmap
            }
        }
        return answer;
    }

    /*Two pointer solution that wont work with this question 
    because this method needs a sorted array and it will change
    the indices that required as an answer.*/

    public int[] twoSumTwoPointer(int[] nums, int target) {
        int low = 0;                                //Starting points a low and a high 
        int high = nums.length -1;                  //to search in a sorted array
        Arrays.sort(nums);
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target)                      //If low and high equals to the target then answer is found
                return new int[] {low,high};
            else if (sum < target)                  //If it is smaller low value should be increased
                low++;
            else if (sum > target)                  //If it is higher than high value should be decreased
                high --;            
        }
        return new int[] {};                        //If answer is not found return an empty array
    }
}
