package com.sdos.android.sample.presentation.view.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.view.di.components.WebServiceComponent;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment for login users.
 */
public class WSSearchFragment extends BaseFragment implements Validator.ValidationListener  {

    @NotEmpty(messageResId = R.string.exception_empty_edt)
    @BindView(R.id.edt_search_category)
    EditText edtCategory;
    @NotEmpty(messageResId = R.string.exception_empty_edt)
    @BindView(R.id.edt_search_item)
    EditText edtItem;

    /**
     * Interface for listening events.
     */
    public interface WsSeachInterface {
        void onSeacrh(String category, String item);
    }

    private WsSeachInterface wsSeachInterface;

    private Validator validator;

    public WSSearchFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachListener();
        this.getComponent(WebServiceComponent.class).inject(this);
    }

    public void attachListener(){
        try {
            this.wsSeachInterface = (WsSeachInterface) getActivity();
        } catch (ClassCastException e) {
            Log.e(WsSeachInterface.class.getName(), e.getLocalizedMessage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_wssearch, container, false);
        ButterKnife.bind(this, fragmentView);

        validator = new Validator(this);
        validator.setValidationListener(this);

        return fragmentView;
    }

    @OnClick(R.id.searchButton)
    void onLogin(){
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        wsSeachInterface.onSeacrh(edtCategory.getText().toString(),edtItem.getText().toString());
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        }
    }

}
