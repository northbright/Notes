# Install Openclaw on Win11 via WSL2

## Install WSL 2 and Use Ubuntu-24.04 as Default Linux Distro 
* Press Win + R and type "PowerShell" to open a PowerShell window
* Run `wsl --install -d Ubuntu-24.04`
  * Input user name and password 

## Start WSL Linux Distro
* Press Win + R and type "PowerShell" to open a PowerShell window
* Run `wsl -d Ubuntu-24.04` to start the distro

## Upgrade Packages and Install Dependencies
```sh
sudo apt update
sudo apt upgrade -y
sudo apt install -y unzip
```

## WSL Configuration

It's recommended to set networking mode to `mirrored` instead of `NAT`(default) to make it easy to use OpenClaw.

* Create or modify `C:\Users\XX\.wslconfig`

  ```sh
  vi /mnt/c/Users/XX/.wslconfig
  ```

  ```ini
  [wsl2]
  # 启用镜像网络模式 - 这是最重要的配置
  networkingMode=mirrored
  # 启用 DNS 隧道，防止 VPN 环境下域名解析失效
  dnsTunneling=true
  # 强制 WSL 使用 Windows 的 HTTP 代理设置
  autoProxy=true
  # 启用集成防火墙支持
  firewall=true

  [experimental]
  # 自动回收闲置内存，优化性能
  autoMemoryReclaim=gradual
  # 支持主机回环地址访问
  hostAddressLoopback=true  
  ```

* Restart Ubuntu and Verify Networking Mode

  * Run `wsl --shutdown` in a PowerShell window
  * Wait for 10 seconds to make sure Ubuntu is shutdown
  * Run `wsl -d Ubuntu-24.04` to start Ubuntu
  * Run `ip addr` to get IPv4 of `eth0`
  * Check if it's the same as running `ipconfig` on Windows

## Firewall Configuration
Run the following commands in PowerShell as **Administrator**:

```sh
# 创建入站防火墙规则，允许 OpenClaw 服务端口
New-NetFirewallRule -DisplayName "OpenClaw-Service" -Direction Inbound -Action Allow -Protocol TCP -LocalPort 18789

# 验证规则是否创建成功
Get-NetFirewallRule -DisplayName "OpenClaw-Service" | Format-Table
```

## Install Node.js
* Visit [Download Node.js](https://nodejs.org/en/download/)
* Select "24.x.x(LTS)" for "Linux" using "nvm" with "npm" to get install scripts

  e.g.

  ```sh
  # Download and install nvm:
  curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.4/install.sh | bash

  # in lieu of restarting the shell
  \. "$HOME/.nvm/nvm.sh"

  # Download and install Node.js:
  nvm install 24

  # Verify the Node.js version:
  node -v # Should print "v24.14.0".

  # Verify npm version:
  npm -v # Should print "11.9.0".
  ```

## Register a MiniMax Account
* Visit <https://www.minimaxi.com/>
* Input mobile phone number and SMS code to register a new account

## Install OpenClaw and Select MiniMax as Model provider
* Open a PowerShell Window

* Run `wsl -d Ubuntu-24.04` to start Ubuntu

* Visit [OpenClaw](https://openclaw.ai/) and run the script in Quick Start:

  ```sh
  curl -fsSL https://openclaw.ai/install.sh | bash
  ```

  It'll retry if it reports: npm install failed for openclaw@latest.

* Read security warning > "Yes"
* Onboarding mode > QuickStart
* Model/auth provider > MiniMax
* MiniMax auth method > MiniMax OAuth(Oauth plugin for MiniMax)
* Select MiniMax endpoint > CN
* Open a browser(e.g. Edge) manually > visit the given OAUTH URL > Login MiniMax Account > Authorize（授权 OpenClaw)
  * 在 [MiniMax > 套餐管理 > Coding Plan](https://platform.minimaxi.com/user-center/payment/coding-plan) 中，可以看到赠送的Trial 试用版(7 天）
  * 在 MiniMax > 账户管理 > 接口密钥 > Coding Plan Key > Key 已经创建
* Default model > Keep current(minimax-portal/MiniMax-M2.5)
* Select channel (QuickStart) > Skip for now
* Web search > Search provider > Skip for now
* Skills status > Configure skills now? > No
* Enable hooks > Skip for now
* How do you want to hatch your bot

## Install Skills
#### Method A: Download Zip and Install Manually(recommended)
* Find skill(e.g. `skill vetter`) and click the skill to go to skill home page
* Click "Download zip" button
* Get the skill slug by using the last path in the URL of the skill
  e.g. The slug is `skill-vetter` for `https://clawhub.ai/spclaudehome/skill-vetter`

* Make a skill dir which name is skill slug under `<workspace>/skills`(e.g. `~/.openclaw/workspace/skills`
  ```sh
  mkdir ~/.openclaw/workspace/skills/skill-vetter
  ```

* Unzip the downloaded zip to the skill dir 

  ```sh
  cd ~/.openclaw/skills/workspace/skill-vetter
  
  // Replace XX with your Windows user
  unzip /mnt/c/Users/XX/Downloads/skill-vetter-1.0.0.zip
  ```

* Restart Gateway

  ```sh
  openclaw restart gateway
  ```

#### Method B: Use `clawhub` Cli

Warning: You may get "Rate limit exceed" error when using this method.
Wait 30 minutes and try again.

* Sign in [clawhub](https://clawhub.ai/) using a Github account

* Create a clawhub token
  * Go to settings > API Tokens > Create token

* Install clawhub

  ```sh
  npm i -g clawhub
  ```

* Run clawhub to Login and Install a Skill

  ```sh
  // Replace TOKEN with the created token in clawhub.ai > settings.
  clawhub login --token <TOKEN>
  ```

  ```sh
  // It'll install skill under <workspace>/skills/<slug>
  clawhub install <slug>
  ```

  e.g.

  ```sh
  clawhub install skill-vetter

  // Output:
  OK. Installed skill-vetter -> /home/XX/.openclaw/workspace/skills/skill-vetter
  ```

* Recommended Skills
  * `self-improving-agent`
  * `find-skills`
  * `ontology`
  * `weather`
  * `summarize`

## Add Feishu Channel(接入飞书)
* 访问 <https://open.feishu.cn/app> 注册账号
* 创建应用 > 输入应用名称(e.g. `openclaw-bot`)和描述
* 查看 App ID 和 App Secret
  * 凭证与基础信息 > 应用凭证 > 查看 App ID 和 App Secret，后面需要为 OpenClaw 配置
* 应用能力 > 添加应用能力 > 机器人 > 点击下面的"添加"按钮
* 权限管理 > 批量导入 > [官网最新的粘贴 JSON 配置一键导入所需权限](https://docs.openclaw.ai/zh-CN/channels/feishu)

```json
{
  "scopes": {
    "tenant": [
      "aily:file:read",
      "aily:file:write",
      "application:application.app_message_stats.overview:readonly",
      "application:application:self_manage",
      "application:bot.menu:write",
      "cardkit:card:write",
      "contact:user.employee_id:readonly",
      "corehr:file:download",
      "docs:document.content:read",
      "event:ip_list",
      "im:chat",
      "im:chat.access_event.bot_p2p_chat:read",
      "im:chat.members:bot_access",
      "im:message",
      "im:message.group_at_msg:readonly",
      "im:message.group_msg",
      "im:message.p2p_msg:readonly",
      "im:message:readonly",
      "im:message:send_as_bot",
      "im:resource",
      "sheets:spreadsheet",
      "wiki:wiki:readonly"
    ],
    "user": ["aily:file:read", "aily:file:write", "im:chat.access_event.bot_p2p_chat:read"]
  }
}
```

* 机器人 > 如何开始使用 > 输入机器人名称(e.g. OpenClaw-bot)

* 回到 Ubuntu 使用 openclaw cli 添加 Feishu Channel
  * 先运行 `openclaw channels add` > 选择 Feishu（飞书)
  * 输入 App Secret 和 App ID
  * Feishu connection mode > WebSocket(default)
  * Which Feishu domain > Feishu(feishu.cn) - China
  * Group chat policy > open
  * Finished
  * Configure DM access policies now?(default: pairing) > Yes
  * Feishu DM policy > Paring(recommended)
  * Add display names for these accounts?(optional) > No
  * Bind configured channel accounts to agents now? > Yes
  * Route feishu account "default" to agent > main(default)

* 在飞书后台配置事件订阅
  * 事件与回调 > 事件配置 Tab > 订阅方式 > 使用 **长连接** 接收事件（推荐）> 保存
  * 点击"添加事件" > 搜索"im.message.receive_v1"（用户发送新消息至机器人或者群聊后推送事件）> 添加

* 发布应用
  * 在 版本管理与发布 页面创建版本
    * 输入应用版本号(e.g. v0.0.1)
    * 输入应用说明(e.g. OpenClaw bot v0.0.1)
  * 提交审核并发布
  * 等待管理员审批（企业自建应用通常自动通过）

* 测试
  * 在手机上安装飞书 App，使用手机号登录
  * 收到应用已经审批通过消息 > 点击打开应用
  * 发送 1 条消息给 bot(e.g. Hello)
  * 回复:

    > OpenClaw: access not configured.
    > ......
    > Ask the bot owner to approve with:
    > openclaw pairing approve feishu XXXX

  * 在 Ubuntu 运行 `openclaw pairing approve feishu <XXXX>`
  * 输出: `Approved feishu sender xxxx` 说明配置成功 

## Check Installed Skills
* Go to dashboard > Skills > Installed Skills

