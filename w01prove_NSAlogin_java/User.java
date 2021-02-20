package nsalogin;

public class User {

    private String password;
    private String salt;
    private String hashedPassword;

    // Non-default constructor to takes the user's initial password as a String
    public User(String inpPassword) {
        password = inpPassword;
    }

    //Public getters and setters for each variable
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public static void main(String[] args) {
    }

}