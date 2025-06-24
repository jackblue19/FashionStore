package com.example.fashionstore.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.fashionstore.entity.Order_detail;

import java.util.List;

@Dao
public interface Order_detailDAO {
    @Query("SELECT * FROM Order_detail WHERE order_id = :order_id")
    List<Order_detail> getOrderDetailsByOrderId(int order_id);

    @Query("SELECT * FROM Order_detail WHERE order_id = :order_id LIMIT 1")
    List<Order_detail> getOrderDetailsByOrderIdTop1(int order_id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertOrderDetail(Order_detail order);
}
