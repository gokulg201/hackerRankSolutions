//$Id$
package hackerRank.dataStructures.linkedLists;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Merging 2 ascending sorted Linked Lists into a ascendingly sorted Linked List without the use of a temporary Linked list
 * @author gokul-4406
 *
 */
public class MergeLL {
	static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    	//Compare 2 heads
    	if(head1 == null && head2 == null){
    		return null;
    	}else if(head1 == null){
    		return head2;
    	}else if(head2 == null){
    		return head1;
    	}
    	if(head1.data <= head2.data){
    		head1.next = mergeLists(head1.next, head2);
    	}else{
    		SinglyLinkedListNode temp = head2;
    		head2 = head2.next;
    		temp.next = head1;
    		head1 = temp;
    		head1.next = mergeLists(head1.next, head2);
    	}
    	return head1;
    }
    /**
     * Given two linked lists sorted in increasing order. 
     * Merge them such a way that the result list is in decreasing order. Both the Linked list can be of different sizes.
     * https://www.geeksforgeeks.org/merge-two-sorted-linked-lists-such-that-merged-list-is-in-reverse-order/
     * 
     * @param head1
     * @param head2
     * @return
     */
    static SinglyLinkedListNode mergeInReverse(SinglyLinkedListNode head1, SinglyLinkedListNode head2){
    	head1 = reverseList(head1);
    	head2 = reverseList(head2);
	    return mergeDescending(head1,head2);
    }
    static SinglyLinkedListNode mergeDescending(SinglyLinkedListNode node1, SinglyLinkedListNode node2){
        if(node1 == null && node2 == null){
            return null;
        }
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        if(node1.data >= node2.data){
            node1.next = mergeDescending(node1.next, node2);
        }else{
        	SinglyLinkedListNode temp = node2;
            node2 = node2.next;
            temp.next = node1;
            node1 = temp;
            node1.next = mergeDescending(node1.next, node2);
        }
        return node1;
    }
    /**
     * Given pointer to the head node of a linked list, the task is to reverse the linked list.
     * We need to reverse the list by changing links between nodes.
     * https://www.geeksforgeeks.org/reverse-a-linked-list/
     * @param node
     * @return
     */
    static SinglyLinkedListNode reverseList(SinglyLinkedListNode node){
    	SinglyLinkedListNode prev = null;
    	SinglyLinkedListNode current = node;
    	SinglyLinkedListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
    	SinglyLinkedListNode _head = head;
    	if(_head == null){
    		return null;
    	}
    	while(_head.next != null){
    		if(_head.data == _head.next.data){
    			_head.next = _head.next.next;
    		}else{
    			_head = _head.next;
    		}
    	}
    	return head;
    }
    /**
     * Floyd's Cycle Detection Algorithm
     * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
     * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
     * @param head
     * @return
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
    	if(head == null)
    		return false;
    	SinglyLinkedListNode slow = head;
    	SinglyLinkedListNode fast = head;
    	while(fast != null && fast.next!= null){
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow.equals(fast)){
    			return true;
    		}
    	}
    	return false;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            boolean result = hasCycle(llist.head);

            bufferedWriter.write(String.valueOf(result ? 1 : 0));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
