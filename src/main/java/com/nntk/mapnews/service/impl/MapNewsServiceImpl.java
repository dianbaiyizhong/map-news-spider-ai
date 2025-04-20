package com.nntk.mapnews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nntk.mapnews.mp.generate.entity.TMapNewsSource;
import com.nntk.mapnews.service.MapNewsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author wk
 * @since 2025-04-02
 */
@Slf4j
@Service
public class MapNewsServiceImpl implements MapNewsService {

    @Resource
    private com.nntk.mapnews.mp.generate.mapper.TMapNewsSourceMapper mapNewsSourceMapper;

    public MapNewsServiceImpl() {
        System.out.println("StudentServiceImpl 实例已创建");
    }

    @Override
    @Tool(name = "queryListByName", description = "根据学生姓名模糊查询学生信息")
    public List<TMapNewsSource> queryList(String keyword){
        System.out.println(keyword);
        IPage<TMapNewsSource> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);
        LambdaQueryWrapper<TMapNewsSource> wrapper = Wrappers.lambdaQuery();
        wrapper.like(TMapNewsSource::getTitle, keyword);


        IPage<TMapNewsSource> pageList = mapNewsSourceMapper.selectPage(page, wrapper);


        System.out.println(pageList.getRecords());
        return pageList.getRecords();

    }




}
