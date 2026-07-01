class SlotNode {
    int slotNumber;
    boolean booked;
    int startTime;
    int endTime;
    SlotNode next;

    SlotNode(int slotNumber) {
        this.slotNumber = slotNumber;
        this.booked = false;
        this.startTime = 0;
        this.endTime = 0;
        this.next = null;
    }
}
