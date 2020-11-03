# we-cloud-java-sdk-storage

[TOC]

## 概览

WeCloud的[Apache HttpClient](https://hc.apache.org/httpcomponents-client-ga/index.html)扩展，实现了各服务功能的签名生成及请求封装。

## 项目状态

当前版本`0.0.1`为测试版本。请的专业技术人员在使用时注意系统和软件的正确性和兼容性，以及带来的风险。

## 环境要求

+ Java 1.8+

## 安装

最新版本已经在 [Maven Central](https://search.maven.org/artifact/cn.wecloud/we-cloud-sdk-storage) 发布。

### Gradle

在你的`build.gradle`文件中加入如下的依赖

```groovy
implementation 'cn.wecloud:we-cloud-sdk-storage:0.0.1'
```

### Gradle Kotlin DSL

```groovy
implementation("cn.wecloud:we-cloud-sdk-storage:0.0.1")
```

### Maven

加入以下依赖

```xml
<dependency>
  <groupId>cn.wecloud</groupId>
  <artifactId>we-cloud-sdk-storage</artifactId>
  <version>0.0.1</version>
</dependency>
```

## 开始

首先通过[WeCloud后台管理](https://console.wecloud.cn/)[创建空间](https://console.wecloud.cn/storage/add)及[获取AccessKey及SecretKey](https://console.wecloud.cn/storage/personal)

### 文件上传

```java
import cn.wecloud.sdk.common.FileItem;
import cn.wecloud.sdk.common.exception.WeCloudApiException;
import cn.wecloud.sdk.storage.client.WeCloudStorageClient;
import cn.wecloud.sdk.storage.model.WeCloudStorageUploadFileModel;
import cn.wecloud.sdk.storage.request.WeCloudStorageUploadFileRequest;
import cn.wecloud.sdk.storage.response.WeCloudStorageUploadFileResponse;

// 创建连接对象
final WeCloudStorageClient client = new WeCloudStorageClient("AccessKey", "SecretKey", BucketId);
// 创建文件对象
final FileItem fileItem = new FileItem("FilePath");
// 创建业务对象
final WeCloudStorageUploadFileModel model = new WeCloudStorageUploadFileModel();
// 创建文件上传请求
final WeCloudStorageUploadFileRequest request = new WeCloudStorageUploadFileRequest(fileItem);
// 设置请求参数
request.setParam(model);
// 执行请求
final WeCloudStorageUploadFileResponse response = client.execute(request);
// 判断请求是否成功
if (response.isSuccess()) {
    // 获取返回业务对象
    final WeCloudStorageUserFileInfo responseData = response.getData();
} else {
    // 输出请求失败信息
    log.error(response.getMsg());
} 
```

## 联系我们

如果你发现了**BUG**或者有任何疑问、建议，请通过issue进行反馈。
