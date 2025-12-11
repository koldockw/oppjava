import java.util.ArrayList;

class Post {
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
    public String toString() {
        return "Post: " + title;
    }
}

class Profile {
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
    public String toString() {
        return "Profile: " + username;
    }
}

class SocialNetwork {
    private String name;
    private ArrayList<Profile> profiles;

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

public class Main {
    public static void main(String[] args) {
        Profile p1 = new Profile("bakdaulet");
        Profile p2 = new Profile("koldock");

        Post post1 = new Post("First Post");
        Post post2 = new Post("Second Post");

        SocialNetwork sn = new SocialNetwork("instagram");
        sn.addProfile(p1);
        sn.addProfile(p2);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(post1);
        System.out.println(post2);
        System.out.println(sn);
    }
}
