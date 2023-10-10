public class ProbeNode {
    public Probe aProbe; //here is the link component
    public ProbeNode next; //here is the link component

    public ProbeNode(Probe aProbe) {
        this.aProbe = aProbe;
        this.next = null; // Initially, there's no next node'
    }

    public ProbeNode(ProbeNode aNode) {

    }

    public Probe getProbe() {
        return aProbe;
    }
}

