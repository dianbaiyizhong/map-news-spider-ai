import json
import os

import uvicorn
from browser_use.browser.browser import Browser, BrowserConfig
from langchain_openai import ChatOpenAI
from browser_use import Agent
import asyncio
from dotenv import load_dotenv
from pydantic import SecretStr, BaseModel
from browser_use.browser.context import BrowserContextConfig, BrowserContext

from fastapi import FastAPI  # 导⼊FastAPI，⽤于定义API

app = FastAPI()  # 创建FastAPI实例

load_dotenv()
# api_key = os.getenv('DEEPSEEK_API_KEY', 'sk-28noKxU9Jlto1PAtLkPRRZO7pS3LW78bYq2ivmc1DxWy2qoN')
api_key = os.getenv('DEEPSEEK_API_KEY', 'sk-dc03fa49759b4356ba29a2bab0c6a62c')
if not api_key:
    raise ValueError('DEEPSEEK_API_KEY is not set')

config = BrowserConfig(
    # 不开启浏览器窗口  
    headless=True,
    disable_security=True,
    # headless为true，这个值就不能设置  
    # chrome_instance_path='/Applications/Google Chrome.app/Contents/MacOS/Google Chrome',
)
browser = Browser(config)

context = BrowserContext(browser=browser)


class Item(BaseModel):
    prompts: list


@app.post("/browserUse/chat")
async def chat(item: Item):
    prompts = item.prompts
    # https://www.cnblogs.com/risheng/p/18792927 参数文档
    agents = [
        # Agent(task=task, llm=ChatOpenAI(
        #     base_url='https://api.chatanywhere.tech',
        #     model='o3',
        #     api_key=SecretStr(api_key),
        # ),
        Agent(task=task, llm=ChatOpenAI(
            base_url='https://api.deepseek.com',
            model='deepseek-chat',
            api_key=SecretStr(api_key),
        ),
              use_vision=False,
              browser=browser)
        for task in prompts
    ]
    results = await asyncio.gather(*[agent.run() for agent in agents])
    ret = list()
    for result in results:
        ret.append(result.final_result())
    session = await browser.playwright_browser.new_browser_cdp_session()
    await session.send("Browser.close")
    await browser.close()
    return ret


# asyncio.run(main())


if __name__ == '__main__':
    uvicorn.run("main:app", host="0.0.0.0",
                port=8000, reload=False, workers=1)
