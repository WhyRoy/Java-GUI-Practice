package tables;

public class UserLoginInfo {
    private String userid;
    private String userpwd;
    private boolean useradmin;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public boolean isUseradmin() {
        return useradmin;
    }

    public void setUseradmin(boolean useradmin) {
        this.useradmin = useradmin;
    }
}
