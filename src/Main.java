import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total parking slots: ");
        int totalSlots = sc.nextInt();

        ParkingSystem system = new ParkingSystem(totalSlots);

        int choice;

        do {
            System.out.println("\n===== SMART PARKING SYSTEM =====");
            System.out.println("1. Show Available Slots");
            System.out.println("2. Book a Slot");
            System.out.println("3. Cancel Booking");
            System.out.println("4. For Damage Report,Emergency or Review");
            System.out.println("5. Exit");
            System.out.println("6. Add new Slot");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    system.showAvailableSlots();
                    break;

                case 2:
                    System.out.print("Enter Slot Number: ");
                    int slot = sc.nextInt();
                    System.out.print("Enter Start Time: ");
                    int start = sc.nextInt();
                    System.out.print("Enter End Time: ");
                    int end = sc.nextInt();
                    system.bookSlot(slot, start, end);
                    break;

                case 3:
                    System.out.print("Enter Slot Number: ");
                    int cancelSlot = sc.nextInt();
                    system.cancelBooking(cancelSlot);
                    break;

                case 4:
                    System.out.println("To report any damage :\n\tcontact 051 121 121 00 \nIn case of Emergency\n\tcontact 051 987 987 11 \nFor Suggestion or review \n\tLeave an Email at \"SMARTPARKERS@abc.com\" ");

                case 5:
                    System.out.println("Exiting system...");

                case 6 :
                    System.out.println("add a new slot ! ");
                    system.addNewParkingSlot();
                    break;


                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
