package com.adventure_works.practice.DTO;

import com.adventure_works.practice.Models.OrderItemModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("name")
    private String name;


    @JsonProperty("price")
    private int price;

    @JsonProperty("text")
    private String text;

    @JsonProperty("orderItem")
    private OrderItemModel orderItem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OrderItemModel getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemModel orderItem) {
        this.orderItem = orderItem;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
