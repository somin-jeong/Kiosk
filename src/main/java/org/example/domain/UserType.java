package org.example.domain;

public enum UserType {
    VETERAN("국가유공자", 0.1),
    SOLDIER("군인", 0.05),
    STUDENT("학생", 0.03),
    REGULAR("일반", 0.0);

    private final String userType;
    private final double discountRate;

    UserType(String userType, double discountRate) {
        this.userType = userType;
        this.discountRate = discountRate;
    }

    public String getUserType() {
        return userType;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
