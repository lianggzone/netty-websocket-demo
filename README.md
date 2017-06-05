# Netty 实现基于 ProtoBuf 的 WebSocket 通信

###  技术栈
- netty
- protobuf
- websocket

###  说明

- ProtoBuf 相关文件（包括实体对象生成器 protoc.exe、BAT运行脚本 build.bat、ProtoBuf .proto文件）

地址
```
https://github.com/lianggzone/netty-websocket-demo/tree/master/src/main/resources/protobuf
```

- 相关依赖

参见文档

```
https://developers.google.com/protocol-buffers/
https://github.com/dcodeIO/ProtoBuf.js
https://github.com/dcodeIO/ByteBuffer.js
https://github.com/dcodeIO/Long.js
```

```
  <script src="js/Long.min.js"></script>
  <script src="js/ByteBufferAB.min.js"></script>
  <script src="js/ProtoBuf.min.js"></script>
```

### 步骤

#### 服务端
1. 运行 com.lianggzone.netty.activator.RunMain 开启服务

#### 客户端（Web前端）
1. 运行 /src/test/resources/websocket/demo.html
1. 浏览器开启 F12 。（原因：作者偷懒）
1. 建议使用 Mozilla Firefox 浏览器。（原因：protobuf文件存在本地，浏览器对本机文件访问存在限制，如果将文件上传到服务器通过 URL 访问就不存在这个问题）
