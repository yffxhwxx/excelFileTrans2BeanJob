package com.bird.file.service;

import com.bird.file.bean.ExcelFile;

import java.util.List;
import java.util.Map;

public interface IExcelFileSercie {

    public List<ExcelFile> getExcelFilesByStatus(Map<String,Object> param);

    public void updateFileStatusById(Integer id);
}
