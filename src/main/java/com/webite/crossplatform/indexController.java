package com.webite.crossplatform;

import com.webite.crossplatform.entities.GoodsEntity;
import com.webite.crossplatform.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class indexController {

    private static final String projectPath = System.getProperty("user.dir");

    @Autowired
    GoodsDao goodsDao;

    @RequestMapping("/")
    public String index(Model model) {
//        goodsDao.save(createRandomGoodsTable("11.jpg"));

        List<GoodsEntity> list = goodsDao.findAllGoods();
        model.addAttribute("goodsList", list);

        return "index";
    }

    public GoodsEntity createRandomGoodsTable(String imgName) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setName("Product " + (int)(Math.random() * 1000));
        goodsEntity.setQuantity((int)(Math.random() * 100));
        goodsEntity.setPrice((int)(Math.random() * 1000));
        goodsEntity.setDescription("Description " + (int)(Math.random() * 1000));
        goodsEntity.setImg(projectPath + "/src/main/webapp/images/" + imgName);
        return goodsEntity;
    }





}
