package com.webite.crossplatform;

import com.webite.crossplatform.dao.GoodsDao;
import com.webite.crossplatform.dao.OrderDao;
import com.webite.crossplatform.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class basketController {

    private List<GoodsEntity> items = new ArrayList<>();

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    private OrderDao orderRepository;

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
    public String submitOrder(@ModelAttribute OrderForm orderForm) {
        // Map orderForm to Order entity
        OrdersEntity order = new OrdersEntity();

        order.setAddress(orderForm.getDeliveryAddress());
        order.setPaymentType(new PaymentTypesEntity(orderForm.getPaymentType()));
        order.setStatus(new StatusesEntity(1L));
        order.setTotalPrice(orderForm.getTotalPrice());

        List<GoodsEntity> goods = new ArrayList<>();
        for (GoodsEntity orderItem : orderForm.getOrderItems()) {
            GoodsEntity item = new GoodsEntity();
            item.setGoods_id(orderItem.getGoods_id());
            item.setName(orderItem.getName());
            item.setQuantity(orderItem.getQuantity());
            item.setPrice(orderItem.getPrice());
            goods.add(item);
        }
        order.setGoods(goods);

        // Save order to database
        orderRepository.save(order);
        return "redirect:/complete";
    }

    @RequestMapping("/complete")
    public ModelAndView completePage(Model model) {
        ModelAndView modelAndView = new ModelAndView("redirecting");
        modelAndView.addObject("delay", 5000); // 5 second delay
        return modelAndView;
    }

}
