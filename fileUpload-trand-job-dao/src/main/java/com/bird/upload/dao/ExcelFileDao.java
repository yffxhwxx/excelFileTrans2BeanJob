package com.bird.upload.dao;


import com.bird.upload.bean.ExcelFile;

import java.util.List;

public interface ExcelFileDao {

    List<ExcelFile> getFilesByStatus(Integer status);
}