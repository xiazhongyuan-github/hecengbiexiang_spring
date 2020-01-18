package com.hitachi.elderly.bean;



import java.util.List;

/**
* @ClassName: AccessToken
* @Description: JWT的Token类
* @Author: lizhe
* @Date: 2018/9/4
*/
public class AccessToken {
    private String access_token;
    private String token_type;
    private long expires_in;
    private String userCode;
    private String userName;
    private int userLevel;
    private String userStreet;
    private List<String> userOrganization;
    private String lc_seats; //小灵呼坐席号
    private String userVillage;
    private List<Integer> userOrganization_category;
    private String contact_number;

    public String getLc_seats() {
        return lc_seats;
    }

    public void setLc_seats(String lc_seats) {
        this.lc_seats = lc_seats;
    }

    public String getUserStreet() {
        return userStreet;
    }

    public void setUserStreet(String userStreet) {
        this.userStreet = userStreet;
    }

    public List<String> getUserOrganization() {
        return userOrganization;
    }

    public void setUserOrganization(List<String> userOrganization) {
        this.userOrganization = userOrganization;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserVillage() {
        return userVillage;
    }

    public void setUserVillage(String userVillage) {
        this.userVillage = userVillage;
    }

    public List<Integer> getUserOrganization_category() {
        return userOrganization_category;
    }

    public void setUserOrganization_category(List<Integer> userOrganization_category) {
        this.userOrganization_category = userOrganization_category;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }
}
