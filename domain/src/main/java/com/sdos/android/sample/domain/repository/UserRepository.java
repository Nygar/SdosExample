package com.sdos.android.sample.domain.repository;

import com.sdos.android.sample.domain.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting {@link User} related data.
 */
public interface UserRepository {
  /**
   * Get an {@link Observable} which will emit a List of {@link User}.
   */
  List<User> users();

}
