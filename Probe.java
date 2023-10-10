public class Probe {
    private int destPort;
    private String originIP;
    private int originPort;
    private String probeTime;

    public Probe(int destPort, String originIP, int originPort, String probeTime) {
        this.destPort = destPort;
        this.originIP = originIP;
        this.originPort = originPort;
        this.probeTime = probeTime;
    }
    public int getDestPort() {
        return destPort;
    }

    public String getOriginIP() {
        return originIP;
    }
    public int getOriginPort() {
        return originPort;
    }

    public String getProbeTime() {
        return probeTime;
    }

}
