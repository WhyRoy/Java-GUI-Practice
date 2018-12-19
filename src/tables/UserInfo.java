package tables;

public class UserInfo {
    private String userid;
    private String username;
    private boolean useradmin;
    private String userrange;
    private boolean useronline;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isUseradmin() {
        return useradmin;
    }

    public void setUseradmin(boolean useradmin) {
        this.useradmin = useradmin;
    }

    public String getUserrange() {
        return userrange;
    }

    public void setUserrange(String userrange) {
        this.userrange = userrange;
    }

    public boolean isUseronline() {
        return useronline;
    }

    public void setUseronline(boolean useronline) {
        this.useronline = useronline;
    }
}
