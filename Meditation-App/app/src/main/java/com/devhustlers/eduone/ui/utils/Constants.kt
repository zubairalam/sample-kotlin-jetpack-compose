package com.devhustlers.eduone.ui.utils

import androidx.compose.ui.graphics.Color
import com.devhustlers.eduone.ui.theme.Black
import com.devhustlers.eduone.ui.theme.Green
import com.devhustlers.eduone.ui.theme.Yellow

val FILTER_CONTENT_LIST = listOf(
    FilterContent(Color.White, Black, "Mood swings"),
    FilterContent(Black, Color.White, "Stress"),
    FilterContent(Black, Color.White, "Depression"),
    FilterContent(Black, Color.White, "Anxiety"),
    FilterContent(Black, Color.White, "Anger"),
    FilterContent(Black, Color.White, "Excitement"),
    FilterContent(Black, Color.White, "Fear"),
    FilterContent(Black, Color.White, "Joy"),
    FilterContent(Black, Color.White, "Horror")
)


val PROBLEM_LIST_ITEMS = listOf(
    ProblemSummary(
        "1",
        "Easy",
        "Singly Linked List",
        "Reverse Linked List",
        "Given the head of a singly linked list, reverse the list, and return the reversed list.",
        Yellow,
        Black,
        Green,
        """
           Given the head of a singly linked list, reverse the list, and return the reversed list.
           
           Example 1:
           Input: head = [1,2,3,4,5]
           Output: [5,4,3,2,1]
           
           Example 2:
           Input: head = [1,2]
           Output: [2,1]
           
           Example 3:
           Input: head = []
           Output: []
           
           Constraints:
           The number of nodes in the list is the range [0, 5000].
           -5000 <= Node.val <= 5000
        """.trimIndent(),
        """
            def reverseList(self, curr: Optional[ListNode], prev=None) -> Optional[ListNode]:
                while curr:
                    temp = curr.next
                    curr.next = prev
                    prev = curr
                    curr = temp
                return prev
        """.trimIndent(),
    ),
    ProblemSummary(
        "2",
        "Easy",
        "Singly Linked List",
        "Merge Two Sorted Lists",
        "Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.",
        Green,
        Black,
        Yellow,
        """
            You are given the heads of two sorted linked lists list1 and list2.

            Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

            Return the head of the merged linked list.
            
            Example 1:
            Input: list1 = [1,2,4], list2 = [1,3,4]
            Output: [1,1,2,3,4,4]
            
            Example 2:
            Input: list1 = [], list2 = []
            Output: []
            
            Example 3:
            Input: list1 = [], list2 = [0]
            Output: [0]
            
            Constraints:

            The number of nodes in both lists is in the range [0, 50].
            -100 <= Node.val <= 100
            Both list1 and list2 are sorted in non-decreasing order.
        """.trimIndent(),
        """
            class Solution:
                def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
                    cur = dummy = ListNode()
                    while list1 and list2:               
                        if list1.val < list2.val:
                            cur.next = list1
                            list1, cur = list1.next, list1
                        else:
                            cur.next = list2
                            list2, cur = list2.next, list2
                            
                    if list1 or list2:
                        cur.next = list1 if list1 else list2
                        
                    return dummy.next
        """.trimIndent(),
    ),
    ProblemSummary(
        "3",
        "Easy",
        "Singly Linked List",
        "Palindrome Linked List",
        "Given the head of a singly linked list, return true if it is a palindrome or false otherwise.",
        Black,
        Color.White,
        Yellow,
        """
            Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
            
            Example 1:
            Input: head = [1,2,2,1]
            Output: true
            
            Example 2:
            Input: head = [1,2]
            Output: false
             
            Constraints:
            The number of nodes in the list is in the range [1, 105].
            0 <= Node.val <= 9
             
            Follow up: Could you do it in O(n) time and O(1) space?
        """.trimIndent(),
        """
            class Solution:
                def isPalindrome(self, head: Optional[ListNode]) -> bool:
                    l1 = []
                    while head:
                        l1.append(head.val)
                        head = head.next
                    return l1 == l1[::-1]
        """.trimIndent(),
    ),
    ProblemSummary(
        "4",
        "Easy",
        "Singly Linked List",
        "Remove Linked List Elements",
        "Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.",
        Yellow,
        Black,
        Green,
        """
            Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

            Example 1:
            Input: head = [1,2,6,3,4,5,6], val = 6
            Output: [1,2,3,4,5]
            
            Example 2:
            Input: head = [], val = 1
            Output: []
            
            Example 3:
            Input: head = [7,7,7,7], val = 7
            Output: []
            
            Constraints:
            The number of nodes in the list is in the range [0, 104].
            1 <= Node.val <= 50
            0 <= val <= 50
        """.trimIndent(),
        """
            class Solution:
                def removeElements(self, head, T):
                    dummy = ListNode(-1, head)
                    prev = dummy
                    while head:
                        if head.val != T:
                            prev = head
                        else:
                            prev.next = head.next
                        head = head.next
                    return dummy.next
        """.trimIndent(),
    ),
    ProblemSummary(
        "5",
        "Easy",
        "Singly Linked List",
        "Remove Duplicates from Sorted List",
        "Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.",
        Green,
        Black,
        Yellow,
        """
            Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

            Example 1:

            Input: head = [1,1,2]
            Output: [1,2]
            
            Example 2:
            Input: head = [1,1,2,3,3]
            Output: [1,2,3]
             
            Constraints:
            The number of nodes in the list is in the range [0, 300].
            -100 <= Node.val <= 100
            The list is guaranteed to be sorted in ascending order.
        """.trimIndent(),
        """
            def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
                origin = head
                while head and head.next:
                    cur = head.val
                    if  head.next.val == cur:
                        head.next.ext = None
                        head.next =head.next.next
                    else:
                        head = head.next
                return origin
        """.trimIndent(),
    ),
    ProblemSummary(
        "6",
        "Easy",
        "Singly Linked List",
        "Intersection of Two Linked Lists",
        "Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.",
        Black,
        Color.White,
        Yellow,
        """
            Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

            For example, the following two linked lists begin to intersect at node c1:


            The test cases are generated such that there are no cycles anywhere in the entire linked structure.

            Note that the linked lists must retain their original structure after the function returns.

            Custom Judge:

            The inputs to the judge are given as follows (your program is not given these inputs):

            intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
            listA - The first linked list.
            listB - The second linked list.
            skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
            skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
            The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

             

            Example 1:
            Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
            Output: Intersected at '8'
            Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
            From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
            - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
            
            Example 2:
            Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
            Output: Intersected at '2'
            Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
            From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
            
            Example 3:
            Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
            Output: No intersection
            Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
            Explanation: The two lists do not intersect, so return null.
             

            Constraints:
            The number of nodes of listA is in the m.
            The number of nodes of listB is in the n.
            1 <= m, n <= 3 * 104
            1 <= Node.val <= 105
            0 <= skipA < m
            0 <= skipB < n
            intersectVal is 0 if listA and listB do not intersect.
            intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
             
            Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
        """.trimIndent(),
        """
            class Solution:
                def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
                    l1 = headA
                    l2 = headB
                    while l1 != l2:
                        l1 = l1.next if l1 else headB
                        l2 = l2.next if l2 else headA
                    
                    return l1
        """.trimIndent(),
    )
)