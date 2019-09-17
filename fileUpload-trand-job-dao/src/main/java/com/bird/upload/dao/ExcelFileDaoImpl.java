package com.bird.upload.dao;

import com.bird.upload.bean.ExcelFile;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class ExcelFileDaoImpl implements ExcelFileDao {
    @Resource
    SqlSession session;
    private String namespace=ExcelFileDao.class.getName();
    public List<ExcelFile> getFilesByStatus(Integer status) {

        return session.selectList(namespace,"selectFilesByStatus");

    }
}
