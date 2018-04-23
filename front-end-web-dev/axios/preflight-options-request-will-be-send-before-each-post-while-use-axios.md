# Preflight OPTIONS Request will be Send before Each POST while Using axios

#### Background
* Nginx is used as reverse proxy server running on port 80 for 2 HTTP servers:
  1. Frontend is a SPA(vue) running on port 80(nginx) for routes match `/*`
  2. Backend is a Golang(GIN) app running on port 8000 for routes match `/api/*`
* Use `axios` to send POST request to the backend server(Golang app). e.g. `/api/login`

#### Problem
* It'll send a request by `OPTIONS` method firstly before send a POST request
* Tha ajax by axios will fail with a `undefined` error

#### Root Cause
* The `axios.defaults.baseURL = xx.xx.xx/api`
* The frontend is running on port 80 and the nginx config looks like:

        server {
            listen 80;
            server_name localhost;
            ...
        }
* So it's CORS ajax
* It'll send a OPTIONS before each POST and send POST if the response code is 200

#### Solution
* Avoid CORS
  Set `axios.defaults.baseURL = '/api'` if frontend / backend share the port 80(same domain).

#### References
* [axios post get 方法都会先 发送 OPTIONS 我想把这个 OPTIONS 验证去掉](https://segmentfault.com/q/1010000012570210/a-1020000012570647)
