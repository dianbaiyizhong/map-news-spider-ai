import asyncio
import re
import os

# os.environ["http_proxy"] = "http://127.0.0.1:26001"
# os.environ["https_proxy"] = "http://127.0.0.1:26001"
# os.environ["all_proxy"] = "socks5://127.0.0.1:26001"

from browser_use.llm.openai.chat import ChatOpenAI
from dotenv import load_dotenv
from patchright.async_api import async_playwright

load_dotenv()

from browser_use import Agent, BrowserSession, BrowserProfile

# If no executable_path provided, uses Playwright/Patchright's built-in Chromium
browser_session = BrowserSession(
    # Path to a specific Chromium-based executable (optional)
    # executable_path='/Users/huanghaoming/Documents/software/chrome1175/Chromium.app',  # macOS
    # executable_path='/Applications/Google Chrome.app/Contents/MacOS/Google Chrome',  # macOS
    # For Windows: 'C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe'
    # For Linux: '/usr/bin/google-chrome'
    # Use a specific data directory on disk (optional, set to None for incognito)
    # user_data_dir='~/.config/browseruse/profiles/banking',
    # ... any other BrowserProfile or playwright launch_persistnet_context config...
    # headless=False,
    # keep_alive=True
)


# browser_session2 = BrowserSession(browser_pid=8055)  # Replace with actual Chrome PID


async def main():
    agent = Agent(
        # browser=browser,
        task='''
     1. 打开https://www.baidu.com
    ''',
        llm=ChatOpenAI(model="qwen-plus",
                       api_key='sk-cb80f6a73a5f4ffb80b12f3260eb7217',
                       base_url='https://dashscope.aliyuncs.com/compatible-mode/v1'
                       ),
        # llm=ChatOpenAI(model="qwen-plus", temperature=0.0,
        #                api_key='sk-cb80f6a73a5f4ffb80b12f3260eb7217',
        #                base_url='http://127.0.0.1:8080/'
        #                ),
        browser_session=browser_session,
        # use_vision=False
        # use_vision=True,
        # page=page,
    )
    await agent.run()


asyncio.run(main())
