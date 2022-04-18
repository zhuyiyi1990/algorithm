package com.github.zhuyiyi1990.algorithm.other.jd.interview001;

//请实现一个Java方法，对指定用户筛选其购买过的商品。方法入参为：所有用户的购买记
//录列表List<PurchaseRecord>和指定用户id列表List<Long>，其中PurchaseRecord类包
//括用户id和商品编号。请筛选出购买记录中指定用户购买过的所有商品编号，方法出参为
//Map<Long,Collection<String>>
//1)请给出该方法具体实现
//求助这个《Collection里按照买的数量逆序排序》该怎么写呢
public class PurchaseRecord {

    private Long id;

    private String product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

}