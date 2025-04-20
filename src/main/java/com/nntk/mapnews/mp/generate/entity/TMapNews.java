package com.nntk.mapnews.mp.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_map_news")
public class TMapNews implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private LocalDateTime gmtCreate;

    private Integer sortIndex;

    private Byte status;

    private Byte type;

    private Integer areaId;

    private Integer areaLevel;

    private Long sourceId;

    private LocalDateTime articleTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public LocalDateTime getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(LocalDateTime articleTime) {
        this.articleTime = articleTime;
    }

    @Override
    public String toString() {
        return "TMapNews{" +
        "id = " + id +
        ", gmtCreate = " + gmtCreate +
        ", sortIndex = " + sortIndex +
        ", status = " + status +
        ", type = " + type +
        ", areaId = " + areaId +
        ", areaLevel = " + areaLevel +
        ", sourceId = " + sourceId +
        ", articleTime = " + articleTime +
        "}";
    }
}
