package com.bird.file.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable {
    private Integer goodsId;

    private BigDecimal goodsOnsale;

    private Integer goodsOnstock;

    private BigDecimal goodsSale;

    private Integer goodsStock;

    private Integer fileId;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getGoodsOnsale() {
        return goodsOnsale;
    }

    public void setGoodsOnsale(BigDecimal goodsOnsale) {
        this.goodsOnsale = goodsOnsale;
    }

    public Integer getGoodsOnstock() {
        return goodsOnstock;
    }

    public void setGoodsOnstock(Integer goodsOnstock) {
        this.goodsOnstock = goodsOnstock;
    }

    public BigDecimal getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(BigDecimal goodsSale) {
        this.goodsSale = goodsSale;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsOnsale=").append(goodsOnsale);
        sb.append(", goodsOnstock=").append(goodsOnstock);
        sb.append(", goodsSale=").append(goodsSale);
        sb.append(", goodsStock=").append(goodsStock);
        sb.append(", fileId=").append(fileId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}