package entity;

public class User {
    private Integer userID;
    private String firstName;
    private String lastName;
    private String password;
    private roles userRole;

    public Integer getUserID() {
        return userID;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public User(String firstName, String lastName, String password, roles userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userRole = userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public roles getUserRole() {
        return userRole;
    }

    public void setUserRole(roles userRole) {
        this.userRole = userRole;
    }

    public User() {
    }
}
