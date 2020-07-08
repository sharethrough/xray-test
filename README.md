# XRay test

[Code](src/main/scala/XRayTest.scala) is all on a single thread:

```scala
val xrayRecorder = AWSXRayRecorderBuilder.defaultRecorder

def tracedFunction (): Unit = {
  println(s"begin ${Thread.currentThread().getId}")
  val segment = xrayRecorder.beginSegment("bad-ip-testing")


  segment.end()
  println(s"end ${Thread.currentThread().getId}")
}

// first call
tracedFunction()

// second call
tracedFunction()
```

To run:

    $ sbt run

Output:

    alvarocarrasco@Alvaro-Work-Laptop xray-test % sbt run
    [info] Loading project definition from /Users/alvarocarrasco/workspace/xray-test/project
    [info] Loading settings for project xray-test from build.sbt ...
    [info] Set current project to xray-test (in build file:/Users/alvarocarrasco/workspace/xray-test/)
    [info] running XRayTest
    begin 112
    end 112
    begin 112
    Jul 08, 2020 2:21:09 PM com.amazonaws.xray.AWSXRayRecorder beginSegment
    SEVERE: Beginning new segment while another segment exists in the segment context. Overwriting current segment named 'bad-ip-testing' to start new segment named 'bad-ip-testing'.
    end 112