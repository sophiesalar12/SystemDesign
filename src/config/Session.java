package config;

public class Session {

    private static Session instance;

    private int id;
    private String role;
    private String status;
    private String name; 

    private Session() {}

    public static synchronized Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public static boolean isLoggedIn() {
        return instance != null;
    }

    public static void destroySession() {
        instance = null;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getname() { return name; }
    public void setname(String name) { this.name = name; }
}
