import java.util.ArrayList;

class SocialNetwork {
    private String name;
    private final ArrayList<Profile> profiles;

    public SocialNetwork(String name) {
        this.name = name;
        this.profiles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    @Override
    public String toString() {
        return "SocialNetwork: " + name + " | Profiles count: " + profiles.size();
    }
}
