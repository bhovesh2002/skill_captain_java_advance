package Day8;

public class UserData {
    private String username;
    private String password;
    private int timeLimit;

    public UserData(String username, String password, int limit){
        this.username = username;
        this.password = password;
        timeLimit = limit;
    }

    public void getDetails(){
        System.out.println("Username: " + username);
        System.out.println("Password" + password);
        System.out.println("Time the session lasted for: " + timeLimit);
    }
}
