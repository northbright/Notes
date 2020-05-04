# The Ways to Make Goroutines Yield

## The way goroutines yield control back to their thread:
* `select` statement
* Blocking calls
  * syscalls
  * channel reads / writes
  * mutex locks
  * IO operations
* `runtime.Gosched`
* function call(Since Go1.2)

  > In prior releases, a goroutine that was looping forever could starve out other goroutines on the same thread, a serious problem when GOMAXPROCS provided only one user thread. In Go 1.2, this is partially addressed: The scheduler is invoked occasionally upon entry to a function. This means that any loop that includes a (non-inlined) function call can be pre-empted, allowing other goroutines to run on the same thread.

## Referenes
* [golang methods that will yield goroutines](https://stackoverflow.com/questions/21102078/golang-methods-that-will-yield-goroutines)
* [Go: pausing a goroutine](https://stackoverflow.com/questions/31730244/go-pausing-a-goroutine)
* [Understanding goroutines](https://stackoverflow.com/questions/10095751/understanding-goroutines)


