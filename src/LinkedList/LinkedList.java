package LinkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Gurkanwal
 */
public class LinkedList<T> {

    public Node head = null;

    public void appendToTail(Node head, T d) {
        Node end = new Node<T>(d);
        if (head == null) {
            head = end;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
//        System.out.println(d + " appended to the List's tail.");
        this.head = head;
    }

    public void deleteFromTail(Node head) {
        if (head == null) {
//            System.out.println("Cannot delete from tail because there are no elements in the List. Underflow...");
        } else {
            Node n1 = head;
            Node n2 = head.next;
            if (n2 == null) {
                head = null;
//                System.out.println("Last element deleted. Linked List is now empty.");
            } else {
                while (n2.next != null) {
                    n1 = n1.next;
                    n2 = n2.next;
                }
                n1.next = null;
//                System.out.println("Last element deleted.");
            }
        }
        this.head = head;
    }

    public Node appendToFront(Node head, T d) {
        Node start = new Node<T>(d);
        if (head == null) {
            head = start;
        } else {
            Node n = head;
            start.next = n;
            head = start;
        }
//        System.out.println(d + " appended to the List's front.");
        this.head = head;
        return head;
    }

    public T deleteFromFront(Node head) {
        if (head == null) {
            throw new NoSuchElementException("Cannot delete from front because there are no elements in the List. Underflow...");
        } else {
            Node n1 = head;
            T data = (T) n1.data;
            Node n2 = head.next;
            if (n2 == null) {
                head = null;
                System.out.println("First element deleted. Linked List is now empty.");
            } else {
                head = n2;
                System.out.println("First element deleted.");
            }
            this.head = head;
            return data;
        }
    }

    public void appendArrayToFront(Node head, T[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Length of array should be greater than zero.");
        } else {
            if (head == null) {
                head = new Node<T>(a[0]);
                Node n = head;
                for (int i = 1; i < a.length; i++) {
                    Node p = new Node<T>(a[i]);
                    n.next = p;
                    n = n.next;
                }
            } else {
                Node oldHead = head;
                Node newHead = new Node<T>(a[0]);
                Node n = newHead;
                for (int i = 1; i < a.length; i++) {
                    Node p = new Node<T>(a[i]);
                    n.next = p;
                    n = n.next;
                }
                n.next = oldHead;
                head = newHead;
            }
            System.out.println(Arrays.toString(a) + " appended to the List's front.");
        }
        this.head = head;
    }

    public void appendArrayToTail(Node head, T[] a) {
        if (a.length == 0) {
            System.out.println("Length of array should be greater than zero.");
        } else {
            if (head == null) {
                head = new Node<T>(a[0]);
                Node n = head;
                for (int i = 1; i < a.length; i++) {
                    Node p = new Node<T>(a[i]);
                    n.next = p;
                    n = n.next;
                }
            } else {
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                for (int i = 0; i < a.length; i++) {
                    Node p = new Node<T>(a[i]);
                    n.next = p;
                    n = n.next;
                }
            }
            System.out.println(Arrays.toString(a) + " appended to the List's tail.");
        }
        this.head = head;
    }

    public void deleteFirstOccurrence(Node head, int num) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete " + num);
        } else {
            Node n = head;
            if ((int) n.data == num) {
                head = n.next;
                System.out.println("Number " + num + " found and deleted.");
            } else {
                while (n.next != null) {
                    if ((int) n.next.data == num) {
                        n.next = n.next.next;
                        System.out.println("Number " + num + " found and deleted.");
                        break;
                    }
                    n = n.next;
                }
            }
        }
    }

    public void deleteAllOccurrences(Node head, int num) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete " + num);
        } else {
            Node n = head;
            if ((int) n.data == num) {
                head = n.next;
                System.out.println("Number " + num + " found and deleted.");
            }
            while (n.next != null) {
                if ((int) n.next.data == num) {
                    n.next = n.next.next;
                    System.out.println("Number " + num + " found and deleted.");
                    if (n.next == null)
                        return;
                }
                n = n.next;
            }
        }
    }

    public void reverseIterative(Node head) {
        if (head == null || head.next == null) {
            System.out.println("List reversed iteratively.");
            return;
        }
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
        System.out.println("List reversed iteratively.");
    }

    public void reverseRecursive() {
        head = reverseUtil(head, null);
    }

    private Node reverseUtil(Node current, Node prev) {
        if (current.next == null) {
            head = current;
            current.next = prev;
            return head;
        }
        Node next = current.next;
        current.next = prev;
        return reverseUtil(next, current);
    }

    public int getSize() {
        if (head == null)
            return 0;
        int size = 1;
        Node temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void displaySize() {
        System.out.println("The size of the Linked List is: " + getSize());
    }

    public void nFromLast(int n) {
        Node slow = head;
        Node fast = head;
        int i = 0;
        while (i < n - 1) {
            if (fast.next == null) {
                System.out.println("Not enough elements in the list to find " + n + "th element from last.");
                return;
            } else {
                fast = fast.next;
                i++;
            }
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("Value at " + n + "th element from last is: " + slow.data);
    }

    public Node getMiddleElement(Node head) {
        if (head == null)
            return null;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayMiddleElement() {
        System.out.println("Middle element is: " + getMiddleElement(head).data);
    }

    public Node sort() {
        return mergeSort(head);
    }

    public Node sortedMerge(Node a, Node b) {
        Node result = null;

        if (a == null)
            return b;
        if (b == null)
            return a;

        if ((int) a.data <= (int) b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    private Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            Node mid = getMiddleElement(head);
            Node nextOfMid = mid.next;

            mid.next = null;

            Node left = mergeSort(head);
            Node right = mergeSort(nextOfMid);

            Node sortedList = sortedMerge(left, right);
            return sortedList;
        }
    }


    /*
    Displays until the null pointer is reached. Does not consider the head data member of Linked List class but rather uses the head pointer passed.
     */
    public void displayList(Node head) {
        if (head == null) {
            System.out.println("The list is empty. Nothing to Display.");
        } else {
            System.out.println("The contents of the List are: ");
            Node n = head;
            while (n.next != null) {
                System.out.print(n.data + "\t");
                n = n.next;
            }
            System.out.println(n.data + "");
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        Integer[] a = {1, -2, -3, 4, 5, -6, 7, -8};
        ll.appendArrayToFront(ll.head, a);
        ll.displayList(ll.head);
//        Node sortedListHead = ll.sort();
//        ll.displayList(sortedListHead);
//        ll.reverseRecursive();
//        ll.displayList(ll.head);
    }
}
