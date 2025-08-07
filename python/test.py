import asyncio
from dotenv import load_dotenv
from patchright.async_api import async_playwright
from pydantic import SecretStr, BaseModel

load_dotenv()
from browser_use import Agent, BrowserProfile, Browser, BrowserConfig
from browser_use.llm import ChatOpenAI

from browser_use import Agent, BrowserSession

from browser_use import Agent, BrowserSession

# If no executable_path provided, uses Playwright/Patchright's built-in Chromium
browser_session = BrowserSession(
    # Path to a specific Chromium-based executable (optional)
    executable_path='/Applications/Google Chrome.app/Contents/MacOS/Google Chrome',  # macOS
    # For Windows: 'C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe'
    # For Linux: '/usr/bin/google-chrome'

    # Use a specific data directory on disk (optional, set to None for incognito)
    user_data_dir='~/.config/browseruse/profiles/default',  # this is the default
    # ... any other BrowserProfile or playwright launch_persistnet_context config...
    # headless=False,
)


async def main():
    agent = Agent(
        # browser=browser,
        task="Compare the price of gpt-4o and DeepSeek-V3",
        llm=ChatOpenAI(model="deepseek-chat", temperature=1.0,
                       api_key=SecretStr('sk-dc03fa49759b4356ba29a2bab0c6a62c'),
                       base_url='https://api.deepseek.com'
                       ),
        browser_session=browser_session
    )
    await agent.run()


asyncio.run(main())
