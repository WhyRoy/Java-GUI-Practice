package tables;

import java.sql.Date;

public class EleInfo {
    private String eleid;
    private String eletype;
    private Date elecreatedate;
    private String elerange;
    private String eleaddress;
    private Date elelastmtdate;

    public String getEleid() {
        return eleid;
    }

    public void setEleid(String eleid) {
        this.eleid = eleid;
    }

    public String getEletype() {
        return eletype;
    }

    public void setEletype(String eletype) {
        this.eletype = eletype;
    }

    public Date getElecreatedate() {
        return elecreatedate;
    }

    public void setElecreatedate(Date elecreatedate) {
        this.elecreatedate = elecreatedate;
    }

    public String getElerange() {
        return elerange;
    }

    public void setElerange(String elerange) {
        this.elerange = elerange;
    }

    public String getEleaddress() {
        return eleaddress;
    }

    public void setEleaddress(String eleaddress) {
        this.eleaddress = eleaddress;
    }

    public Date getElelastmtdate() {
        return elelastmtdate;
    }

    public void setElelastmtdate(Date elelastmtdate) {
        this.elelastmtdate = elelastmtdate;
    }
}
