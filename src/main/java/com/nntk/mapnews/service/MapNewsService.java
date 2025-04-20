package com.nntk.mapnews.service;

import com.nntk.mapnews.mp.generate.entity.TMapNewsSource;

import java.util.List;

/**
 * <p>
 * 学生表 服务类
 * </p>
 *
 * @author wk
 * @since 2025-04-02
 */
public interface MapNewsService {


    public List<TMapNewsSource> queryList(String keyword);



}
