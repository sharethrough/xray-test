import com.amazonaws.xray.AWSXRayRecorderBuilder

object XRayTest extends App {

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
}
