# Golang String Compare Internals

#### Part I. Code in Go Comipler
* Function [walkexpr()](https://github.com/golang/go/blob/release-branch.go1.9/src/cmd/compile/internal/gc/walk.go#L459) in [go/src/cmd/compile/internal/gc/walk.go](https://github.com/golang/go/blob/release-branch.go1.9/src/cmd/compile/internal/gc/walk.go), which walks go expression.
* You may find [`OCMPSTR`](https://github.com/golang/go/blob/release-branch.go1.9/src/cmd/compile/internal/gc/walk.go#L1249) under [`opswitch` label](https://github.com/golang/go/blob/release-branch.go1.9/src/cmd/compile/internal/gc/walk.go#L503), which is the operation of string comparation.

        func walkexpr(n *Node, init *Nodes) *Node {
                ......
        opswitch:
                switch n.Op {
                ......
                case OCMPSTR:

* For `==` and `!=` operator:
  * Do a quick check of len before full compare.
  * Then call [`eqstring`](https://github.com/golang/go/blob/release-branch.go1.9/src/runtime/asm_amd64.s#L1351) of runtime. 
* For other operators(e.g. `<`, `>`):
  * Call [`cmpstring`](https://github.com/golang/go/blob/release-branch.go1.9/src/runtime/asm_amd64.s#L1484) of runtime.

* [Code Block](https://github.com/golang/go/blob/release-branch.go1.9/src/cmd/compile/internal/gc/walk.go#L1367):

   ```
if Op(n.Etype) == OEQ || Op(n.Etype) == ONE {
			// prepare for rewrite below
			n.Left = cheapexpr(n.Left, init)
			n.Right = cheapexpr(n.Right, init)

			r = mkcall("eqstring", types.Types[TBOOL], init, conv(n.Left, types.Types[TSTRING]), conv(n.Right, types.Types[TSTRING]))

			// quick check of len before full compare for == or !=
			// eqstring assumes that the lengths are equal
			// TODO(marvin): Fix Node.EType type union.
			if Op(n.Etype) == OEQ {
				// len(left) == len(right) && eqstring(left, right)
				r = nod(OANDAND, nod(OEQ, nod(OLEN, n.Left, nil), nod(OLEN, n.Right, nil)), r)
			} else {
				// len(left) != len(right) || !eqstring(left, right)
				r = nod(ONOT, r, nil)
				r = nod(OOROR, nod(ONE, nod(OLEN, n.Left, nil), nod(OLEN, n.Right, nil)), r)
			}

			r = typecheck(r, Erv)
			r = walkexpr(r, nil)
		} else {
			// sys_cmpstring(s1, s2) :: 0
			r = mkcall("cmpstring", types.Types[TINT], init, conv(n.Left, types.Types[TSTRING]), conv(n.Right, types.Types[TSTRING]))
			// TODO(marvin): Fix Node.EType type union.
			r = nod(Op(n.Etype), r, nodintconst(0))
}
                
   ```
   
#### Part II - Code in Runtime
For x64: [go/src/runtime/asm_amd64.s ](https://github.com/golang/go/blob/release-branch.go1.9/src/runtime/asm_amd64.s)

*  [`eqstring`](https://github.com/golang/go/blob/release-branch.go1.9/src/runtime/asm_amd64.s#L1351):
   ```
   // eqstring tests whether two strings are equal.
   // The compiler guarantees that strings passed
   // to eqstring have equal length.
   // See runtime_test.go:eqstring_generic for
   // equivalent Go code.
   TEXT runtime·eqstring(SB),NOSPLIT,$0-33
	MOVQ	s1_base+0(FP), SI
	MOVQ	s2_base+16(FP), DI
	CMPQ	SI, DI
	JEQ	eq
	MOVQ	s1_len+8(FP), BX
	LEAQ	ret+32(FP), AX
	JMP	runtime·memeqbody(SB)
eq:
	MOVB	$1, ret+32(FP)
	RET
   ```

* [`cmpstring`](https://github.com/golang/go/blob/release-branch.go1.9/src/runtime/asm_amd64.s#L1484): 
   ```
   TEXT runtime·cmpstring(SB),NOSPLIT,$0-40
	MOVQ	s1_base+0(FP), SI
	MOVQ	s1_len+8(FP), BX
	MOVQ	s2_base+16(FP), DI
	MOVQ	s2_len+24(FP), DX
	LEAQ	ret+32(FP), R9
	JMP	runtime·cmpbody(SB)
   ```

You can see `runtime·memeqbody` and `runtime·memeqbody` will be called.

#### References
* [Golang Internals, Part 1: Main Concepts and Project Structure](https://blog.altoros.com/golang-part-1-main-concepts-and-project-structure.html)
* [cmpstring is too slow to use for equality and inequality](https://github.com/golang/go/issues/1161)


