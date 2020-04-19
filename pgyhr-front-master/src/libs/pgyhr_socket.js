import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import config from "./config";

var stompClient = null;

export function connect(url,computeStatus){
  let socket = new SockJS(config.basePaths["EntrustQueryService"] + '/agentsite-websocket');
  stompClient = Stomp.over(socket);
  stompClient.connect({},function (frame) {
    stompClient.subscribe('/entrust/status/',function (result) {
      console.log("获取最新委托任务单 : " + result.body);
      computeStatus.statusVal = result.body
    });

    stompClient.send(url, {}, JSON.stringify({'code': 'a', 'type': '1' }));
  });
}

export function disconnect() {
  if(stompClient !== null){
    stompClient.disconnect()
  }
}

export function send(url) {
  stompClient.send(url, {}, JSON.stringify({'code': 'a', 'type': '1' }));
}
