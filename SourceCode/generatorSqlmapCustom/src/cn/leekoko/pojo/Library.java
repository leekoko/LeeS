package cn.leekoko.pojo;

import java.util.Date;

public class Library {
    private Integer id;

    private String seatnum;

    private String currentuser;

    private Integer delflag;

    private Integer currflag;

    private Date sittime;

    private Date letouttimea;

    private Date letouttimeb;

    private String floor;

    private String area;

    private String tsm1;

    private String tsm2;

    private String tsm3;

    private String tsm4;

    private String tsm5;

    private String tsm6;

    private String tsm7;

    private String tsm8;

    private String tsm9;

    private String letouttype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(String seatnum) {
        this.seatnum = seatnum == null ? null : seatnum.trim();
    }

    public String getCurrentuser() {
        return currentuser;
    }

    public void setCurrentuser(String currentuser) {
        this.currentuser = currentuser == null ? null : currentuser.trim();
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    public Integer getCurrflag() {
        return currflag;
    }

    public void setCurrflag(Integer currflag) {
        this.currflag = currflag;
    }

    public Date getSittime() {
        return sittime;
    }

    public void setSittime(Date sittime) {
        this.sittime = sittime;
    }

    public Date getLetouttimea() {
        return letouttimea;
    }

    public void setLetouttimea(Date letouttimea) {
        this.letouttimea = letouttimea;
    }

    public Date getLetouttimeb() {
        return letouttimeb;
    }

    public void setLetouttimeb(Date letouttimeb) {
        this.letouttimeb = letouttimeb;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getTsm1() {
        return tsm1;
    }

    public void setTsm1(String tsm1) {
        this.tsm1 = tsm1 == null ? null : tsm1.trim();
    }

    public String getTsm2() {
        return tsm2;
    }

    public void setTsm2(String tsm2) {
        this.tsm2 = tsm2 == null ? null : tsm2.trim();
    }

    public String getTsm3() {
        return tsm3;
    }

    public void setTsm3(String tsm3) {
        this.tsm3 = tsm3 == null ? null : tsm3.trim();
    }

    public String getTsm4() {
        return tsm4;
    }

    public void setTsm4(String tsm4) {
        this.tsm4 = tsm4 == null ? null : tsm4.trim();
    }

    public String getTsm5() {
        return tsm5;
    }

    public void setTsm5(String tsm5) {
        this.tsm5 = tsm5 == null ? null : tsm5.trim();
    }

    public String getTsm6() {
        return tsm6;
    }

    public void setTsm6(String tsm6) {
        this.tsm6 = tsm6 == null ? null : tsm6.trim();
    }

    public String getTsm7() {
        return tsm7;
    }

    public void setTsm7(String tsm7) {
        this.tsm7 = tsm7 == null ? null : tsm7.trim();
    }

    public String getTsm8() {
        return tsm8;
    }

    public void setTsm8(String tsm8) {
        this.tsm8 = tsm8 == null ? null : tsm8.trim();
    }

    public String getTsm9() {
        return tsm9;
    }

    public void setTsm9(String tsm9) {
        this.tsm9 = tsm9 == null ? null : tsm9.trim();
    }

    public String getLetouttype() {
        return letouttype;
    }

    public void setLetouttype(String letouttype) {
        this.letouttype = letouttype == null ? null : letouttype.trim();
    }
}