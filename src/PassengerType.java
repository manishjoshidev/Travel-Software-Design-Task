import java.util.ArrayList;
import java.util.List;

enum PassengerType {
    STANDARD, GOLD, PREMIUM
}

class Passenger {
    private String name;
    private final int passengerNumber;
    private double balance;
    private final PassengerType passengerType;
    private final List<Activity> signedUpActivities;

    public Passenger(String name, int passengerNumber, double balance, PassengerType passengerType) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.passengerType = passengerType;
        this.signedUpActivities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public int getPassengerNumber() {
        return passengerNumber;
    }
    public double getBalance() {
        return balance;
    }


    public PassengerType getPassengerType() {
        return passengerType;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    public boolean signUpForActivity(Activity activity) {
        return switch (passengerType) {
            case STANDARD -> signUpForStandard(activity);
            case GOLD -> signUpForGold(activity);
            case PREMIUM -> signUpForPremium(activity);
            default -> false;
        };
    }

    private boolean signUpForStandard(Activity activity) {
        if (balance >= activity.getCost()) {
            balance -= activity.getCost();
            signedUpActivities.add(activity);
            return true;
        } else {
            return false;
        }
    }

    private boolean signUpForGold(Activity activity) {
        double discountedCost = 0.9 * activity.getCost();
        if (balance >= discountedCost) {
            balance -= discountedCost;
            signedUpActivities.add(activity);
            return true;
        } else {
            return false;
        }
    }

    private boolean signUpForPremium(Activity activity) {
        signedUpActivities.add(activity);
        System.out.println("Premium passenger " + name + " signed up for activity: " + activity.getName());
        return true;
    }

    public void printSignedUpActivities() {
        System.out.println("Signed-up activities for " + name);
        for (Activity activity : signedUpActivities) {
            System.out.println("Activity: " + activity.getName() +
                    ", Cost: " + activity.getCost());
        }
    }

    private double calculatePricePaid(Activity activity) {
        return switch (passengerType) {
            case STANDARD -> activity.getCost();
            case GOLD -> 0.9 * activity.getCost();
            case PREMIUM -> 0;
            default -> 0;
        };
    }
}
