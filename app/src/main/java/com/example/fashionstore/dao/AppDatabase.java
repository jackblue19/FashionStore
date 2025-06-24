package com.example.fashionstore.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.fashionstore.entity.Account;
import com.example.fashionstore.entity.Cart;
import com.example.fashionstore.entity.Category;
import com.example.fashionstore.entity.Order;
import com.example.fashionstore.entity.Order_detail;
import com.example.fashionstore.entity.Shoes;
import com.example.fashionstore.entity.Shoes_Feedback;
import com.example.fashionstore.entity.Size;

@Database(entities = {Account.class, Category.class, Shoes.class, Cart.class, Order.class, Order_detail.class, Shoes_Feedback.class, Size.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract AccountDAO accountDao();
    public abstract ShoesDAO shoesDAO();
    public abstract SizeDAO sizeDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract OrderDAO orderDAO();
    public abstract Order_detailDAO orderDetailDAO();

    public abstract FeedbackDAO feedbackDao();

    public abstract CartDAO cartDAO();
    public abstract BestSellerDAO bestSellerDAO();


    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
