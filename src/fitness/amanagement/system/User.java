package fitness.amanagement.system;

public class User {
    private int userId;
    private String name;
    private String email;

    public User(int userId, String name, String email, boolean active) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.active = active;
    }
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}