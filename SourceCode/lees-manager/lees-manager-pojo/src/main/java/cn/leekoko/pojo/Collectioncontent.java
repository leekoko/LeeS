package cn.leekoko.pojo;

import java.util.Date;

public class Collectioncontent {
    private String id;

    private Integer parentid;

    private String imgurl;

    private String title;

    private String intro;

    private String pageurl;

    private Date clickdate;

    private Integer delflag;

    private String tsm1;

    private String tsm2;

    private String tsm3;

    private String tsm4;

    private String tsm5;

    private String tsm6;

    private String createdate;

    private String modifydate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl == null ? null : pageurl.trim();
    }

    public Date getClickdate() {
        return clickdate;
    }

    public void setClickdate(Date clickdate) {
        this.clickdate = clickdate;
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