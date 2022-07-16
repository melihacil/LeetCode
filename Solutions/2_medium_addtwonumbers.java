class Solution {


        /* Accepted solution that sums digit by digit and also uses an extra
        number to hold sums carry. While summing it also adds the value to the
        answer listnode */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode answer = new ListNode(0);
        ListNode temp = answer;
        
        int carry = 0;
        
        while (l1 != null || l2 != null) {          //Loop that will continue until both
            int value1,value2;                      //both of the list becomes null
            if (l1 == null)                         //Checks if the lists are null and then assigns the value 
                value1 = 0;                         //According to it
            else value1 = l1.val;
            if (l2 == null)
                value2 = 0;
            else value2 = l2.val;
            
            temp.next = new ListNode((value2 + value1 + carry)%10); //Assign the sum of digits and carry (ex: 9+9+9 =27%10 = 10)
            temp = temp.next;                                       
            carry = (value1 + value2+ carry)/10;                    //Calculate the carry 
            
            if (l1 != null)                                         //go to the next node if it is not empty
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;                  
        }
        
        if (carry > 0)                    //Assign if there is a carry number left
            temp.next = new ListNode(carry);
            
        return answer.next;
    }


        /*Not accepted solution that gets all of the digits sums them and then finds 
        the total sum of two digits. After finishing all the sum process it assigns digit by
        digit to a new list node. This solution does not work numbers beyond long or int size
        but for all of the numbers lower than that limit this solution works*/

      public ListNode addTwoNumbersAnotherSolutionNotAccepted(ListNode l1, ListNode l2) {
        ListNode temp1 = l1,temp2 = l2;

        long sum1 = 0,sum2 = 0;
        
        int count = 0;
        while (temp1 != null) {
            long thisval = temp1.val;
            for (int i = 0; i < count;i++) {
                thisval *= 10;
            }
            count++;
            sum1 += thisval;
            
            temp1 = temp1.next;
        }
        count = 0;
        while (temp2 != null) {
            long thisval = temp2.val;
            for (int i = 0; i < count;i++) {
                thisval *= 10;
            }
            count++;
            sum2 += thisval;
            temp2 = temp2.next;
        }
        sum1 = sum1+sum2;
    
        ListNode answer = new ListNode();
        temp1 = answer;
        while (sum1 != 0) {
            long value = 0;
            long test = sum1 % 10;
            value = test;

            sum1 = sum1/ 10;
            temp1.val = (int) value;
            if (sum1 != 0)
                temp1.next = new ListNode();
            temp1 = temp1.next;
        }
        
        return answer;
    }

}