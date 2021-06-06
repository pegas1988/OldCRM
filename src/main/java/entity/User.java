package entity;

public class User {
    private Integer userID;
    private String firstname;
    private String lastName;
    private String password;
    private roles userRole;

    public Integer getUserID() {
        return userID;
    }

    public User(String firstname, String lastName) {
        this.firstname = firstname;
        this.lastName = lastName;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public User(String firstname, String lastName, String password, roles userRole) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.password = password;
        this.userRole = userRole;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
