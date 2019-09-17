package com.bird.file.dao.impl;

import com.bird.file.bean.Goods;
import com.bird.file.dao.GoodsDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Resource
    SqlSession sqlSession;

    private String namespace=GoodsDao.class.getName();
    public void bathInseret(List<Goods> list) {
        sqlSession.insert(namespace+".batchInseret",list);
    }
}
