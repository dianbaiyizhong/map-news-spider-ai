from playwright.sync_api import sync_playwright
import time
from tkinter import Tk


def get_clipboard():
    r = Tk()
    r.withdraw()  # 不显示Tk窗口
    try:
        content = r.clipboard_get()
    except:
        content = "剪贴板为空或内容不可获取"
    r.destroy()
    return content


def cycle_through_youtube_episodes():
    with sync_playwright() as p:
        # Launch browser (set headless=False to see the browser)
        browser = p.chromium.launch(headless=False)
        context = browser.new_context()
        page = context.new_page()

        # Navigate to YouTube
        page.goto("https://www.youtube.com/playlist?list=PL0eGJygpmOH5xQuy8fpaOvKrenoCsWrKh")
        print("Opened YouTube")
        index = 0
        time.sleep(3)  # Wait for page to load
        while True:
            top = index * 5000
            # page.evaluate("window.scrollTo(0, document.body.scrollHeight)")
            page.evaluate("""
                      window.scrollTo({
                          top: %s,
                          behavior: 'smooth'
                      })
                  """ % top)
            page.wait_for_timeout(1000)
            index = index + 1
            if index == 100:
                print("滑动了" + str(index) + "次")
                break

            # Find all episode links in the right sidebar
            # Note: YouTube's DOM structure changes frequently - you may need to update this selector
        episode_selector = "#contents yt-icon-button"
        # Wait for episodes to load
        page.wait_for_selector(episode_selector, timeout=10000)
        elements = page.query_selector_all(episode_selector)
        for element in elements:
            element.click()
            time.sleep(2)
            share_btn = page.query_selector_all('yt-formatted-string.ytd-menu-service-item-renderer')
            share_btn[1].click()
            time.sleep(2)
            # click_btn = page.query_selector_all('yt-button-renderer.yt-copy-link-renderer')
            # click_btn[0].click()
            value = page.locator("input#share-url").input_value()
            print(value)
            exit_btn = page.query_selector_all('#close-button')
            # clipboard_content = get_clipboard()
            # print("剪贴板内容:", clipboard_content)
            exit_btn[0].click()
        browser.close()


if __name__ == "__main__":
    cycle_through_youtube_episodes()
