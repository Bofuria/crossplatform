package com.webite.crossplatform;

import com.webite.crossplatform.entities.GoodsEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Hashtable;
import java.util.List;

@Controller
public class testController {

    @RequestMapping("/test")
    public String test(Model model) {

        return "test";
    }
}
