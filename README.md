# XRay test

Application:
[src/main/scala/XRayTest.scala](src/main/scala/XRayTest.scala):

```scala
object XRayTest extends App  {

  val log = LoggerFactory.getLogger("xraytest")

  log.info(s"sharethrough: xray logging setting: ${System.getProperty("logging.level.com.amazonaws.xray")}")

  val recorder = AWSXRayRecorderBuilder.defaultRecorder
  
  recorder.beginSegment("segment1")

  log.info("sharethrough: Some business code")

  recorder.endSegment()

  log.info(s"sharethrough: done")

}
```

Logging config:
[src/main/resources/logback.xml](src/main/resources/logback.xml)

    ...
    <!-- Trying these just in case, but they don't work either -->
    <logger name="com.amazonaws.xray" level="DEBUG"/>
    <logger name="logging.level.com.amazonaws.xray" level="DEBUG"/>
    <!-- -->
    ...

To run:

    $ sbt run -Dlogging.level.com.amazonaws.xray=DEBUG

Output:

    alvarocarrasco@Alvaro-Work-Laptop xray-test % sbt run -Dlogging.level.com.amazonaws.xray=DEBUG
    [info] Loading settings for project global-plugins from plugins.sbt ...
    [info] Loading global plugins from /Users/alvarocarrasco/.sbt/1.0/plugins
    [info] Loading settings for project xray-test-build from metals.sbt ...
    [info] Loading project definition from /Users/alvarocarrasco/workspace/xray-test/project
    [info] Loading settings for project xray-test from build.sbt ...
    [info] Set current project to xray-test (in build file:/Users/alvarocarrasco/workspace/xray-test/)
    [info] Packaging /Users/alvarocarrasco/workspace/xray-test/target/scala-2.12/xray-test_2.12-0.1.0-SNAPSHOT.jar ...
    [info] Done packaging.
    [info] Running XRayTest 
    12:30:05.208 [run-main-0] INFO  xraytest - sharethrough: xray logging setting: DEBUG
    12:30:05.234 [run-main-0] INFO  xraytest - sharethrough: Some business code
    12:30:05.276 [run-main-0] INFO  xraytest - sharethrough: done
