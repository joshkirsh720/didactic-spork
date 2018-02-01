

public class Bank {
    User[] users;

    public Bank() {
        users = new User[3];
    }
    public Bank(User[] u) {
        users = u;
    }

    public User logIn(String name, int pin) {
        for(User u : users) {
            if(name.equals(u.getName()) && pin == u.getPin()) return u;
        }

        return null;
    }
}