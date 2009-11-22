package org.oleg.spring.scala

import bean.SampleBean
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import javax.annotation.Resource
import org.junit.{Assert, Test}
import Assert._

/**
 * Stub test in order to run test spring context and find out weather it starts successfully.
 *
 * @author Oleg Ilyenko
 */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(locations = Array("/META-INF/spring/test-context.xml"))
class MainTest {

    @Resource(name = "sample")
    private[this] var sampleBean: SampleBean = _

    @Test
    def sampleBeanCreation {
        assertNotNull(sampleBean)
    }

}