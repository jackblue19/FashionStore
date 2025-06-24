package com.example.fashionstore.domain.iRepository.callback;

import com.example.fashionstore.domain.model.User;

public interface OnUserFetchedCallback {
    void onResult(User user);
}
