

import com.bird.file.dao.ExcelFileDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application.xml")
public class testDao {
@Resource
ExcelFileDao excelFileDao;

@Test
public void test(){
    Integer status =0;
    //System.out.println(excelFileDao.selectFilesByStatus(status).size());
}
}
