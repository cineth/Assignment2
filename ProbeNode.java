public class ProbeNode {
    public Probe aProbe; //here is the link component
    public ProbeNode next; //here is the link component

    public ProbeNode(Probe aProbe) {
        this.aProbe = aProbe;
        this.next = null; // Initially, there's no next node'
    }

    public ProbeNode(ProbeNode aNode) {
        // Create a deep copy of the Probe object from the existing node
        // note: this.aProbe = aNode.aProbe; makes a shallow copy meaning all nodes will reference the same Probe object
        this.aProbe = new Probe(aNode.getProbe().getDestPort(), aNode.getProbe().getOriginIP(), aNode.getProbe().getOriginPort(), aNode.getProbe().getProbeTime());

        // Since this is a new node in the list, set the next reference to null
        this.next = null;
    }

    public Probe getProbe() {
        return aProbe;
    }

    public ProbeNode getNext() {
        return next;
    }

    // Method to set the next node in the list
    public void setNext(ProbeNode nextNode) {
        this.next = nextNode;
    }


}

