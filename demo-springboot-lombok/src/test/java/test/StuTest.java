package test;

import demo.lombok.model.Shape;
import demo.lombok.model.Stu;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@Slf4j
@Log
public class StuTest {

    @Test
    public void Test () {
        log.warn("StuTestWarn");
        log.error("StuTestError");
        log.debug("StuTestDebug");
        Stu s1 = new Stu();
        s1.setAge(1);
        s1.setId(11);
        Stu s2 = new Stu();
        s2.setAge(1);
        s2.setId(11);
//        assertEquals(s1.getAge(),s2.getId());
    }
}
