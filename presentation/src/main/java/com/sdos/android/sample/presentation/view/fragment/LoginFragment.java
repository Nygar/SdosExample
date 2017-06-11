package com.sdos.android.sample.presentation.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.view.di.components.LoginComponent;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment for login users.
 */
public class LoginFragment extends BaseFragment  {

    /**
     * Interface for listening events.
     */
    public interface LoginInterface {
        void onLogin();
    }

    private LoginInterface loginInterface;

    public LoginFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachListener();
        this.getComponent(LoginComponent.class).inject(this);
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

    @OnClick(R.id.loginButton)
    void onLogin(){
        loginInterface.onLogin();
    }

}
