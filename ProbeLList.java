public class ProbeLList {
    private ProbeNode head;
    private ProbeNode tail;
    private int length;

    public boolean isEmpty() {
        return (head == null);
    }

    // Constructor
    public ProbeLList() {
        this.head = null;
        this.length = 0;
    }

    // Copy constructor
    // from lab 3
    public ProbeLList(ProbeLList aList) {

        this.length = aList.length;
        if (aList.isEmpty()) {
            this.head = null;
        } else {
            this.head = new ProbeNode(aList.head.aProbe);

            ProbeNode copyList = this.head;
            ProbeNode originalList = aList.head;

            while (originalList.next != null) {
                copyList.next = new ProbeNode(originalList.next.aProbe);
                originalList = originalList.next;
                copyList = copyList.next;

                this.tail = originalList; // Update the tail as you copy nodes
                length++; // Increment the length for each copied node

            }

        }

    }

    // Recursive method to calculate the length of the linked list
    private int getActualSz(ProbeNode node) {
        // If the current node is null, return 0
        if (node == null) {
            return 0;
        }

        // Recursive case: Add 1 and recursively calculate the length of the rest of the list
        return 1 + getActualSz(node.getNext());
    }

    public int insertProbe(Probe probe) {

        ProbeNode newLink = new ProbeNode(probe); // Create a new ProbeNode called 'newLink' containing the provided 'probe'.

        if (this.isEmpty()) {
            this.head = newLink; // If the linked list is empty, set the 'head' to the new 'newLink'.
        } else {
            ProbeNode current = this.head; // If the linked list is not empty, start traversing the list from the 'head'.

            while (current.next != null) {
                current = current.next; // Loop until you find the last node (the node with no 'next' reference).
            }

            current.next = newLink; // Set the 'next' of the current last node to 'newLink', effectively adding it to the end.
        }

        this.length += 1; // Increment the length attribute to keep track of the number of nodes in the list.

        return this.length; // Return the position (equivalent to the length) where the 'probe' was added.
    }

    public int countProbes(String ip) {
        int count = 0;  // number of matching probes
        ProbeNode current = head;  // Start from the head of the list

        // Iterate through the linked list
        while (current != null) {
            if (current.aProbe.getOriginIP().equals(ip)) {
                count++;  // If the origin IP of the current probe matches the entered IP, increase the count
            }
            current = current.next;  // Move to the next node

        }

        return count;
    }

    public int countProbes(int destPort) {
        int count = 0;  // number of matching probes
        ProbeNode current = head;  // Start from the head of the list

        // Iterate through the linked list
        while (current != null) {
            if (current.aProbe.getDestPort() == destPort) {
                count++;  // If the destination IP of the current probe matches the entered IP, increase the count
            }
            current = current.next;  // Move to the next node

        }

        return count;
    }
}
