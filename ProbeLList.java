import java.util.ArrayList;
import java.util.Objects;

/**
 * CINETH MARAKAWATTE - OCT 21
 * Represents a linked list structure for storing Probe objects.
 */
public class ProbeLList {
    private ProbeNode head;
    private ProbeNode tail;
    private int length;

    /**
     * Checks if the linked list is empty.
     *
     * return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }


    /**
     * Default constructor for initializing an empty linked list.
     */
    public ProbeLList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Copy constructor for creating a deep copy of another ProbeLList object.
     *
     *  aList The source linked list to copy from.
     */
    public ProbeLList(ProbeLList aList) {

        this.length = aList.length;
        if (aList.isEmpty()) {
            this.head = null;
            this.tail = null;
        } else {

            this.head = new ProbeNode(aList.head.aProbe);

            ProbeNode copyList = this.head;
            ProbeNode originalList = aList.head;

            while (originalList.next != null) {
                copyList.next = new ProbeNode(originalList.next.aProbe);
                originalList = originalList.next;
                copyList = copyList.next;

                this.tail = originalList;
                length++;

            }

        }

    }
    /**
     * Recursive method to calculate the length of the linked list.
     *
     *  node The starting node for counting.
     * return The length of the list from the provided node to the end.
     */

    private int getActualSz(ProbeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + getActualSz(node.getNext());
    }
    /**
     * Inserts a new Probe object into the linked list.
     *
     *  probe The Probe object to be inserted.
     * return The position where the probe was added.
     */
    public int insertProbe(Probe probe) {

        ProbeNode newLink = new ProbeNode(probe);

        if (this.isEmpty()) {
            this.head = newLink;
        } else {
            ProbeNode current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newLink;
        }

        this.length += 1;

        return this.length;
    }
    /**
     * Counts the number of probes that originate from a specific IP address.
     *
     *  ip The source IP address.
     * return The number of probes from the specified IP.
     */
    public int countProbes(String ip) {
        int count = 0;
        ProbeNode current = head;


        while (current != null) {
            if (current.aProbe.getOriginIP().equals(ip)) {
                count++;
            }
            current = current.next;

        }

        return count;
    }
    /**
     * Counts the number of probes targeting a specific destination port.
     *
     *  destPort The destination port.
     * return The number of probes to the specified port.
     */
    public int countProbes(int destPort) {
        int count = 0;
        ProbeNode current = head;


        while (current != null) {
            if (current.aProbe.getDestPort() == destPort) {
                count++;
            }
            current = current.next;

        }

        return count;
    }
    /**
     * Retrieves a list of source IP addresses that probed a specific destination port.
     *
     *  destPort The destination port to check.
     * return A list of source IP addresses that probed the specified port.
     */
    public ArrayList<String> getProbers(int destPort) {

        ArrayList<String> portArrayList = new ArrayList<>();

        ProbeNode current = head;

        while (current != null) {

            if (current.aProbe.getDestPort() == destPort && !portArrayList.contains(current.aProbe.getOriginIP())) {

                portArrayList.add(current.aProbe.getOriginIP());
            }

            current = current.next;
        }


        return portArrayList;
    }

    /**
     * Retrieves a list of Probe objects that originate from a specific IP address.
     *
     *  ip The source IP address.
     * return A list of Probe objects from the specified IP.
     */
    public ArrayList<Probe> getProbers(String ip) {
        ArrayList<Probe> probeList = new ArrayList<>();

        ProbeNode current = head;

        while (current != null) {

            if (Objects.equals(current.aProbe.getOriginIP(), ip)) {

                probeList.add(current.aProbe);
            }

            current = current.next;
        }

        return probeList;
    }
    /**
     * Retrieves a list of ports scanned by packets originating from a specific IP address.
     *
     *  ip The source IP address.
     * return A list of destination ports scanned by the specified IP.
     */
    public ArrayList<Integer> getPortsScannedByIP(String ip) {
        ArrayList<Probe> probesByIP = getProbers(ip);
        ArrayList<Integer> ports = new ArrayList<>();

        for (Probe probe : probesByIP) {
            if (!ports.contains(probe.getDestPort())) {
                ports.add(probe.getDestPort());
            }
        }

        return ports;
    }





}
