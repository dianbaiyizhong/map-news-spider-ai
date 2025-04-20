package com.nntk.mapnews.mp.generate.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author nntk
 * @since 2025-04-20
 */
@TableName("t_user")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 生成ID
     */
    private Long id;

    private String nickName;

    /**
     * 电话号码
     */
    private String phoneNum;

    /**
     * 推送的id，例如在leancloud中就是installationId
     */
    private String pushId;

    /**
     * 是否开启定位共享 0代表不开  1代表开启
     */
    private Byte isShowLoc;

    /**
     * 我的一句话介绍
     */
    private String myIntro;

    /**
     * 0代表女 1代表男 -1代表保密
     */
    private Byte sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 用户信息修改时间
     */
    private LocalDateTime gmtModified;

    /**
     * 上一次登陆时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 上一次注销时间
     */
    private LocalDateTime lastLogoutTime;

    /**
     * -1代表被禁止
     */
    private Integer status;

    /**
     * 这个时间一出现，说明用户已经被禁止登陆
     */
    private LocalDateTime nextLoginTime;

    /**
     * 即时通信的注册ID号
     */
    private String nimId;

    private String userWallBg;

    private String userWallVideo;

    /**
     * 粉丝数
     */
    private Integer followerCount;

    /**
     * 关注数
     */
    private Integer followeeCount;

    /**
     * 赞成数
     */
    private Integer approvalCount;

    /**
     * 收藏数
     */
    private Integer collectCount;

    /**
     * 问题有用数
     */
    private Integer usefulQuestionCount;

    /**
     * 回答有用数
     */
    private Integer usefulAnswerCount;

    /**
     * 人气
     */
    private Integer popularity;

    private Double lat;

    private Double lng;

    private String posInfo;

    /**
     * 所在城市
     */
    private String city;

    private LocalDateTime geoGmtModified;

    /**
     * 是否是机器人
     */
    private Byte robot;

    /**
     * 登陆设备名称
     */
    private String deviceName;

    /**
     * 登陆设备id
     */
    private String deviceId;

    private String ip;

    private String deviceMac;

    /**
     * 设备系统版本号，如Android9
     */
    private String deviceOsVersion;

    /**
     * 当前app版本号
     */
    private String currentAppVersion;

    /**
     * 支付宝账号
     */
    private String alipayAccount;

    /**
     * 支付宝账号下所绑定的姓名
     */
    private String alipayName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public Byte getIsShowLoc() {
        return isShowLoc;
    }

    public void setIsShowLoc(Byte isShowLoc) {
        this.isShowLoc = isShowLoc;
    }

    public String getMyIntro() {
        return myIntro;
    }

    public void setMyIntro(String myIntro) {
        this.myIntro = myIntro;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public LocalDateTime getLastLogoutTime() {
        return lastLogoutTime;
    }

    public void setLastLogoutTime(LocalDateTime lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getNextLoginTime() {
        return nextLoginTime;
    }

    public void setNextLoginTime(LocalDateTime nextLoginTime) {
        this.nextLoginTime = nextLoginTime;
    }

    public String getNimId() {
        return nimId;
    }

    public void setNimId(String nimId) {
        this.nimId = nimId;
    }

    public String getUserWallBg() {
        return userWallBg;
    }

    public void setUserWallBg(String userWallBg) {
        this.userWallBg = userWallBg;
    }

    public String getUserWallVideo() {
        return userWallVideo;
    }

    public void setUserWallVideo(String userWallVideo) {
        this.userWallVideo = userWallVideo;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    public Integer getFolloweeCount() {
        return followeeCount;
    }

    public void setFolloweeCount(Integer followeeCount) {
        this.followeeCount = followeeCount;
    }

    public Integer getApprovalCount() {
        return approvalCount;
    }

    public void setApprovalCount(Integer approvalCount) {
        this.approvalCount = approvalCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getUsefulQuestionCount() {
        return usefulQuestionCount;
    }

    public void setUsefulQuestionCount(Integer usefulQuestionCount) {
        this.usefulQuestionCount = usefulQuestionCount;
    }

    public Integer getUsefulAnswerCount() {
        return usefulAnswerCount;
    }

    public void setUsefulAnswerCount(Integer usefulAnswerCount) {
        this.usefulAnswerCount = usefulAnswerCount;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getPosInfo() {
        return posInfo;
    }

    public void setPosInfo(String posInfo) {
        this.posInfo = posInfo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getGeoGmtModified() {
        return geoGmtModified;
    }

    public void setGeoGmtModified(LocalDateTime geoGmtModified) {
        this.geoGmtModified = geoGmtModified;
    }

    public Byte getRobot() {
        return robot;
    }

    public void setRobot(Byte robot) {
        this.robot = robot;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public void setDeviceOsVersion(String deviceOsVersion) {
        this.deviceOsVersion = deviceOsVersion;
    }

    public String getCurrentAppVersion() {
        return currentAppVersion;
    }

    public void setCurrentAppVersion(String currentAppVersion) {
        this.currentAppVersion = currentAppVersion;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName;
    }

    @Override
    public String toString() {
        return "TUser{" +
        "id = " + id +
        ", nickName = " + nickName +
        ", phoneNum = " + phoneNum +
        ", pushId = " + pushId +
        ", isShowLoc = " + isShowLoc +
        ", myIntro = " + myIntro +
        ", sex = " + sex +
        ", avatar = " + avatar +
        ", gmtCreate = " + gmtCreate +
        ", gmtModified = " + gmtModified +
        ", lastLoginTime = " + lastLoginTime +
        ", lastLogoutTime = " + lastLogoutTime +
        ", status = " + status +
        ", nextLoginTime = " + nextLoginTime +
        ", nimId = " + nimId +
        ", userWallBg = " + userWallBg +
        ", userWallVideo = " + userWallVideo +
        ", followerCount = " + followerCount +
        ", followeeCount = " + followeeCount +
        ", approvalCount = " + approvalCount +
        ", collectCount = " + collectCount +
        ", usefulQuestionCount = " + usefulQuestionCount +
        ", usefulAnswerCount = " + usefulAnswerCount +
        ", popularity = " + popularity +
        ", lat = " + lat +
        ", lng = " + lng +
        ", posInfo = " + posInfo +
        ", city = " + city +
        ", geoGmtModified = " + geoGmtModified +
        ", robot = " + robot +
        ", deviceName = " + deviceName +
        ", deviceId = " + deviceId +
        ", ip = " + ip +
        ", deviceMac = " + deviceMac +
        ", deviceOsVersion = " + deviceOsVersion +
        ", currentAppVersion = " + currentAppVersion +
        ", alipayAccount = " + alipayAccount +
        ", alipayName = " + alipayName +
        "}";
    }
}
