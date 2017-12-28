
# `go test` Will Run in a Temp Dir

For example:  
`/tmp/go-build854926490/github.com/northbright/db2csv/_test`

#### It may cause same problems
* Failed to read file in source folder(Ex: `./test/config`) while run `go test`

#### Solutions
1. Join the pwd and relative path
2. Run tests in source folder

    * Compile test executable in current source folder  
      `go test -c`  
      It will create a `<Package Name>.test`

    * Run the test executable from current source folder
      `./<Package Name>.test`

    * You may also run the the following command:  
      `go test -c && ./xx.test`

#### Reference
* [Golang: tests and working directory](http://stackoverflow.com/questions/23847003/golang-tests-and-working-directory)
* [read conf file under testing enviroment](https://groups.google.com/forum/#!topic/golang-nuts/-PQ_E0biZCo)
* [Unable to use the same relative path in my program AND my unit tests](https://stackoverflow.com/questions/31990342/unable-to-use-the-same-relative-path-in-my-program-and-my-unit-tests)

