package com.andy.seckill.service;

import com.andy.seckill.domain.Goods;
import com.andy.seckill.domain.OrderItem;
import com.andy.seckill.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *
 * @author Leone
 * @since 2018-10-26
 **/
@Service
public class OrderItemService {

    @Resource
    private OrderService orderService;

    @Resource
    private UserService userService;

    @Resource
    private OrderItemMapper orderDetailMapper;

    /**
     * 保存订单详情
     *
     * @param goods
     * @param orderId
     */
    public OrderItem save(Goods goods, Long orderId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodsCount(1);
        orderItem.setCreateTime(new Date());
        orderItem.setGoodsId(goods.getGoodsId());
        orderItem.setOrderId(orderId);
        orderItem.setGoodsPicture(goods.getGoodsPicture());
        orderItem.setGoodsPrice(goods.getDiscountPrice());
        orderDetailMapper.save(orderItem);
        return orderItem;
    }

}