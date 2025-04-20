package com.nntk.mapnews.mcp.config;

import com.nntk.mapnews.service.MapNewsService;
import jakarta.annotation.Resource;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Arrays;

@Configuration
@DependsOn("mapNewsServiceImpl")
public class McpServerConfig {

    @Resource
    private MapNewsService mapNewsService;

    @Bean
    public ToolCallbackProvider mapNewsToolCallbackProvider() {
        System.out.println("mapNewsService 实例: " + mapNewsService.getClass().getName());

        MethodToolCallbackProvider provider = MethodToolCallbackProvider.builder()
                .toolObjects(mapNewsService)
                .build();

        // 通过反射获取工具名称
        Arrays.stream(provider.getToolCallbacks())
                .map(ToolCallback::getName)
                .forEach(name -> System.out.println("注册的工具Registered Tool: " + name));
        return provider;
    }

}
