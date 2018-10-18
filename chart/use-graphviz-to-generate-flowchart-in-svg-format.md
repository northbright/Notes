# Use [Graphviz](http://graphviz.org/) to Generate Flowchart in SVG Format

## Steps
1. Use [DOT Language](https://graphviz.gitlab.io/_pages/doc/info/lang.html) to write a `.dot` file to describle the flowchart
2. Run `dot` command to output the `SVG` file by given `.dot` file
     * `-T` specifies the output file type: SVG / PNG
     * `-o` specifies the output file name
     
     Example:
     ```
   dot -Tsvg my.dot -o my.svg
   ```

## References
* [graphviz dot语言学习笔记](https://www.jianshu.com/p/e44885a777f0)
* [使用graphviz绘制流程图（2015版）](http://blog.jobbole.com/94472/)
* [Flow charts in code: enter graphviz and the “dot” language](http://melp.nl/2013/08/flow-charts-in-code-enter-graphviz-and-the-dot-language/)
* [Draw a Neural Network through Graphviz](https://zhu45.org/posts/2017/May/25/draw-a-neural-network-through-graphviz/)
