+ 设备kafka消息推送分为CRUD与DP类，以topic和bizCode进行区分，取值以PushCodeEnum类为准。

1.设备新增
```json
{

    "bizCode":"deviceAdd",

    "bizData":{

        "devId":"tuya6cd0fdbc365a9474aay2zg",

        "thirdDevId":"6cd0fdbc365a9474aay2zg",

        "sub":false,

        "uid":"45945992692035584",

        "channel":"tuya",

        "name":"涂鸦智能网关",

        "customName":"",

        "icon":"https://coli688-smart-home-pub-read.oss-cn-shenzhen.aliyuncs.com/icon/1629946396000.png",

        "online":true,

        "pid":"eegauvtcgqv8v4a",

        "category":"bdpwg",

        "uuid":"82e212e5eedf909e"

    },

    "devId":"tuya6cd0fdbc365a9474aay2zg",

    "ownerId":"4152",

    "productId":"eegauvtcgqv8v4a",

    "uid":"45945992692035584"

}
```
2.设备删除
```json
{

    "bizCode":"deviceDelete",

    "bizData":{

        "devId":"tuya6cd0fdbc365a9474aay2zg",

        "sub":false,

        "uid":"45945992692035584",

        "name":"涂鸦智能网关",

        "customName":"",

        "channel":"tuya",

        "icon":"https://coli688-smart-home-pub-read.oss-cn-shenzhen.aliyuncs.com/icon/1629946396000.png",

        "pid":"eegauvtcgqv8v4a",

        "category":"bdpwg",

        "uuid":"82e212e5eedf909e",

        "resetFactory":true

    },

    "devId":"tuya6cd0fdbc365a9474aay2zg",

    "ownerId":"4152",

    "productId":"eegauvtcgqv8v4a",

    "uid":"45945992692035584"

}
```
3.设备上线
```json
{

    "bizCode":"online",

    "bizData":{

        "devId":"tuya6cd0fdbc365a9474aay2zg",

        "sub":false,

        "name":"涂鸦智能网关",

        "customName":"",

        "channel":"tuya"

    },

    "devId":"tuya6cd0fdbc365a9474aay2zg",

    "ownerId":"4152",

    "productId":"eegauvtcgqv8v4a",

    "uid":"45945992692035584"

}
```
4.设备离线
```json
{

    "bizCode":"offline",

    "bizData":{

        "devId":"tuya6cd0fdbc365a9474aay2zg",

        "sub":false,

        "name":"涂鸦智能网关",

        "customName":"",

        "channel":"tuya"

    },

    "devId":"tuya6cd0fdbc365a9474aay2zg",

    "ownerId":"4152",

    "productId":"eegauvtcgqv8v4a",

    "uid":"45945992692035584"

}
```
5.设备名称更新
```json
{

    "bizCode":"deviceNameUpdate",

    "bizData":{

        "devId":"tuya6cb49b54a09c8b3a72ayv6",

        "name":"豪恩门窗传感器",

        "channel":"tuya"

    },

    "devId":"tuya6cb49b54a09c8b3a72ayv6",

    "ownerId":"341",

    "productId":"5tqh4asdnpkvg7n",

    "uid":"86-13312945235"

}
```
6.设备dp名称更新
```json
{

    "bizCode":"deviceDpNameUpdate",

    "bizData":{

        "devId":"tuya6cb49b54a09c8b3a72ayv6",

        "name":"开启",

        "code":"switch",

        "dpId":1,

        "channel":"tuya"

    },

    "devId":"tuya6cb49b54a09c8b3a72ayv6",

    "ownerId":"341",

    "productId":"5tqh4asdnpkvg7n",

    "uid":"86-13312945235"

}
```
7.设备dp下发
```json
{
"bizCode":"deviceDpIssue",
"status":[
{
"switch":true
}
],
"devId":"tuya6cb49b54a09c8b3a72ayv6",
"productId":"5tqh4asdnpkvg7n"
}
```
8.设备dp上报
```json
{
"bizCode":"deviceDpReport",
"status":[
{
"switch":true
}
],
"devId":"tuya6cb49b54a09c8b3a72ayv6",
"productId":"5tqh4asdnpkvg7n"
}
```
