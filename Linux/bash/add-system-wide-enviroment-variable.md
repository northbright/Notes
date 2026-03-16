# Add System Wide Environment Variable

## Solution
Create a `.sh` under `/etc/profile.d/`.

For example, we can export API key to environment:  

```sh
sudo vi  /etc/profile.d/apikey.sh
```

```sh
# Tavily API Key
export TAVILY_API_KEY="tvly-dev-xxxx"
```

## References
* [How to permanently set environmental variables](https://unix.stackexchange.com/questions/117467/how-to-permanently-set-environmental-variables)
* [Setting variable in /etc/environment has no effect](https://superuser.com/questions/1308298/setting-variable-in-etc-environment-has-no-effect)
