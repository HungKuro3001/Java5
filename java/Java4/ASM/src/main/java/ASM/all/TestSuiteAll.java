package ASM.all;

import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ EduSys.Helper.TestSuite.class, EduSys.utils.TestSuite.class, EduSysDAO.TestSuite.class,
		EduSys.entity.TestSuite.class })
public class TestSuiteAll { // nothing
}
