package com.example.user.api;

import com.example.user.bean.User;
import com.example.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName:
 * @Description:
 * @Author: Bruce_T
 * @data: 2019/9/5  11:25
 * @Version: 1.0
 * @Modified: By:
 */
@RequestMapping("/user")
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getById")
    public User getUserById(String id){
        logger.debug("param id : {}", id);
        return this.userService.findById(Integer.parseInt(id));
    }


    @RequestMapping("/getOrderByEureKa")
    public Object getUserByIdEureka(String orderId) {
//        String url = "http://192.168.3.5:8081/user/getById?id=" + userId;
        String url = "http://microservice-order/order/getOrderById?id=" + orderId;
        Object result = restTemplate.getForEntity(url, Object.class);
        return result;
    }

    @PostMapping("/testUserPost")
    public User testUserPost(@RequestBody User user) {
        logger.info("user{}",user);
        return user;
    }

}
