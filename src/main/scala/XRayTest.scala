import com.amazonaws.xray.AWSXRayRecorderBuilder
import org.slf4j.LoggerFactory

object XRayTest extends App  {

  val log = LoggerFactory.getLogger("xraytest")

  log.info(s"sharethrough: xray logging setting: ${System.getProperty("logging.level.com.amazonaws.xray")}")

  val recorder = AWSXRayRecorderBuilder.defaultRecorder
  
  recorder.beginSegment("segment1")

  log.info("sharethrough: Some business code")

  recorder.endSegment()

  log.info(s"sharethrough: done")

}
