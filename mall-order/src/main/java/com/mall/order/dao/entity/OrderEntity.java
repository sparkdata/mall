package com.mall.order.dao.entity;

import com.mall.common.pojo.dao.BaseEntity;
import com.mall.order.common.OrderStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * PROJECT: order
 * DESCRIPTION: 订单表
 *
 * @author Daoyuan
 * @date 2018/12/26
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@Entity
@Table(name = "po_order")
public class OrderEntity extends BaseEntity {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 交易流水号
     */
    private String serialNo;
    /**
     * 消费金额
     */
    private BigDecimal consumeAmount;
    /**
     * 订单状态
     */
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;


    /**
     * 消费日期
     */
    private LocalDate consumeDate;
    /**
     * 消费时间
     */
    private LocalDateTime consumeTime;

    /**
     * 优惠券ID
     */
    private String reduceNo;
    /**
     * 优惠金额
     */
    private BigDecimal reduceAmount;
    /**
     * 优惠原因
     */
    private String reduceReason;

    /**
     * 备注
     */
    private String description;

}
