package com.sdos.android.sample.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.model.UserModel;
import com.sdos.android.sample.presentation.presenter.UserPresenter;
import com.sdos.android.sample.presentation.view.LoginView;
import com.sdos.android.sample.presentation.view.di.components.LoginComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment for login users.
 */
public class LoginFragment extends BaseFragment implements LoginView {

    @BindView(R.id.edt_username)
    EditText editTextUsername;

    @BindView(R.id.edt_pass)
    EditText editTextPass;

    /**
     * Interface for listening events.
     */
    public interface LoginInterface {
        void onLogin(UserModel userModel);
    }

    private LoginInterface loginInterface;

    @Inject
    UserPresenter userPresenter;

    public LoginFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachListener();
        this.getComponent(LoginComponent.class).inject(this);
        userPresenter.setView(this);
    }

    public void attachListener(){
        try {
            this.loginInterface = (LoginInterface) getActivity();
        } catch (ClassCastException e) {
            Log.e(LoginInterface.class.getName(), e.getLocalizedMessage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        userPresenter.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        userPresenter.destroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public void renderUserLogin(UserModel userModel) {
        loginInterface.onLogin(userModel);
    }

    @OnClick(R.id.loginButton)
    void onLogin(){
        userPresenter.initialize(editTextUsername.getText().toString(),editTextPass.getText().toString());
    }

}
