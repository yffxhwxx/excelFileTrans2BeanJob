package com.bird.file.bean;

import java.io.Serializable;
import java.util.Date;

public class ExcelFile implements Serializable {
    private String fileId;

    private String filePath;

    private Integer userId;

    private String fileName;

    private Integer fileStatus;

    private Date lastDealTime;

    private static final long serialVersionUID = 1L;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Integer getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(Integer fileStatus) {
        this.fileStatus = fileStatus;
    }

    public Date getLastDealTime() {
        return lastDealTime;
    }

    public void setLastDealTime(Date lastDealTime) {
        this.lastDealTime = lastDealTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fileId=").append(fileId);
        sb.append(", filePath=").append(filePath);
        sb.append(", userId=").append(userId);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileStatus=").append(fileStatus);
        sb.append(", lastDealTime=").append(lastDealTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}