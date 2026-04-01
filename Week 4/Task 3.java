class Solution 
{
    public int longestSubarray(int[] nums, int limit) 
    {
        
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) 
        {
            
            // Maintain decreasing deque for max
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) 
            {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);
            
            // Maintain increasing deque for min
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) 
            {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);
            
            // Shrink window if invalid
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) 
            {
                
                if (nums[left] == maxDeque.peekFirst()) 
                {
                    maxDeque.pollFirst();
                }
                if (nums[left] == minDeque.peekFirst()) 
                {
                    minDeque.pollFirst();
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}