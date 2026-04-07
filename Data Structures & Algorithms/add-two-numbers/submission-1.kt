/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        val dummyHead = ListNode(0)
        var current = dummyHead
        var carry = 0
        
        
        var p = l1
        var q = l2
        
        
        while (p != null || q != null || carry != 0) {
            
            val val1 = p?.`val` ?: 0
            val val2 = q?.`val` ?: 0
            
           
            val sum = val1 + val2 + carry
            carry = sum / 10  // Carry for next digit
            val digit = sum % 10  // Current digit
            
            
            current.next = ListNode(digit)
            current = current.next!!
            
            
            p = p?.next
            q = q?.next
        }
        
        return dummyHead.next 



    }
}
