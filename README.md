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

### 本地安装webdriver方式【需要安装webdriver、浏览器（webdriver所支持的版本）】

1. 下载webdriver, 下载后将chromedriver【geckodriver】放到python安装路径下

firefox:https://github.com/mozilla/geckodriver/releases

chrome:https://registry.npmmirror.com/binary.html?path=chromedriver/

![image](https://github.com/nanonin/spider-set/assets/31438410/7fb79c00-5681-4328-a6e9-cafe6f61e261)

![image](https://github.com/nanonin/spider-set/assets/31438410/051f9aa2-6881-455b-bad6-3e03b798794d)

![image](https://github.com/nanonin/spider-set/assets/31438410/13328437-38de-4678-8964-2e10a9f8d7c7)

2. 安装依赖 

```bash
pip install selenium
```

3. 使用示例

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

### 远程驱动webdriver方式

https://www.selenium.dev/zh-cn/documentation/webdriver/drivers/remote_webdriver/

1. 部署webdriver服务
```
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-firefox:4.10.0-20230607
```
2. 访问http://localhost:4444
![image](https://github.com/nanonin/spider-set/assets/31438410/bb633011-fa70-4b9e-8510-90fd3085d7ad)

3. 客户端使用示例

```python
from selenium import webdriver

firefox_options = webdriver.FirefoxOptions()
firefox_options.add_argument('--headless')

browser = webdriver.Remote(command_executor="http://localhost:4444", options=firefox_options)

url = "https://www.baidu.com/"
print(url)
browser.get(url)
title = browser.title
page_source = browser.page_source
print(title)
print(page_source)
browser.quit()
```
