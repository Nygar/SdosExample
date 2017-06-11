package com.sdos.android.sample.presentation.view.navigation;

import android.app.Activity;
import android.content.Intent;

import com.sdos.android.sample.presentation.view.activity.LoginActivity;
import com.sdos.android.sample.presentation.view.activity.MainActivity;
import com.sdos.android.sample.presentation.view.activity.WebServiceActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

  @Inject
  Navigator() {
    //empty
  }

  /**
   * Goes to the login screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToLogin(Activity context) {
    if (context != null) {
      Intent intentToLaunch = LoginActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
      context.finish();
    }
  }

  /**
   * Goes to the main screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToMain(Activity context,int option) {
    if (context != null) {
      Intent intentToLaunch = MainActivity.getCallingIntent(context,option);
      context.startActivity(intentToLaunch);
      context.finish();
    }
  }

  /**
   * Goes to the webService screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToWebService(Activity context) {
    if (context != null) {
      Intent intentToLaunch = WebServiceActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }
}
