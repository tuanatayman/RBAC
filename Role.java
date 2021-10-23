import java.util.ArrayList;

class Role {
    String name;
    ArrayList<User> users_list = new ArrayList<User>();
    ArrayList<Authorisation> auth_list = new ArrayList<Authorisation>();

    public Role(String n, ArrayList<Authorisation> a_l) {
        name = n;
        auth_list = a_l;
    }

    public void addUser(User u) {
        users_list.add(u);
    }

    public boolean isUserInRole(User user, String action, String file) {
        // check if there's authorisation with associated file
        boolean autorized = false;
        for (int i = 0; i < auth_list.size(); i++) {
            if (auth_list.get(i).action == action && auth_list.get(i).file == file) {
                autorized = true;
            }
        }
        if (users_list.contains(user)) {
            if (autorized) {
                return true;
            } else {
                user.blocked = true;
                // System.out.print(user.userName);
                // System.out.print(" is blocked : ");
                // System.out.println(user.blocked);
                this.update();

            }
        }
        // should either return error | notify monitor | add -> not in the subject
        return false;
    }

    public void update() {
        for (int i = 0; i < users_list.size(); i++) {
            if (users_list.get(i).blocked == true) {
                users_list.remove(i);
            }
        }
    }
}