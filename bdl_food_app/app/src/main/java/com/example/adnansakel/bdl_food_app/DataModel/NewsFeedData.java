package com.example.adnansakel.bdl_food_app.DataModel;

/**
 * Created by Adnan Sakel on 3/30/2016.
 */
public class NewsFeedData {

    private String DishName;
    private String Location;
    private String OrderBefore;
    private String Price;
    private String NumberofDishes;
    private String PostMessage;


    public NewsFeedData(){

    }


    public String getDishName() {
        return DishName;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) { Location = location; }

    public String getOrderBefore() {
        return OrderBefore;
    }

    public void setOrderBefore(String orderBefore) {
        OrderBefore = orderBefore;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getNumberofDishes() {
        return NumberofDishes;
    }

    public void setNumberofDishes(String numberofDishes) {
        NumberofDishes = numberofDishes;
    }

    public void setPostMessage(String postMessage){ PostMessage = postMessage;}

    public String getPostMessage(){return  PostMessage;}
}
