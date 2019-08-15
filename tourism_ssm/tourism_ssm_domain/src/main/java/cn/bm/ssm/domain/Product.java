package cn.bm.ssm.domain;

import cn.bm.ssm.utils.DateTypeStringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 产品信息-----》线路信息
 */
public class Product {
//    id varchar2(32) default SYS_GUID() PRIMARY KEY,
//    productNum VARCHAR2(50) NOT NULL,
//    productName VARCHAR2(50),
//    cityName VARCHAR2(50),
//    DepartureTime timestamp,
//    productPrice INT,
//    productDesc VARCHAR2(500),
//    productStatus INT,
//    CONSTRAINT product UNIQUE (id, productNum)
    private String id;  // 主键
    private String productNum; // 线路编号  --》唯一
    private String productName; // 线路名称
    private String cityName;  // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;   // 出发时间
    private String departureTimeStr; // 格式转换后的时间
    private Double productPrice;  //产品价格
    private String productDesc;  //产品描述
    private Integer productStatus;  //状态 0 关闭 1 开启
    private String productStatusStr; //状态转换后的文字显示

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (departureTime != null){
            departureTimeStr = DateTypeStringUtils.dateTypeString(departureTime,"yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus!=null){
            //状态 0 关闭 1 开启
            if (productStatus==0)
                productStatusStr = "关闭";
            if (productStatus==1)
                productStatusStr = "开启";
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
