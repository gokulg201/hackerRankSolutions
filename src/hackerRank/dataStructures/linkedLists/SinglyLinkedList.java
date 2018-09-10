//$Id$
package hackerRank.dataStructures.linkedLists;

import java.util.Stack;

public class SinglyLinkedList {
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public Node head;
	public Node tail;
	public SinglyLinkedList() {
	}
	public void insertNode(int data){
		Node _new = new Node(data);
		if (this.head == null) {
            this.head = _new;
        } else {
            this.tail.next = _new;
        }

        this.tail = _new;
	}
	static Node insertNodeAtPosition(Node head, int data, int position) {
		Node _new = new Node(data);
		Node _head = head;
		while(_head.next != null && --position > 0){
			_head = _head.next;
		}
		_new.next = _head.next;
		_head.next = _new;
		return head;
    }
	static Node deleteNode(Node head, int position) {
		if(position == 0){
        	head = head.next;
        	return head;
        }
		Node _head = head;
		while(_head.next != null && --position > 0){
			_head = _head.next;
		}
		_head.next = _head.next.next;
		return head;
	}
	static void reversePrint(Node head) {
		Stack<Integer> _reverse = new Stack<Integer>();
		Node _head = head;
		while(_head != null){
			_reverse.add(_head.data);
			_head = _head.next;
		}
		while(!_reverse.isEmpty()){
			System.out.println(_reverse.pop());
		}
    }
}
