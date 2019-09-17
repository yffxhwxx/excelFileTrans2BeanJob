package com.bird.file.service.impl;

import com.bird.file.bean.ExcelFile;
import com.bird.file.dao.ExcelFileDao;
import com.bird.file.service.IExcelFileSercie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ExcelFileServiceImpl implements IExcelFileSercie {

    @Resource
    ExcelFileDao excelFileDao;
    public List<ExcelFile> getExcelFilesByStatus(Map<String,Object> param) {
        try{
            return excelFileDao.selectFilesByStatus(param);
        }catch (Exception e){
            return null;
        }

    }

    public void updateFileStatusById(Integer id) {
        excelFileDao.updateFileStatusById(id);
    }
}
