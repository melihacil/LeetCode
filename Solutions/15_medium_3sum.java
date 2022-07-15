//Brute force Does not look for duplicates
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList();
        for (int i = 0;i < nums.length; i++) {
            while(i > 0 && i < nums.length - 1 && nums[i] == nums[i - 1]) i++;
            
            for (int j= i+1; j < nums.length ; j++) {
                for (int z = j+1 ; z < nums.length ; z++) {
                    if (nums[i] + nums[j] + nums[z] == 0)
                        list.add(List.of(nums[i],nums[j],nums[z]));
                } 
            }
        }
        return list;
    }
}

/*                  Two pointer solution
    This solution looks at a sorted array with two pointers and in 
    a for loopIt also checks if there is duplications in the array. */
    
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int low,high;
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < nums.length ; i++) {
            if(i>0 && nums[i] == nums[i-1]){//Checking to avoid duplication
                continue;
            }
            low = i+1;
            high = nums.length-1;
            int a = -nums[i];
            while (low < high) {
                int twosum = nums[low] +nums[high];
                if (a == twosum) {
                    list.add(List.of(nums[i],nums[low],nums[high]));
                    low++;
                    high--;
                    while(low < high && nums[low] == nums[low-1]) low++;//Checking to avoid duplication
                    while(low < high && nums[high] == nums[high+1]) high--;//Checking to avoid duplication
                }
                else if (twosum < a)    //Because the array is sorted it moves the lower pointer up
                    low++;
                else                    //Or if its bigger than the target then lowers the high pointer
                    high--;
            }           
        }
        return list;
    }
}