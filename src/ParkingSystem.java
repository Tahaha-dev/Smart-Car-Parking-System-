class ParkingSystem {

    SlotNode slotsHead;

    // cntrctr
    ParkingSystem(int totalSlots) {
        slotsHead = initializeSlots(totalSlots);    // user se slot size leke ll ka size fix krein gai
    }

    // LL
    SlotNode initializeSlots(int totalSlots) {      // user ka diya hua size pass kia

        SlotNode head = null;
        SlotNode tail = null;

        for (int i = 1; i <= totalSlots; i++) {   // loop size k hisab se run hoti rhegi

            SlotNode newSlot = new SlotNode(i);

            if (head == null) {         // ager already head null ho , tou new slot hi head hogi
                head = newSlot;
                tail = newSlot;
            } else {
                tail.next = newSlot;   // ager already eik head exisit ker raha hai tou head ki tail pe hum eik slot ( new node ) add ker dein gai aur abh se link list ki tail hi new node hogi
                tail = newSlot;
            }
        }
        return head;
    }

    // Isse free slots show hongi
    void showAvailableSlots() {

        SlotNode current = slotsHead;

        while (current != null) {           // jubh tk last slot tk na pohnch jayein loop run hoti rahegi
            if (!current.booked) {          // jahan pe hume booked ka section false mille hum woh node output mei de dein gai
                System.out.println("Slot " + current.slotNumber + " is FREE");
            }
            current = current.next;         // temporary variable ko agai move kraya
        }
    }

    // koi bhi slot , number se find kernai k liyain
    SlotNode findSlot(int slotNumber) {

        SlotNode current = slotsHead;

        while (current != null) {
            if (current.slotNumber == slotNumber) {     // jahan pe bhi user ka diya hua input slot number mille usse output mai print ker diya
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // for slot Booking
    void bookSlot(int slotNumber, int startTime, int endTime) {

        SlotNode slot = findSlot(slotNumber);

        if (slot == null) {
            System.out.println("Invalid slot number");
            return;
        }

        if (slot.booked) {
            System.out.println("Slot already booked");
            return;
        }

        slot.booked = true;                 // jubh sari conditions match ho jayein tou hum uss specified slot ki booking ko true ker dein gai so that dubara koi aur na book kre
        slot.startTime = startTime;         // start aur end time user ka dia hua hum yahan pass ker dein gai
        slot.endTime = endTime;

        System.out.println("Slot booked successfully");
    }



    // Cancel booking
    void cancelBooking(int slotNumber) {

        SlotNode slot = findSlot(slotNumber);

        if (slot == null) {
            System.out.println("Invalid slot number");
            return;
        }

        if (!slot.booked) {
            System.out.println("Slot is already free");
            return;
        }

        slot.booked = false;            // booking ko false ker dein gai means slot abh dubaara se available slots mai show hogi
        slot.startTime = 0;             // time bhi reset ker diya
        slot.endTime = 0;

        System.out.println("Booking cancelled successfully");
    }
    void addNewParkingSlot() {

        SlotNode newSlot;
        SlotNode current = slotsHead;
        int lastSlotNumber = 0;

        // agar list empty ho
        if (slotsHead == null) {
            slotsHead = new SlotNode(1);
            System.out.println("New parking slot added: Slot 1");
            return;
        }

        // last node tak janai k liyain
        while (current.next != null) {
            current = current.next;
        }

        lastSlotNumber = current.slotNumber;

        // new slot create karna
        newSlot = new SlotNode(lastSlotNumber + 1);

        // last node ke sath attach karna
        current.next = newSlot;

        System.out.println("New parking slot added: Slot " + newSlot.slotNumber);
    }

}
