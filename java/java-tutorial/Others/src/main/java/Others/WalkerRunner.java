package Others;

import java.util.LinkedList;
import java.util.Scanner;

public class WalkerRunner
{

//	  Definition for singly-linked list.
    class ListNode
    {
        int val;
        ListNode next;
        ListNode head;

        ListNode(int x)
        {
            val = x;
            next = null;
            head = null;
        }

        @Override
        public String toString()
        {
            return "list values: " + val;
        }
    }

    public class Solution
    {
        public boolean hasCycle(ListNode head)
        {
            if (head == null)
            {
                return false;
            }
            ListNode walker = head;
            ListNode runner = head;
            while (runner.next != null && runner.next.next != null)
            {
                walker = walker.next;
                runner = runner.next.next;
                if (walker == runner)
                {
                    return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the given value: ");
        WalkerRunner sample = new WalkerRunner();
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        ListNode head = sample.new ListNode(scanner.nextInt());
        ListNode node1 = head.next = sample.new ListNode(scanner.nextInt());
        ListNode node2 = node1.next = sample.new ListNode(scanner.nextInt());
        ListNode node3 = node1.next = sample.new ListNode(scanner.nextInt());
        node3.next = node1;
        list.add(head);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        System.out.println("List: " + list);
        Solution solution = sample.new Solution();
        System.out.println("true or false: " + solution.hasCycle(head));
    }

}
