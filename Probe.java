/**
 * CINETH MARAKAWATTE - OCT 21
 * Represents a network probe, containing information about the origin IP,
 * destination port, origin port, and the time of the probe.
 */
public class Probe {

    private int destPort;
    private String originIP;
    private int originPort;
    private String probeTime;

    /**
     * Constructs a new Probe object.
     *
     *  destPort   The destination port of the probe.
     *  originIP   The origin IP address from where the probe was sent.
     *  originPort The origin port from where the probe was sent.
     *  probeTime  The time at which the probe occurred.
     */
    public Probe(int destPort, String originIP, int originPort, String probeTime) {
        this.destPort = destPort;
        this.originIP = originIP;
        this.originPort = originPort;
        this.probeTime = probeTime;
    }

    /**
     * return The destination port of the probe.
     */
    public int getDestPort() {
        return destPort;
    }

    /**
     * return The origin IP address from where the probe was sent.
     */
    public String getOriginIP() {
        return originIP;
    }

    /**
     * return The origin port from where the probe was sent.
     */
    public int getOriginPort() {
        return originPort;
    }

    /**
     * return The time at which the probe occurred.
     */
    public String getProbeTime() {
        return probeTime;
    }

    /**
     * Test the functionality of the Probe class.
     *
     *  args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Probe probe1 = new Probe(5060, "162.214.2.121", 5077, "2015-12-05(16:24:33)");
        ProbeNode node1 = new ProbeNode(probe1);
        ProbeNode node2 = new ProbeNode(node1);
        System.out.println(node2.aProbe.getOriginIP());
        System.out.println(node2.getNext()); // Should be null
    }
}
