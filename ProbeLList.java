public class ProbeLList {
    private ProbeNode head; //here is the link component
    private ProbeNode tail; //here is the link component
    public ProbeLList(){

    }

    public ProbeLList(ProbeLList aList) {
    this.head = aList.head;
    this.tail = aList.tail;
    }

}
