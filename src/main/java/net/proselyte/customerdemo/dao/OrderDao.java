package net.proselyte.customerdemo.dao;

import lombok.Data;
import net.proselyte.customerdemo.model.Order;

@Data
public class OrderDao {
    private String goods;
    private Integer prise;

    private String date;

//    private Long id;

    public static OrderDao toModel(Order order){
        OrderDao orderDao = new OrderDao();
        orderDao.setDate(order.getDate());
//        orderDao.setId(order.getId());
        orderDao.setGoods(order.getGoods());
        orderDao.setPrise(order.getPrise());

        return orderDao;
    }
}
