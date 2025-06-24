package com.example.fashionstore.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.fashionstore.entity.Size;

import java.util.List;

@Dao
public interface SizeDAO {
    @Insert
    void insertSize(Size size);
    @Insert
    void insertSizes(List<Size> sizes);
}
