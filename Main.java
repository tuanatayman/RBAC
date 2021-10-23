import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String fileName = "myFile.txt";
        String[] actions = { "read", "write" };
        Authorisation readPersoFile = new Authorisation("readPersoFile", actions[0], fileName);
        ArrayList<Authorisation> auth_list = new ArrayList<Authorisation>();
        auth_list.add(readPersoFile);

        Role baseRole = new Role("baseRole", auth_list);
        User user1 = new User("James", "Gosling", baseRole);
        baseRole.addUser(user1);
        user1.ask_access("read", fileName);
        // user1.ask_access("write", fileName);
    }
}
