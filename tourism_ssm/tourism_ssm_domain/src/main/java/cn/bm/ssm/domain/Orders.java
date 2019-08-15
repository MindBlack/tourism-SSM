package cn.bm.ssm.domain;

import cn.bm.ssm.utils.DateTypeStringUtils;

import java.util.Date;
import java.util.List;

/**
 * 订单信息----》》所有订单
 */
public class Orders {
    /*
  id          VARCHAR2(32) default SYS_GUID() not null,  // ---》主键
  ordernum    VARCHAR2(20) not null,  // ---》订单编号
  ordertime   TIMESTAMP(6), // ---》订单时间
  peoplecount INTEGER,  //  ---》出行人数
  orderdesc   VARCHAR2(500),  //  ---订单信息
  paytype     INTEGER,  // ---》支付方式（0 支付宝 1 微信 2 其他）
  orderstatus INTEGER, // ---》订单状态 （0 未支付 1 已支付）
  productid   VARCHAR2(32), // ---》产品id外键
  memberid    VARCHAR2(32)*/  // ---》会员联系人id外键
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private Integer peopleCount;
    private List<Traveller> travellerList;  //旅客表
    private String orderDesc;
    private Integer payType;

    public String getPayTypeStr() {
        if (payType!=null){
            //0 支付宝 1 微信 2 其他
            if (payType==0)
                payTypeStr = "支付宝";
            if (payType==1)
                payTypeStr = "微信";
            if (payType==2)
                payTypeStr = "其他";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    private String payTypeStr;
    private Integer orderStatus;
    private String orderStatusStr;

    public String getOrderStatusStr() {
        if (orderStatus!=null){
            //0 未支付 1 已支付
            if (orderStatus==0)
                orderStatusStr = "未支付";
            if (orderStatus==1)
                orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    private String productId;
    private Product product;  // 产品表
    private String memberId;
    private Member member;  // 会员表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime!=null){
            orderTimeStr = DateTypeStringUtils.dateTypeString(orderTime, "yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public List<Traveller> getTravellerList() {
        return travellerList;
    }

    public void setTravellerList(List<Traveller> travellerList) {
        this.travellerList = travellerList;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
