package com.example.fashionstore.repository;

import android.content.Context;

import com.example.fashionstore.dao.AppDatabase;
import com.example.fashionstore.dao.CategoryDAO;
import com.example.fashionstore.entity.Category;
import com.example.fashionstore.entity.CategorySale;

import java.util.List;

public class CategoryRepository {
    CategoryDAO categoryDAO;
    public CategoryRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        categoryDAO = appDatabase.categoryDAO();
    }
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public List<CategorySale> ListCategorySale() {
        return categoryDAO.ListCategorySale();
    }

    public void insertCategory(Category category) {
        categoryDAO.insertCategory(category);
    }
}
