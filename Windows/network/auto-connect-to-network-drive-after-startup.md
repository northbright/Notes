# Auto Connect to Network Drive after Startup

## Steps
1. Open a new `CMD` window
2. Use `CMDKEY` command to add server credential to `Credential Manager`

       // Add credential
       CMDKEY add:%SERVER% /user:%USERNAME /pass:%PASSWORD%
       
       // Example
       CMDKEY add:\\server /user:admin /pass:123456

       // List all added crendentials
       CMDKEY /list

       // List added credential by server name
       CMDKEY /list:%SERVER%

       CMDKEY /list:server
       CMDKEY /list:10.0.10.3
       
3. Use `NET` command to connect network drive

       // List added connections
       NET USE
       
       // Delete connection if the network drive already exists, X is the local drive letter
       NET USE X: /DELETE

       // Add connection by specifying local drive letter X
       NET USE X: \\server\share /p:yes

       // or Add connection using next available drive letter automatically
       NET USE * \\server\share /p:yes

## References
* [Net Use Command](https://www.lifewire.com/net-use-command-2618096)
* [Net.exe use 'Error: A command was used with conflicting switches.' while using /savecred](https://stackoverflow.com/questions/17996846/net-exe-use-error-a-command-was-used-with-conflicting-switches-while-using)

