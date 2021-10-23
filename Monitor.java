public class Monitor {
    Role r1;

    public Monitor(Role r) {
        r1 = r;
    }

    public boolean canAccess(User user, String action, String file) {
        boolean result = r1.isUserInRole(user, action, file);
        return result;
    }
}
