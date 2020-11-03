# we-cloud-java-sdk-sms

[TOC]

## 概览

WeCloud的[Apache HttpClient](https://hc.apache.org/httpcomponents-client-ga/index.html)扩展，实现了各服务功能的签名生成及请求封装。

## 项目状态

当前版本`0.0.1`为测试版本。请的专业技术人员在使用时注意系统和软件的正确性和兼容性，以及带来的风险。

## 环境要求

+ Java 1.8+

## 安装

最新版本已经在 [Maven Central](https://search.maven.org/artifact/cn.wecloud/we-cloud-sdk-sms) 发布。

### Gradle

在你的`build.gradle`文件中加入如下的依赖

```groovy
implementation 'cn.wecloud:we-cloud-sdk-sms:0.0.1'
```

### Gradle Kotlin DSL

```groovy
implementation("cn.wecloud:we-cloud-sdk-sms:0.0.1")
```

### Maven

加入以下依赖

```xml
<dependency>
  <groupId>cn.wecloud</groupId>
  <artifactId>we-cloud-sdk-sms</artifactId>
  <version>0.0.1</version>
</dependency>
```

## 开始

### 国内短信发送

```java
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import cn.wecloud.sdk.sms.client.WeCloudSmsClient;
import cn.wecloud.sdk.sms.data.WeCloudSmsSingleSendResult;
import cn.wecloud.sdk.sms.model.WeCloudSmsDomesticModel;
import cn.wecloud.sdk.sms.request.WeCloudSmsDomesticSingleSendRequest;
import cn.wecloud.sdk.sms.response.WeCloudSmsDomesticSingleSendResponse;

// 创建连接对象
final WeCloudSmsClient client = new WeCloudSmsClient("5kXMjmRCdWFqkkds");
// 创建请求信息对象
final WeCloudSmsDomesticModel model = new WeCloudSmsDomesticModel("18059273037", "1323474417736716290", "123456");
// 创建请求对象
final WeCloudSmsDomesticSingleSendRequest request = new WeCloudSmsDomesticSingleSendRequest(model);
// 执行请求
final WeCloudSmsDomesticSingleSendResponse execute = client.execute(request);
// 判断是否请求成功
if (execute.isSuccess()) {
    // 获取返回业务对象
    final WeCloudSmsSingleSendResult result = execute.getData();
} else {
    // 输出请求失败信息
    log.error(execute.getMsg());
}
```

## 联系我们

如果你发现了**BUG**或者有任何疑问、建议，请通过issue进行反馈。
