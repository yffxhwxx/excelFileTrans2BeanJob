package com.bird.file.task;

import com.bird.file.bean.ExcelFile;
import com.bird.file.bean.Goods;
import com.bird.file.service.IExcelFileSercie;
import com.bird.file.service.IGoodsService;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.google.common.collect.Maps;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ExcelFileTrans2BeanJob implements DataflowJob<ExcelFile>{

    private static final Logger logger = LoggerFactory.getLogger(ExcelFileTrans2BeanJob.class);

    @Resource
    IExcelFileSercie iExcelFileSercie;
    @Resource
    IGoodsService iGoodsService;

    public List<ExcelFile> fetchData(ShardingContext shardingContext) {

        List<ExcelFile> list=new ArrayList<ExcelFile>();
        Map<String,Object> param=Maps.newHashMap();
        int totulCount=shardingContext.getShardingTotalCount();
        int currentItem=shardingContext.getShardingItem();
        Integer fileStatus=0;
        param.put("fileStatus",fileStatus);
        param.put("totulCount",totulCount);
        param.put("currentItem",currentItem);
        List<ExcelFile> res= iExcelFileSercie.getExcelFilesByStatus(param);
        if( null!=res && res.size()>0){
            list.addAll(res);
        }
        logger.info("ExcelFileTrans2BeanJob 查询到{}条数据，总分片：{},当前分片:{}",list.size(),totulCount,currentItem);
        return list;
    }

    public void processData(ShardingContext shardingContext, List<ExcelFile> list) {

        if( list.size() >0 ){
            System.out.println(222);
            for( ExcelFile excelFile:list){
                dealFile(excelFile);
            }
        }
    }

    public void dealFile(ExcelFile excelFile){

        List<Goods> goodsList=trans2B(excelFile);
        //上传的文件相当于库存系统或者价格系统，可以在这发库存和价格的mq  todo
        if( null!=goodsList &&goodsList.size()>0)
            iGoodsService.bathInseret(goodsList);
        iExcelFileSercie.updateFileStatusById(excelFile.getId());

    }

    public List<Goods> trans2B(ExcelFile excelFile){
        String fileName=excelFile.getFileId()+"-"+excelFile.getFileName();
        String filePath=excelFile.getFilePath();
        XSSFWorkbook wb=null;
        try {
             wb= new XSSFWorkbook(new FileInputStream(filePath+"\\"+fileName));
            XSSFSheet sheet = wb.getSheetAt(0);
            int totalRow=sheet.getLastRowNum();
            List<Goods> list=new ArrayList<Goods>();
            //把excel转换为goods对象
            for(int i=1;i<=totalRow;i++){
                Goods goods=new Goods();
                Row row=sheet.getRow(i);
                Cell goodsId=row.getCell(0);
                goods.setGoodsId((int)goodsId.getNumericCellValue());
                Cell cellOnSale=row.getCell(1);

                double onSale=cellOnSale.getNumericCellValue();
                BigDecimal saleOn=BigDecimal.valueOf(onSale);
                goods.setGoodsOnsale(saleOn);
                Cell cellSale=row.getCell(2);
                double d=cellSale.getNumericCellValue();
                BigDecimal sale=BigDecimal.valueOf(d);
                goods.setGoodsSale(sale);
                Cell cellOnStock=row.getCell(3);
                int stockOn=(int)Double.parseDouble(cellOnStock.toString());
                goods.setGoodsOnstock(stockOn);
                Cell cellStock=row.getCell(4);
                int stock=(int)Double.parseDouble(cellStock.toString());
                goods.setGoodsStock(stock);
                goods.setFileId(excelFile.getFileId());
                list.add(goods);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
