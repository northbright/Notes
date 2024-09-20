# Setup Call Forwarding Service of Shanghai Telecom

## Setup Call Forwarding
* Call `10000` to request for the call forwarding service
* Make sure the phone number is the number need to forward when you pick up the phone and dial tone appears.
  When you have 2 or more lines(phone numbers), make sure the number of the phone ready to make a call is the number you want to forward.
  * Method A: Connect the phone to the "line out" port of the phone number on the telecom gateway directly.
    Line out ports of telecom gateway are connected to the FXO ports of PBX by default.
    Make sure use a line to connect your phone and the "line out" port of the phone number on the telecom gateway directly.
  * Method B: Make other phone numbers busy and then pick up the phone wait a dial tone.
* Set the call forwarding number
  * Dial `*57*number_to_call_forwarding#`

## Disable call forwarding
* Dial `#57#`

------

# 上海电信电话设置呼叫转移

## 设置呼叫转移
* 拨打 `10000` ，开通呼叫转移的服务
* 确认当听到拨号音时，电话正在使用需要呼叫转移的号码
  当有多路外线（号码）的时候，确认准备打电话的时候，电话使用的号码为需要设置呼叫转移的号码。
  * 方法 A: 将电话机直接连接到电信网关上，对应号码的“线路”的端口。
    电信网关的“线路”端口默认连接到 PBX 上的 FXO 输入端口。
    使用 1 根电话线直接连接电话机到电信网关的对应的“线路”的端口
  * 方法 B: 使其他号码的线路忙线，这时拿起电话机等待通话音的线路的号码就是需要呼叫转移的号码。
* 设置呼叫的号码
  * 按下 `*57*转移的号码#`

## 取消呼叫转移
* 按下 `#57#`
