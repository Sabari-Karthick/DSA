package com.LinkedList.Problems;

import com.LinkedList.Problems.LinkedList.Node;

public class MergeSortedList {
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(4);
		LinkedList l2 = new LinkedList();
		l2.insert(1);
		l2.insert(3);
		l2.insert(4);
		l1.display();
		l2.display();
		LinkedList list = merge(l1, l2);
		list.display();

	}

	static LinkedList merge(LinkedList l1, LinkedList l2) {

		LinkedList ans = new LinkedList();

		Node f = l1.getHead();
		Node s = l2.getHead();
		while (f != null && s != null) {
			if (f.data < s.data) {
				ans.insert(f.data);
				f = f.next;
			} else {
				ans.insert(s.data);
				s = s.next;

			}
		}
		while (f != null) {
			ans.insert(f.data);
			f = f.next;
		}
		while (s  != null) {
			ans.insert(s.data);
			s = s.next;
		}

		return ans;
	}
}
