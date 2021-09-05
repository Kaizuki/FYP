package Models;

public class User {
    private int userId;
    private String userName;
    private String userPass;
    private String userRole;
    private Enum userTask;

    public User() {
    }

    public User(int userId, String userName, String userPass, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.userRole = userRole;
    }
    
    
    public User(String userName, String userPass, String userRole) {
        this.userName = userName;
        this.userPass = userPass;
        this.userRole = userRole;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return this.userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", userPass='" + getUserPass() + "'" +
            "}";
    }
     
}
