/**
 * CINETH MARAKAWATTE - OCT 21
 * Represents a node in a linked list of {@code Probe} objects.
 */
public class ProbeNode {

    /** The data part of the node, containing a probe. */
    public Probe aProbe;

    /** Link to the next node in the linked list. */
    public ProbeNode next;

    /**
     * Constructs a new node with the provided {@code Probe} object.
     *
     *  aProbe The probe data to be stored in this node.
     */
    public ProbeNode(Probe aProbe) {
        this.aProbe = aProbe;
        this.next = null;
    }

    /**
     * Creates a deep copy of the provided {@code ProbeNode}.
     *
     *  aNode The node from which a deep copy should be created.
     */
    public ProbeNode(ProbeNode aNode) {

        this.aProbe = new Probe(aNode.aProbe.getDestPort(), aNode.aProbe.getOriginIP(), aNode.aProbe.getOriginPort(), aNode.aProbe.getProbeTime());
        this.next = null;
    }

    /**
     * return The next node in the linked list.
     */
    public ProbeNode getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node in the linked list.
     *
     *  nextNode The node to be set as the next node.
     */
    public void setNext(ProbeNode nextNode) {
        this.next = nextNode;
    }

    /**
     * Test the functionality of the {@code ProbeNode} and {@code ProbeLList} classes.
     *
     *  args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        ProbeLList list = new ProbeLList();
        list.insertProbe(new Probe(5060, "162.214.2.121", 5077, "2015-12-05(16:24:33)"));
        System.out.println(list.countProbes("162.214.2.121")); // 1
        System.out.println(list.countProbes(5060)); // 1
    }
}
