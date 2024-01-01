import java.util.List;

class Destination {
    private String name;
    private List<Activity> activities;

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void getActivities(List<Activity> activities) {
        this.activities = activities;
    }
        public void setActivities(List<Activity> activities) {
            this.activities = activities;
        }
    }

