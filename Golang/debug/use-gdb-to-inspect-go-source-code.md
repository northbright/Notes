# Use GDB to Inspect Go Source Code

#### Problem
We want to inspect the source code of function of builtin package(Ex: [copy()](https://godoc.org/builtin#copy)).

#### Steps
1. Write a simple go program
       
        package main

        func main() {
                s := "Hello World"
                b := []byte{12}
                copy(b, s)  // we want to get source code of the builtin copy()
        }

2. Build it without optimizations

        go build -gcflags "-N -l" -o test main.go

3. Start debugging

        gdb test
        (gdb) l  // inspect source code
        1	package main
        2	
        3	func main() {
        4		s := "Hello World"
        5		b := []byte{12}
        6		copy(b, s)
        7	}
        (gdb) br 6  // set break pointer at line 6.
        Breakpoint 1 at 0x40107f: file /home/xxu/projects-go/src/github.com/northbright/test/main.go, line 6.
        (gdb) run  // run the program
        Starting program: /home/xxu/projects-go/src/github.com/northbright/test/test

        Breakpoint 1, main.main () at /home/xxu/projects-go/src/github.com/northbright/test/main.go:6
        6		copy(b, s)
        (gdb) s  // step into the function call of copy() then get the source code.
        runtime.memmove () at /home/xxu/go/src/runtime/memmove_amd64.s:33
        33		MOVQ	to+0(FP), DI

#### Reference
* [Debugging Go Code with GDB](https://golang.org/doc/gdb)
* [Debugging golang in GDB](https://cevaris.com/2015/03/08/debugging-golang-in-gdb/)
