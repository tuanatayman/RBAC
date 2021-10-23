
public class User {
    String userName;
    String userLastName;
    boolean blocked = false;
    Role role;

    public User(String name, String lastname, Role r) {
        this.userName = name;
        this.userLastName = lastname;
        this.role = r;
    }

    public void ask_access(String action, String file) {
        Monitor monitor = new Monitor(this.role);
        boolean response = monitor.canAccess(this, action, file);
        if (response) {
            System.out.println("acess granted");
        } else {
            System.out.println("acess denied");
        }
    }
}
