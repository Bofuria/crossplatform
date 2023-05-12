package com.webite.crossplatform;

import com.webite.crossplatform.dao.GoodsDao;
import com.webite.crossplatform.dao.OrderDao;
import com.webite.crossplatform.dao.OrdersHasGoodsDao;
import com.webite.crossplatform.entities.*;
import jakarta.persistence.criteria.Order;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.*;

@Controller
public class basketController {

    private List<GoodsEntity> items = new ArrayList<>();

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    private OrderDao ordersDao;

    @Autowired
    private OrdersHasGoodsDao ordersHasGoodsDao;

    @RequestMapping("/basket")
    @Profile("basket")
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

    @PostMapping("/basket/submit")
    public String submitOrder(HttpServletRequest request) {
        // get form data from request
        String paymentTypeStr = request.getParameter("paymentType");
        String address = request.getParameter("address");
        String summaryPriceStr = request.getParameter("summaryPrice");

        // Convert the string values to integers
        int paymentType = Integer.parseInt(paymentTypeStr);
        double summaryPrice = Double.parseDouble(summaryPriceStr);

        Map<String, String[]> items = request.getParameterMap();

        // create new order object
        OrdersEntity order = new OrdersEntity();
        order.setPaymentType(paymentType);
        order.setAddress(address);
        order.setTotalPrice(summaryPrice);

        // save order to orders table
        ordersDao.save(order);

        // save order items to orders_has_goods table
        for (Map.Entry<String, String[]> item : items.entrySet()) {
            String key = item.getKey();
            String[] values = item.getValue();
            if (key.startsWith("item[")) {
                Integer goodsId = Integer.valueOf(values[0]);
                Integer quantity = Integer.valueOf(request.getParameter("quantity[" + goodsId + "]"));
                Double price = Double.valueOf(request.getParameter("totalPrice[" + goodsId + "]"));

                // look up the orders and goods entities from the database
                OrdersEntity ordersEntity = ordersDao.findById(order.getId()).get();
                GoodsEntity goodsEntity = goodsDao.findById(goodsId).get();

                // create and save the orders_has_goods entity
                OrdersHasGoodsEntity orderItem = new OrdersHasGoodsEntity();
                orderItem.setOrdersEntity(ordersEntity);
                orderItem.setGoodsEntity(goodsEntity);
                orderItem.setQuantity(quantity);
                orderItem.setPrice(price);
                ordersHasGoodsDao.save(orderItem);
            }
        }

        return "redirect:/index";
    }

    @Transactional
    public void saveOrder(OrdersEntity order) {
        ordersDao.save(order);
    }

}
