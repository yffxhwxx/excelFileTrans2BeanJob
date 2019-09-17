package com.bird.file.dao.impl;

import com.bird.file.bean.ExcelFile;
import com.bird.file.dao.ExcelFileDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class ExcelFileDaoImpl implements ExcelFileDao {

    @Resource
    SqlSession sqlSession;

    private String namespace=ExcelFileDao.class.getName();

    public List<ExcelFile> selectFilesByStatus(Map<String,Object> param) {
       return  sqlSession.selectList(namespace+".getFilesByStatus",param);

    }

    public void updateFileStatusById(Integer id) {
        sqlSession.update(namespace+".updateStatusByFileId",id);
    }


}
