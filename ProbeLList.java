public class ProbeLList {
    private ProbeNode head; //here is the link component
    private ProbeNode tail; //here is the link component
    private int length;
    public ProbeLList(){

    }

    public ProbeLList(ProbeLList aList) {
        length = aList.length;
        if (aList.isEmpty()) {
            this.head = null;
            this.length = 0; // empty list
        } else {
            this.head = new ProbeNode(aList.head.getValue()); //copy first value of original list to new list first value
            ProbeNode currentThis = this.head;

            for (ProbeNode currentOther  = aList.head; currentOther!= null; currentThis = currentThis.next) {
                currentThis.next = new ProbeNode(currentOther.next.value);
                currentOther = currentOther.next;
            }

    }


}
