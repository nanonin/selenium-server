# 获取网页源码

## http请求

```
# 获取网页源码
url = "https://www.amazon.com/sp?seller=XXX"
headers = {"User-Agent": "Mozilla/5.0 (X11; Linux x86_64)"}
request = urllib.request.Request(url, headers=headers)
response = urllib.request.urlopen(request)
page_source = response.read().decode("utf-8")
```


## selenium

### 本地安装webdriver方式

1. 下载webdriver, 下载后将chromedriver【geckodriver】放到python安装路径下

firefox:https://github.com/mozilla/geckodriver/releases

chrome:https://registry.npmmirror.com/binary.html?path=chromedriver/


2. 安装依赖 

```bash
pip install selenium
```

3. 运用示例

```python
from selenium import webdriver

# chrome
options = webdriver.ChromeOptions()
options.add_argument('--headless') # 配置headless参数, 即不打开浏览器
browser = webdriver.Chrome()
url = "https://www.amazon.com/sp?seller=XXX"
browser.get(url)
title = browser.title
page_source = browser.page_source
print(title)
print(page_source)

# firefox
options = webdriver.FirefoxOptions()
options.add_argument('--headless')
browser = webdriver.Firefox()
url = "https://www.amazon.com/sp?seller=A294P4X9EWVXLJ"
browser.get(url)
title = browser.title
page_source = browser.page_source
print(title)
print(page_source)
```
