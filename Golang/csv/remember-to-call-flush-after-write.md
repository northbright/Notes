# Remember to Call csv.Writer.Flush() after csv.Writer.Write()

* [Flush](https://godoc.org/encoding/csv#Writer.Flush) **need** to be called after [Write](https://godoc.org/encoding/csv#Writer.Write)

* [WriteAll](https://godoc.org/encoding/csv#Writer.WriteAll) will call [Flush](https://godoc.org/encoding/csv#Writer.Flush) automatically.
