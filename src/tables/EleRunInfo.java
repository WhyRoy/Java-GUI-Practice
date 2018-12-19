package tables;

public class EleRunInfo {
    private String eleid;
    private boolean eleisrunning;
    private int elerunningtime;
    private String eleerrormsg;

    public String getEleid() {
        return eleid;
    }

    public void setEleid(String eleid) {
        this.eleid = eleid;
    }

    public boolean isEleisrunning() {
        return eleisrunning;
    }

    public void setEleisrunning(boolean eleisrunning) {
        this.eleisrunning = eleisrunning;
    }

    public int getElerunningtime() {
        return elerunningtime;
    }

    public void setElerunningtime(int elerunningtime) {
        this.elerunningtime = elerunningtime;
    }

    public String getEleerrormsg() {
        return eleerrormsg;
    }

    public void setEleerrormsg(String eleerrormsg) {
        this.eleerrormsg = eleerrormsg;
    }
}
