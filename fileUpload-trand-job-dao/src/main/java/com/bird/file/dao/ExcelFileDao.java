package com.bird.file.dao;
import com.bird.file.bean.ExcelFile;

import java.util.List;
import java.util.Map;

public interface ExcelFileDao {
    List<ExcelFile> selectFilesByStatus(Map<String,Object> param);

    public void updateFileStatusById(Integer id);
}
