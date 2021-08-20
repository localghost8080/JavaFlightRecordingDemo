# Build instructions.
```
 maven clean package
```
* this will create a jar in ./target dir and ./target/lib containing dependencies 

Run jfr as follows in the target dir
```
java -XX:StartFlightRecording=name=benchmark,filename=benchmark.jfr,settings=profile -jar filecopyer-0.0.1-SNAPSHOT.jar srcfile destfile
```




