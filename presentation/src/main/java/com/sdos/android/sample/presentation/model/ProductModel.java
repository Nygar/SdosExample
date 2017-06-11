package com.sdos.android.sample.presentation.model;

/**
 * Class that represents a task in the presentation layer.
 */
public class ProductModel {

  private String zipcode;
  private String item;
  private String business;
  private String farmer_id;
  private String category;
  private String farm_name;
  private String phone1;

  public ProductModel() {
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getBusiness() {
    return business;
  }

  public void setBusiness(String business) {
    this.business = business;
  }

  public String getFarmer_id() {
    return farmer_id;
  }

  public void setFarmer_id(String farmer_id) {
    this.farmer_id = farmer_id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getFarm_name() {
    return farm_name;
  }

  public void setFarm_name(String farm_name) {
    this.farm_name = farm_name;
  }

  public String getPhone1() {
    return phone1;
  }

  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }
}
