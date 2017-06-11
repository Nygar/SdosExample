package com.sdos.android.sample.presentation.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.view.di.components.WebServiceComponent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment for login users.
 */
public class WSSearchFragment extends BaseFragment  {

    @BindView(R.id.edt_search_category)
    EditText edtCategory;

    @BindView(R.id.edt_search_item)
    EditText edtItem;

    /**
     * Interface for listening events.
     */
    public interface WsSeachInterface {
        void onSeacrh(String category, String item);
    }

    private WsSeachInterface wsSeachInterface;

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

        return fragmentView;
    }

    @OnClick(R.id.searchButton)
    void onLogin(){
        wsSeachInterface.onSeacrh(edtCategory.getText().toString(),edtItem.getText().toString());
    }

}
