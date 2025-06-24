package com.example.fashionstore.repository;

import android.app.Application;

import com.example.fashionstore.dao.AppDatabase;
import com.example.fashionstore.dao.BestSellerDAO;

import java.util.List;

public class BestSellerRepository {

    private BestSellerDAO bestSellerDAO;

    public BestSellerRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        bestSellerDAO = database.bestSellerDAO();
    }

    public List<BestSellerDAO.BestSellerShoes> getBestSellerShoes() {
        return bestSellerDAO.getBestSellerShoes();
    }
}