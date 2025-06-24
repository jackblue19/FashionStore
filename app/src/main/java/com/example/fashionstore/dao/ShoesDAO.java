package com.example.fashionstore.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.fashionstore.entity.Shoes;
import com.example.fashionstore.entity.ShoesSale;

import java.util.List;

@Dao
public interface ShoesDAO {
    @Insert
    void insertShoe(Shoes shoe);

    @Insert
    long insertShoes(Shoes shoes);

    @Query("SELECT * FROM Shoes WHERE shoes_id = :shoesId")
    Shoes getShoesById(int shoesId);
    @Query("SELECT * FROM Shoes")
    List<Shoes> getAllShoes();

    @Update
    void updateShoes(Shoes shoe);
    @Query("UPDATE Shoes SET shoes_name = :name, price = :price, img = :img, description = :description, category_id = :category_id WHERE shoes_id = :id")
    void updateShoesById(int id, String name, Double price, String img, String description, int category_id);

    @Transaction
    @Query("UPDATE Shoes SET shoes_status = :shoesStatus WHERE shoes_id = :shoesId")
    void UpdateShoesStatus(int shoesId, int shoesStatus);

    @Query("SELECT s.shoes_id,s.shoes_name,s.img\n" +
            "               ,COUNT(DISTINCT od.order_id) * od.quantity  AS item_bought,\n" +
            "\t\t\t   SUM(o.totalPrice) as total_amount\n" +
            "               FROM Order_detail od join Shoes s on od.shoes_id = s.shoes_id\n" +
            "               join [Order] o on o.order_id = od.order_id\n" +
            "               GROUP BY s.shoes_id,s.shoes_name,s.img\n" +
            "               ORDER BY item_bought DESC")
    List<ShoesSale> ListShoesSale();

    @Query("SELECT * FROM Shoes WHERE shoes_id = :shoesId")
    Shoes getShoeById(int shoesId);

    @Query("SELECT * FROM Shoes WHERE " +
            "(:keyword IS NULL OR shoes_name LIKE :keyword) AND " +
            "(:minPrice IS NULL OR price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR price <= :maxPrice) AND " +
            "(:categoryId IS NULL OR category_id = :categoryId)")
    List<Shoes> searchShoes(String keyword, Double minPrice, Double maxPrice, Integer categoryId);

    @Query("SELECT * FROM Shoes ORDER BY shoes_id DESC LIMIT 4")
    List<Shoes> getLatestShoes();
}

