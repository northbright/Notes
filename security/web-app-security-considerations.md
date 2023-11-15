# Web App Security Considerations

#### This is a **COPY** of [AngularJS's `$http` doc](https://docs.angularjs.org/api/ng/service/$http)

When designing web applications, consider security threats from:

* JSON vulnerability
* XSRF

Both server and the client must cooperate in order to eliminate these threats. AngularJS comes pre-configured with strategies that address these issues, but for this to work backend server cooperation is required.
JSON Vulnerability Protection

## JSON vulnerability
[A JSON vulnerability](http://haacked.com/archive/2008/11/20/anatomy-of-a-subtle-json-vulnerability.aspx/) allows third party website to turn your JSON resource URL into [JSONP](https://en.wikipedia.org/wiki/JSONP) request under some conditions. To counter this your server can prefix all JSON requests with following string `")]}',\n"`. AngularJS will automatically strip the prefix before processing it as JSON.

For example if your server needs to return:

    ['one','two']

which is vulnerable to attack, your server can return:

    )]}',
    ['one','two']

AngularJS will strip the prefix, before processing the JSON.
Cross Site Request Forgery (XSRF) Protection

## XSRF
XSRF is an attack technique by which the attacker can trick an authenticated user into unknowingly executing actions on your website. AngularJS provides a mechanism to counter XSRF. When performing XHR requests, the $http service reads a token from a cookie (by default, `XSRF-TOKEN`) and sets it as an HTTP header (`X-XSRF-TOKEN`). Since only JavaScript that runs on your domain could read the cookie, your server can be assured that the XHR came from JavaScript running on your domain. The header will not be set for cross-domain requests.

To take advantage of this, your server needs to set a token in a JavaScript readable session cookie called `XSRF-TOKEN` on the first HTTP GET request. On subsequent XHR requests the server can verify that the cookie matches `X-XSRF-TOKEN` HTTP header, and therefore be sure that only JavaScript running on your domain could have sent the request. The token must be unique for each user and must be verifiable by the server (to prevent the JavaScript from making up its own tokens). We recommend that the token is a digest of your site's authentication cookie with a salt for added security.

The name of the headers can be specified using the xsrfHeaderName and xsrfCookieName properties of either `$httpProvider.defaults` at config-time, `$http.defaults` at run-time, or the per-request config object.

In order to prevent collisions in environments where multiple AngularJS apps share the same domain or subdomain, we recommend that each application uses unique cookie name.

## References
* <https://docs.angularjs.org/api/ng/service/$http>

