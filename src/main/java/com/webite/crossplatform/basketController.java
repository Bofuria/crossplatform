package com.webite.crossplatform;

import com.webite.crossplatform.dao.GoodsDao;
import com.webite.crossplatform.entities.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class basketController {

    private List<GoodsEntity> items = new ArrayList<>();

    @Autowired
    GoodsDao goodsDao;

    @RequestMapping("/basket")
    public String basketPage(Model model) {

        model.addAttribute("basketItems", items);
        return "/basket";
    }

    @PostMapping("/basket/add")
    public String add(@RequestParam("goods_id") Integer goodsId) {
        GoodsEntity item = goodsDao.findById(goodsId).orElse(null);
        if (item != null) {
            items.add(item);
        }
        return "redirect:/index";
    }

    @PostMapping("/basket/remove")
    public void remove(@RequestParam("goods_id") Integer goodsId) {
        if(items.removeIf(item -> Objects.equals(item.getGoods_id(), goodsId))) {
            System.out.println("item removed");
        } else {
            System.out.println("no such item");
        }
    }

}
