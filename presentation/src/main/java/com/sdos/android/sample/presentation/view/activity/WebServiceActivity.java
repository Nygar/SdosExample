package com.sdos.android.sample.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toolbar;

import com.irozon.library.HideKey;
import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.R2;
import com.sdos.android.sample.presentation.view.di.HasComponent;
import com.sdos.android.sample.presentation.view.di.components.DaggerWebServiceComponent;
import com.sdos.android.sample.presentation.view.di.components.WebServiceComponent;
import com.sdos.android.sample.presentation.view.fragment.WSListFragment;
import com.sdos.android.sample.presentation.view.fragment.WSListFragmentBuilder;
import com.sdos.android.sample.presentation.view.fragment.WSSearchFragment;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Activity that shows details of a certain message.
 */
public class WebServiceActivity extends BaseActivity implements HasComponent<WebServiceComponent>,WSSearchFragment.WsSeachInterface{

    @BindString(R.string.wservice_title)
    String webServiceString;
    @BindDrawable(R.drawable.ic_arrow_back_black_24dp)
    Drawable backIcon;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, WebServiceActivity.class);
    }

    private WebServiceComponent webServiceComponent;

    @BindView(R2.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_toolbar);

        ButterKnife.bind(this);
        HideKey.initialize(this);
        this.initializeActivity(savedInstanceState);
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.webServiceComponent = DaggerWebServiceComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        setTitle(webServiceString);
        setActionBar(toolbar);

        toolbar.setNavigationIcon(backIcon);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        if (savedInstanceState == null) {
            addFragment(R.id.content_frame, new WSSearchFragment());
        }
    }

    @Override
    public WebServiceComponent getComponent() {
        return webServiceComponent;
    }

    @Override
    public void onSeacrh(String category, String item) {
        WSListFragment listFragment = new WSListFragmentBuilder(category,item).build();
        replaceFragment(R.id.content_frame, listFragment);
    }
}
