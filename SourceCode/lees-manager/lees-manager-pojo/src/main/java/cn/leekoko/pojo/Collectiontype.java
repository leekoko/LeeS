package cn.leekoko.pojo;

public class Collectiontype {
    private Integer id;

    private String typename;

    private Integer delflag;

    private String tsm1;

    private String tsm2;

    private String tsm3;

    private String tsm4;

    private String tsm5;

    private String tsm6;

    private String createdate;

    private String modifydate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
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

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getModifydate() {
        return modifydate;
    }

    public void setModifydate(String modifydate) {
        this.modifydate = modifydate == null ? null : modifydate.trim();
    }
}