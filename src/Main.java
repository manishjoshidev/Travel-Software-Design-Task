public class Main {
    public static void main(String[] args) {
        // Initialize objects and set up initial state
        Passenger standardPassenger = new Passenger("Rahu", 1, 100.0, PassengerType.STANDARD);
        Activity swimmingActivity = new Activity();
        swimmingActivity.setName("Swimming");
        swimmingActivity.setCost(20.0);
        swimmingActivity.setDescription("2 hour 30-minute swimming with life jacket");

        Passenger premiumPassenger = new Passenger("Shani", 2, 100, PassengerType.PREMIUM);
        premiumPassenger.setName("kayaking");

//        premiumPassenger.setCost(50);
//        premiumPassenger.setDescription("1 hour kayaking");
        premiumPassenger.getName();


        // Call methods to perform specific tasks
        demonstrateSignUp(standardPassenger, swimmingActivity);
        printPassengerInfo(standardPassenger);
        printSignedUpActivities(standardPassenger);
    }

    private static void demonstrateSignUp(Passenger passenger, Activity activity) {
        boolean signedUp = passenger.signUpForActivity(activity);
        if (signedUp) {
            System.out.println("Signed up for " + activity.getName() +
                    ". Remaining balance: " + passenger.getBalance());
        } else {
            System.out.println("Failed to sign up. Insufficient balance.");
        }
    }

    private static void printPassengerInfo(Passenger passenger) {
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        System.out.println("Balance: " + passenger.getBalance());
    }

    private static void printSignedUpActivities(Passenger passenger) {
        passenger.printSignedUpActivities();
    }
}
