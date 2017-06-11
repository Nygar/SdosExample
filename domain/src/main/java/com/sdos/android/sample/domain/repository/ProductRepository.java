package com.sdos.android.sample.domain.repository;

import com.sdos.android.sample.domain.Product;
import java.util.List;

/**
 * Interface that represents a Repository for getting {@link Product} related data.
 */
public interface ProductRepository {
  /**
   * Get an {@link List} which will emit a List of {@link Product}.
   */
  List<Product> products();

}
