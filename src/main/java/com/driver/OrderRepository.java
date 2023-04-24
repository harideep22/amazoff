package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {

    HashMap<String,Order> orderHashMap=new HashMap<>();
    HashMap<String,DeliveryPartner> deliveryPartnerHashMap=new HashMap<>();
    HashMap<String,DeliveryPartner> orderIdPartnerHashMap=new HashMap<>();
    HashMap<DeliveryPartner, List<String>> deliveryPartnerOrderListHashMap=new HashMap<>();

    public void addOrder(Order order){
        String key= order.getId();
        orderHashMap.put(key,order);
    }
    public void addPartner(String partnerId){
        DeliveryPartner dp=new DeliveryPartner(partnerId);
        deliveryPartnerHashMap.put(partnerId,dp);
    }
    public void addOrderPartnerPair(String orderId, String partnerId){
        DeliveryPartner dp=deliveryPartnerHashMap.get(partnerId);
        dp.setNumberOfOrders(1);
        orderIdPartnerHashMap.put(orderId,dp);
        List<String> ordersId=deliveryPartnerOrderListHashMap.getOrDefault(partnerId,new ArrayList<>());
        ordersId.add(orderId);
        deliveryPartnerOrderListHashMap.put(dp,ordersId);
    }
    public Order getOrderById(String orderId){
        return orderHashMap.get(orderId);
    }
}
