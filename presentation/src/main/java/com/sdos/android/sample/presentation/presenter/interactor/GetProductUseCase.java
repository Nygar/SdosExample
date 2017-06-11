package com.sdos.android.sample.presentation.presenter.interactor;

import javax.inject.Inject;

import amitkma.stitch.annotations.CallOnAnyThread;
import amitkma.stitch.annotations.CallOnNewThread;


/**
 * This class is an implementation that represents a use case for
 * retrieving data related.
 */
public class GetProductUseCase{

  /**
   * Interface for listening events.
   */
  public interface ProductRepository {
    void products(String category,String item);
  }

  private String category;
  private String item;

  public static final int PRIORITY = 1;
  private ProductRepository productRepository;

  @Inject
  public GetProductUseCase(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @CallOnAnyThread
  public void execute(){
    productRepository.products(category,item);
  }

  public void setParams(String category, String item){
    this.category=category;
    this.item=item;
  }
}
