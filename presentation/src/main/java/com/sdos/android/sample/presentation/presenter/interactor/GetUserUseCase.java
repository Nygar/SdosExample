package com.sdos.android.sample.presentation.presenter.interactor;

import javax.inject.Inject;

import amitkma.stitch.annotations.CallOnAnyThread;


/**
 * This class is an implementation that represents a use case for
 * retrieving data related.
 */
public class GetUserUseCase {

  /**
   * Interface for listening events.
   */
  public interface UserRepository {
    void users(String name, String pass);
  }

  private String name;
  private String pass;

  public static final int PRIORITY = 1;
  private UserRepository userRepository;

  @Inject
  public GetUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @CallOnAnyThread
  public void execute(){
    userRepository.users(name, pass);
  }

  public void setParams(String name, String pass){
    this.name =name;
    this.pass =pass;
  }
}
