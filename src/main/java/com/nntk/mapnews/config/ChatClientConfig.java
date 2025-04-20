package com.nntk.mapnews.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@DependsOn("mcpServerConfig")
public class ChatClientConfig {

    @Autowired
    private ToolCallbackProvider toolCallbackProvider;

    /**
     * 配置ChatClient，注册系统指令和工具函数
     */
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem("你是一个新闻信息管理助手，可以帮助用户查询新闻信息。" +
                        "回复时，请使用简洁友好的语言，并将新闻信息整理为易读的格式。")
                // 注册工具方法
                .defaultTools(toolCallbackProvider)
                .build();
    }

}
