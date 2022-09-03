//package com.example.order.constant.api;
//
//import com.example.order.bean.Order;
//import com.example.order.bean.TransOrderInfoPO;
//import com.example.order.bean.User;
//import com.example.order.feign.UserMicroServiceFeignClient;
//import com.example.order.service.OrderService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName:
// * @Description:
// * @Author: Bruce_T
// * @data: 2019/9/5  11:25
// * @Version: 1.0
// * @Modified: By:
// */
//@RequestMapping("/order")
//@RestController
//public class OrderController {
//
//    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
//
//    @Autowired
//    private OrderService userService;
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private UserMicroServiceFeignClient userMicroServiceFeignClient;
//
//    @RequestMapping("/getOrderById")
//    public TransOrderInfoPO getOrderById(String id){
//        logger.debug("param id : {}", id);
//        return userService.findById(Integer.parseInt(id));
//    }
//
//    @RequestMapping("/getByIdEureka")
//    public Object getUserByIdEureka(String userId) {
////        String url = "http://192.168.3.5:8081/user/getById?id=" + userId;
//        String url = "http://microservice-user/user/getById?id=" + userId;
//        Object result = restTemplate.getForEntity(url, Object.class);
//        return result;
//    }
//
//
//    @RequestMapping("/getByIdFeign")
//    public Object getUserByIdFeign(String userId) {
//        Object result = userMicroServiceFeignClient.getUserById(userId);
//        return result;
//    }
//
//    @RequestMapping("/testUserPost")
//    public Object testUserPost(User user) {
//        User users = userMicroServiceFeignClient.testUserPost(user);
//        logger.info("user{}",users);
//        return users;
//    }
//
//
//
//
//}
