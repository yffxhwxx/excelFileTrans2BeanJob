package com.bird.file.service.impl;

import com.bird.file.bean.Goods;
import com.bird.file.dao.GoodsDao;
import com.bird.file.service.IGoodsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsSercieImpl implements IGoodsService{

    @Resource
    GoodsDao goodsDao;
    public void bathInseret(List<Goods> list) {
        goodsDao.bathInseret(list);
    }
}
