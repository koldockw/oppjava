import java.util.ArrayList;
import java.util.Objects;
import java.util.Comparator;

abstract class Entity {
    public abstract String getInfo();
}

class Post extends Entity {
    private String title;

    public Post(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getInfo() {
        return "Post title: " + title;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

class Profile extends Entity {
    private String username;

    public Profile(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getInfo() {
        return "Profile username: " + username;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return Objects.equals(username, profile.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}

class SocialNetwork {
    private String name;
    private ArrayList<Profile> profiles;

    public SocialNetwork(String name) {
        this.name = name;
        this.profiles = new ArrayList<>();
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public Profile findProfileByUsername(String username) {
        for (Profile p : profiles) {
            if (p.getUsername().equalsIgnoreCase(username)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Profile> filterProfilesByPrefix(String prefix) {
        ArrayList<Profile> result = new ArrayList<>();
        for (Profile p : profiles) {
            if (p.getUsername().startsWith(prefix)) {
                result.add(p);
            }
        }
        return result;
    }

    public void sortProfilesByUsername() {
        profiles.sort(Comparator.comparing(Profile::getUsername));
    }

    @Override
    public String toString() {
        return "SocialNetwork: " + name + ", profiles count: " + profiles.size();
    }
}

public class Main {
    public static void main(String[] args) {

        SocialNetwork sn = new SocialNetwork("Instagram");

        Profile p1 = new Profile("bakdaulet");
        Profile p2 = new Profile("koldock");
        Profile p3 = new Profile("alex");

        sn.addProfile(p1);
        sn.addProfile(p2);
        sn.addProfile(p3);

        Post post1 = new Post("First Post");
        Post post2 = new Post("Second Post");

        System.out.println(post1);
        System.out.println(post2);

        for (Profile p : sn.getProfiles()) {
            System.out.println(p);
        }

        System.out.println(sn.findProfileByUsername("alex"));

        sn.sortProfilesByUsername();
        for (Profile p : sn.getProfiles()) {
            System.out.println(p);
        }
    }
}
