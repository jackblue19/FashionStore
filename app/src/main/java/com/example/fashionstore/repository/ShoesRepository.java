package com.example.fashionstore.repository;

import android.content.Context;

import com.example.fashionstore.dao.AppDatabase;
import com.example.fashionstore.dao.CategoryDAO;
import com.example.fashionstore.dao.ShoesDAO;
import com.example.fashionstore.entity.Category;
import com.example.fashionstore.entity.Shoes;
import com.example.fashionstore.entity.ShoesSale;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShoesRepository {
    ShoesDAO shoesDAO;
    CategoryDAO categoryDAO;
    private ExecutorService executorService;

    public ShoesRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        shoesDAO = appDatabase.shoesDAO();
        executorService = Executors.newSingleThreadExecutor();
        categoryDAO = appDatabase.categoryDAO();
    }

    public void insertShoe(Shoes shoe) {
        shoesDAO.insertShoe(shoe);
    }

    public Shoes insertShoes(Shoes shoes) {
        long shoesId = shoesDAO.insertShoes(shoes); // Lấy ID vừa thêm
        if (shoesId > 0) {
            return shoesDAO.getShoesById((int) shoesId); // Lấy đối tượng Shoes đầy đủ
        } else {
            return null;
        }
    }

    public List<Shoes> getAllShoes() {
        return shoesDAO.getAllShoes();
    }

    public void updateShoes(Shoes shoe) {
        shoesDAO.updateShoes(shoe);
    }

    public void updateShoesById(int id, String name, Double price, String img, String description, int category_id) {
        shoesDAO.updateShoesById(id, name, price, img, description, category_id);
    }

    public void UpdateShoesStatus(int shoesId, int shoesStatus) {
        executorService.execute(() -> shoesDAO.UpdateShoesStatus(shoesId, shoesStatus));
    }

    public List<ShoesSale> ListShoesSale() {
        return shoesDAO.ListShoesSale();
    }

    public Shoes getShoeById(int shoesId) {
        return shoesDAO.getShoeById(shoesId);
    }

    public List<Shoes> searchShoes(String keyword, Double minPrice, Double maxPrice, String categoryName) {
        Integer categoryId = null;

        if (categoryName != null && !categoryName.trim().isEmpty() && !categoryName.equals("All")) {
            Category category = categoryDAO.getCategoryByName(categoryName);
            if (category != null) {
                categoryId = category.category_id;
            }
        }

        if (keyword != null && !keyword.trim().isEmpty()) {
            keyword = "%" + keyword + "%";
        } else {
            keyword = null;
        }

        if (minPrice != null && minPrice == 0) minPrice = null;
        if (maxPrice != null && maxPrice == 0) maxPrice = null;

        return shoesDAO.searchShoes(keyword, minPrice, maxPrice, categoryId);
    }

    public void getShoesById(int shoesId, OnShoesFetchListener listener) {
        executorService.execute(() -> {
            Shoes shoes = shoesDAO.getShoesById(shoesId);
            listener.onShoesFetched(shoes);
        });
    }

    public interface OnShoesFetchListener {
        void onShoesFetched(Shoes shoes);
    }

    public List<Shoes> getLatestShoes(){
        return shoesDAO.getLatestShoes();
    }
}
