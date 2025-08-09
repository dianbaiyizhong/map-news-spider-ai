import asyncio

from dotenv import load_dotenv
from langchain_openai import ChatOpenAI

load_dotenv()

from browser_use import Agent



async def main():
    agent = Agent(
        # browser=browser,
        task='''
         1. 打开http://www.baidu.com
         2. 搜索 曼巴吐讯，返回第一个结果标题
        ''',
        # llm=ChatOpenAI(model="qwen-plus",
        #                api_key='sk-cb80f6a73a5f4ffb80b12f3260eb7217',
        #                base_url='https://dashscope.aliyuncs.com/compatible-mode/v1'
        #                ),
        llm=ChatOpenAI(model="qwen-plus", temperature=0.0,
                       api_key='sk-cb80f6a73a5f4ffb80b12f3260eb7217',
                       base_url='http://127.0.0.1:8080/'
                       ),
        # browser_session=browser_session,
        use_vision=False
    )
    await agent.run()


asyncio.run(main())
