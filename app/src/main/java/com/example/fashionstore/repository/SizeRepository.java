package com.example.fashionstore.repository;

import android.content.Context;

import com.example.fashionstore.dao.AppDatabase;
import com.example.fashionstore.dao.SizeDAO;
import com.example.fashionstore.entity.Size;

public class SizeRepository {
    SizeDAO sizeDAO;
    public SizeRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        sizeDAO = appDatabase.sizeDAO();
    }
    public void insertSize(Size size) {
        sizeDAO.insertSize(size);
    }
}
