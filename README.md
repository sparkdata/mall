# mall（商城）

> Spring Cloud Mall

##### 技术栈

Spring Cloud、Docker、Eureka

---
## 所有服务
- 注册中心 server
- 网管服务 gateway
- 用户服务 user
- 订单服务 order
- 仓储服务 warehouse

---
## 项目架构
```mermaid
graph TD
server(注册中心)
server-->gateway(网关)
gateway-->user(用户)
gateway-->order(订单)
gateway-->warehouse(仓储)
user-->login(登录)
user-->register(注册)
user-->integral(积分)
warehouse-->logistics(物流)
warehouse-->inventory(库存)
```

## 流程图
```flow
begin=>start: 用户进入
account=>condition: 有账号?
register=>operation: 注册
login=>operation: 登录
see=>subroutine: 商品的查看与选购
commit=>operation: 提交订单
pay=>condition: 两小时内支付?
enter_info=>operation: 确认收货地址(选填)
warehouse=>operation: 仓储/物流
cancle=>operation: 订单取消
return=>condition: 退换货?
change=>operation: 寄回(换货再寄出)
enter=>operation: 确认收货/评价/售后
end=>end: 结束
begin->account
account(yes)->login->see
account(no)->register->see
see->commit->pay
pay(yes)->enter_info->warehouse->return
pay(no)->cancle->end
return(no)->enter->end
return(yes)->change->warehouse
```

## 订单状态

- 待支付 AWAIT_PAY
  - 付款 PAY_SUCCESS
  - 取消订单 PAY_CANCEL
  - 确认信息(多件商品) INFO_CONFIRM
- 待发货 AWAIT_SHIP
  - 待发货退款 AWAIT_SHIP_CANCEL
- 待收货 SHIPPED
  - 确认收货 RECEIVED
  - 待收货退款 SHIPPED_CANCEL
- 交易完成 FINISH
  - 评价 EVALUATION
  - 申请售后 AFTER_SALE
- 交易关闭 CLOSE
