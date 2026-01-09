import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProfileDAO profileDAO = new ProfileDAO();

        System.out.println("INSERT PROFILES");
        profileDAO.save(new Profile("alex"));
        profileDAO.save(new Profile("bakdaulet"));
        profileDAO.save(new Profile("koldock"));

        System.out.println("\nSELECT ALL PROFILES");
        List<Profile> profiles = profileDAO.findAll();
        for (Profile p : profiles) {
            System.out.println(p);
        }

        System.out.println("\nUPDATE PROFILE WITH ID = 1");
        profileDAO.update(1, "alex_updated");

        System.out.println("\nSELECT AFTER UPDATE");
        profiles = profileDAO.findAll();
        for (Profile p : profiles) {
            System.out.println(p);
        }

        System.out.println("\nDELETE PROFILE WITH ID = 2");
        profileDAO.delete(2);

        System.out.println("\nFINAL SELECT");
        profiles = profileDAO.findAll();
        for (Profile p : profiles) {
            System.out.println(p);
        }

        System.out.println("\nPROGRAM FINISHED SUCCESSFULLY");
    }
}
