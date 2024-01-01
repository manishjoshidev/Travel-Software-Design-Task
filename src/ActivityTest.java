import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ActivityTest {

    @Test
    void addPassenger_ValidPassenger_Success() {
        Activity activity = new Activity();
        activity.setCapacity(2);

        Passenger passenger = new Passenger("John wick", 1, 100.0, PassengerType.STANDARD);

        activity.addPassenger(passenger);

        List<Passenger> passengers = activity.getPassengers();
        Assertions.assertTrue(passengers.contains(passenger));
    }

    @Test
    void addPassenger_CapacityReached_Failure() {
        Activity activity = new Activity();
        activity.setCapacity(1);

        Passenger passenger1 = new Passenger("John wick", 1, 100.0, PassengerType.STANDARD);
        Passenger passenger2 = new Passenger("Tom ", 2, 200.0, PassengerType.GOLD);

        activity.addPassenger(passenger1);
        activity.addPassenger(passenger2);

        List<Passenger> passengers = activity.getPassengers();
        Assertions.assertTrue(passengers.contains(passenger1));
        Assertions.assertFalse(passengers.contains(passenger2));
    }
}

class PassengerTest {

    @Test
    void signUpForActivity_StandardPassenger_Success() {
        Passenger passenger = new Passenger("Boby", 3, 150.0, PassengerType.STANDARD);
        Activity activity = new Activity();
        activity.setCost(30.0);

        boolean result = passenger.signUpForActivity(activity);

        Assertions.assertTrue(result);
        Assertions.assertTrue(passenger.getSignedUpActivities().contains(activity));
    }

    @Test
    void signUpForActivity_StandardPassengerInsufficientFunds_Failure() {
        Passenger passenger = new Passenger("Boby", 3, 10.0, PassengerType.STANDARD);
        Activity activity = new Activity();
        activity.setCost(30.0);

        boolean result = passenger.signUpForActivity(activity);

        Assertions.assertFalse(result);
        Assertions.assertFalse(passenger.getSignedUpActivities().contains(activity));
    }

    @Test
    void signUpForActivity_GoldPassenger_Success() {
        Passenger passenger = new Passenger("Boby", 3, 150.0, PassengerType.GOLD);
        Activity activity = new Activity();
        activity.setCost(30.0);

        boolean result = passenger.signUpForActivity(activity);

        Assertions.assertTrue(result);
        Assertions.assertTrue(passenger.getSignedUpActivities().contains(activity));
    }

    @Test
    void signUpForActivity_GoldPassengerInsufficientFunds_Failure() {
        Passenger passenger = new Passenger("Boby", 3, 10.0, PassengerType.GOLD);
        Activity activity = new Activity();
        activity.setCost(30.0);

        boolean result = passenger.signUpForActivity(activity);

        Assertions.assertFalse(result);
        Assertions.assertFalse(passenger.getSignedUpActivities().contains(activity));
    }
}

class DestinationTest {

    @Test
    void getActivities_ValidActivities_Success() {
        Destination destination = new Destination();
        List<Activity> activities = new ArrayList<>();
        Activity activity1 = new Activity();
        Activity activity2 = new Activity();
        activities.add(activity1);
        activities.add(activity2);

        destination.getActivities(activities);

        Assertions.assertEquals(2, destination.getActivities().size());
    }
}

class TravelPackageTest {

    @Test
    void setItinerary_ValidItinerary_Success() {
        TravelPackage travelPackage = new TravelPackage();
        List<Destination> itinerary = new ArrayList<>();
        Destination destination1 = new Destination();
        Destination destination2 = new Destination();
        itinerary.add(destination1);
        itinerary.add(destination2);

        travelPackage.setItinerary(itinerary);

        Assertions.assertEquals(2, travelPackage.getItinerary().size());
    }

    @Test
    void setPassengers_ValidPassengers_Success() {
        TravelPackage travelPackage = new TravelPackage();
        List<Passenger> passengers = new ArrayList<>();
        Passenger passenger1 = new Passenger("orton", 4, 180.0, PassengerType.GOLD);
        Passenger passenger2 = new Passenger("Brock", 5, 120.0, PassengerType.STANDARD);
        passengers.add(passenger1);
        passengers.add(passenger2);

        travelPackage.setPassengers(passengers);

        Assertions.assertEquals(2, travelPackage.getPassengers().size());
    }
}
