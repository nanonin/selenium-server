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

```
from selenium import webdriver

options = webdriver.ChromeOptions()
# 配置无头参数,即不打开浏览器
options.add_argument('--headless')

# 将参数设置+浏览器驱动组合
browser = webdriver.Chrome()

url = "https://www.amazon.com/sp?seller=XXX"
print(url)
# 通过selenium来访问亚马逊
browser.get(url)
title = browser.title
page_source = browser.page_source
print(title)
print(page_source)
```
