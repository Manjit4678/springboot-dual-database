package com.example.dualdb.spring_boot_dual_database.dto;

import java.util.List;

public class ClaimRequest {
    private Long userId;
    private List<String> productIds;
    // Getters & Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}
