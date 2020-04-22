package com.mall.order;

import com.mall.order.common.OrderStatusEnum;
import com.mall.order.dao.entity.OrderDetailEntity;
import com.mall.order.dao.entity.OrderEntity;
import com.mall.order.dao.mapper.OrderDetailMapper;
import com.mall.order.dao.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 模块名称: mall
 * 模块描述: 订单
 *
 * @author amos.wang
 * @date 2020/4/22 16:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyOrderTests {


    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Test
    public void insert() {
        String orderNo = "ORDER_" + System.currentTimeMillis();

        List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();

        OrderDetailEntity detailEntity1 = new OrderDetailEntity();
        detailEntity1.setOrderNo(orderNo);
        detailEntity1.setUserAddress("上海");
        detailEntity1.setBuyCount(3);
        detailEntity1.setProductName("水晶");
        detailEntity1.setUnitPrice(new BigDecimal(100));
        orderDetailEntities.add(detailEntity1);

        OrderDetailEntity detailEntity2 = new OrderDetailEntity();
        detailEntity2.setOrderNo(orderNo);
        detailEntity2.setUserAddress("北京");
        detailEntity2.setBuyCount(22);
        detailEntity2.setProductName("斗篷");
        detailEntity2.setUnitPrice(new BigDecimal(800));
        orderDetailEntities.add(detailEntity2);

        BigDecimal totalAmount = BigDecimal.ZERO;
        for (OrderDetailEntity orderDetailEntity : orderDetailEntities) {
            totalAmount = totalAmount.add(orderDetailEntity.getUnitPrice().multiply(new BigDecimal(orderDetailEntity.getBuyCount())));
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNo(orderNo);
        orderEntity.setOrderStatus(OrderStatusEnum.AWAIT_PAY);
        orderEntity.setConsumeAmount(totalAmount);
        orderEntity.setConsumeDate(LocalDate.now());
        orderEntity.setConsumeTime(LocalDateTime.now());
        orderEntity.setReduceAmount(BigDecimal.ZERO);
        orderEntity.setReduceReason(null);
        // applyOrderEntity.setSerialNo("ALI_PAY_" + System.currentTimeMillis());
        orderEntity.setUserId("10000");

        orderMapper.save(orderEntity);
        orderDetailMapper.saveAll(orderDetailEntities);
    }


}