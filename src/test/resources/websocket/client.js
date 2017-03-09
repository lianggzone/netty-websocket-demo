// 创建ProtoBuf
var ProtoBuf = dcodeIO.ProtoBuf;
// 加载ProtoBuf文件
var CommonProtocol = ProtoBuf.loadProtoFile("proto/ProtocolModule.proto").build("CommonProtocol");
var commonProtocol = new CommonProtocol();
// 组装请求包
var CommonHeader = CommonProtocol.CommonHeader;
var commonHeader = new CommonHeader();
commonHeader.setCommandId(0x000100FF).setSeqId(1000).setVersion(1);

var LiveCommonHeader = CommonProtocol.LiveCommonHeader;
var liveCommonHeader = new LiveCommonHeader();
liveCommonHeader.setLiveType(1).setLiveId(1).setDemandType(1).setDemandId(1);

commonProtocol.CommHeader = commonHeader;
commonProtocol.LiveHeader = liveCommonHeader;
// 请求websocket
var websocket = null;
websocket = new WebSocket('ws://localhost:19999/chat');
websocket.binaryType = "arraybuffer";

// 连接成功建立的回调方法
websocket.onopen = function () {
    console.log("连接成功");
    websocket.send(commonProtocol.toArrayBuffer());
}
// 接收到消息的回调方法
websocket.onmessage = function (res) {
	  console.log("接收到消息");
    console.log(res.data);
    console.log(CommonProtocol.decode(res.data));
}
// 连接关闭的回调方法
websocket.onclose = function () {
	  console.log("连接关闭");
}
