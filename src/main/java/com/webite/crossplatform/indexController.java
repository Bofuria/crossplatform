package com.webite.crossplatform;

import com.webite.crossplatform.entities.GoodsEntity;
import com.webite.crossplatform.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.List;

@Controller
public class indexController {

    private static final String projectPath = System.getProperty("user.dir");

    @Autowired
    editController editController;

    @Autowired
    GoodsDao goodsDao;

    @RequestMapping("/index")
    public String index(Model model) {

        List<GoodsEntity> list = goodsDao.findAllGoods();
        model.addAttribute("goodsList", list);

        Hashtable<Integer, String> images = editController.getAllImages();
        model.addAttribute("images", images);

        return "index";
    }
}
