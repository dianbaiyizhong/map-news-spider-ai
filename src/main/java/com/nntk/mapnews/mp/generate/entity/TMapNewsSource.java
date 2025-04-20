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
@TableName("t_map_news_source")
public class TMapNewsSource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime gmtCreate;

    private String title;

    private String videoUrl;

    private Long comboId;

    private Integer areaId;

    private Byte areaLevel;

    private String locationSubtitle;

    private Long newsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Long getComboId() {
        return comboId;
    }

    public void setComboId(Long comboId) {
        this.comboId = comboId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Byte getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Byte areaLevel) {
        this.areaLevel = areaLevel;
    }

    public String getLocationSubtitle() {
        return locationSubtitle;
    }

    public void setLocationSubtitle(String locationSubtitle) {
        this.locationSubtitle = locationSubtitle;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    @Override
    public String toString() {
        return "TMapNewsSource{" +
        "id = " + id +
        ", gmtCreate = " + gmtCreate +
        ", title = " + title +
        ", videoUrl = " + videoUrl +
        ", comboId = " + comboId +
        ", areaId = " + areaId +
        ", areaLevel = " + areaLevel +
        ", locationSubtitle = " + locationSubtitle +
        ", newsId = " + newsId +
        "}";
    }
}
