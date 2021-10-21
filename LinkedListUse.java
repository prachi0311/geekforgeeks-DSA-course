package codes;

import java.util.LinkedList;

import org.w3c.dom.Node;

public class LinkedListUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode first = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(3);
		LinkedListNode fourth = new LinkedListNode(4);
//		LinkedListNode five = new LinkedListNode(5);
//		LinkedListNode six = new LinkedListNode(6);
//		
		first.next=first;
		//two.next=first;
	//	three.next=fourth;
	//	fourth.next=two;
//		fourth.next=five;
//		five.next=six;
		
		
		//LinkedListNode head = reverseList(first);
		
		//LinkedListNode head = removeHead(first);
		
		//LinkedListNode head = insertAtBeginOfCirLL(first);
		//printList(head);
		//printCirList(head);
		//midElement(first);
		//printList(first);
		//LinkedListNode head = reverseList(first);
		//printList(head);
		
		System.out.println(detectLoop(first));
		
	}
	
	public static Boolean detectLoop(LinkedListNode head) {
		LinkedListNode slow=head;
		LinkedListNode fast=head;
		
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return true;
		}
		
		return false;
	}
	
	public static LinkedListNode reverseList(LinkedListNode head) {
		if(head==null)
			return null;
		else {
			LinkedListNode curr=head;
			LinkedListNode prev=null;
			LinkedListNode nextNode=null;
			if(curr.next!=null) {
				nextNode=curr.next;
			}
			
			while(curr!=null) {
				
				curr.next=prev;
				prev=curr;
				curr=nextNode;
				if(curr!=null) {
					nextNode=curr.next;
				}
				
			}
			
			return prev;
			
			}
	}
	
	public static void midElement(LinkedListNode head) {
		LinkedListNode slow=head;
		LinkedListNode fast=head;
		while(fast.next!=null) {
			slow=slow.next;
			if(fast.next.next!=null)
			fast=fast.next.next;
			else
				fast=fast.next;
		}
		System.out.println(slow.data);
	}

	private static void printCirList(LinkedListNode head) {
		// TODO Auto-generated method stub
		if(head!=null)
			System.out.println(head.data);
		
		LinkedListNode temp=head.next;
		while(temp != head) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}

	private static LinkedListNode insertAtBeginOfCirLL(LinkedListNode first) {
		// TODO Auto-generated method stub
		LinkedListNode temp=new LinkedListNode(0);
		if(first==null) {
			temp.next=temp;
		}
		else {
			temp.next=first.next;
			first.next=temp;
			int i = first.data;
			first.data=temp.data;
			temp.data=i;
			
			temp=first;
			
		}
		return temp;
	}

	private static LinkedListNode removeHead(LinkedListNode first) {
		// TODO Auto-generated method stub
		
		first=first.next;
		first.prev.next=null;
		first.prev=null;
		
		return first;
	}

	private static void printList(LinkedListNode head) {
		// TODO Auto-generated method stub
		while(head!=null) {
			System.out.println(head.data);
			head=head.next;
		}
	}

//	private static LinkedListNode reverseList(LinkedListNode first) {
//		// TODO Auto-generated method stub
//		LinkedListNode head = first;
//		LinkedListNode temp=head.next;
//		head.next=head.prev;
//		head.prev=temp;
//		head=head.prev;
//		while(head.prev!=null) {
//			LinkedListNode temp1=head.next;
//			head.next=head.prev;
//			head.prev=temp1;
//			if(head.prev==null)
//				return head;
//			head=head.prev;
//		}
//
//		return null;
//}
}
