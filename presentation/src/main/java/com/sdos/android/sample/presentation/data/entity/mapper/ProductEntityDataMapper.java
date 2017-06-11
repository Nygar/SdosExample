package com.sdos.android.sample.presentation.data.entity.mapper;

import com.sdos.android.sample.presentation.data.entity.ProductEntity;
import com.sdos.android.sample.presentation.model.ProductModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Mapper class used to transform {@link ProductEntity} (in the data layer) to {@link ProductModel} in the
 * domain layer.
 */
public class ProductEntityDataMapper {

  @Inject
  public ProductEntityDataMapper() {}

  /**
   * Transform a {@link ProductEntity} into an {@link ProductModel}.
   *
   * @param productEntity Object to be transformed.
   * @return {@link ProductModel} if valid {@link ProductEntity} otherwise null.
   */
  public ProductModel transform(ProductEntity productEntity) {
    ProductModel res = new ProductModel();
    if (productEntity != null) {
      res.setZipcode(productEntity.getZipcode());
      res.setBusiness(productEntity.getBusiness());
      res.setCategory(productEntity.getCategory());
      res.setFarm_name(productEntity.getFarm_name());
      res.setFarmer_id(productEntity.getFarmer_id());
      res.setItem(productEntity.getItem());
      res.setPhone1(productEntity.getPhone1());
    }

    return res;
  }

  /**
   * Transform a List of {@link ProductEntity} into a Collection of {@link ProductModel}.
   *
   * @param inputEntityCollection Object Collection to be transformed.
   * @return {@link ProductModel} if valid {@link ProductEntity} otherwise null.
   */
  public List<ProductModel> transform(Collection<ProductEntity> inputEntityCollection) {
    List outputlist = new ArrayList();
    for (ProductEntity entity : inputEntityCollection) {
      ProductModel in = transform(entity);
      if (in != null) {
        outputlist.add(in);
      }
    }
    return outputlist;
  }

}
