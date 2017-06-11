package com.sdos.android.sample.presentation.view.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.view.di.components.MainComponent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment for login users.
 */
public class AdminFragment extends BaseFragment  {

    @BindView(R.id.admin_text_progress)
    TextView textProgress;

    @BindView(R.id.admin_seekbar)
    SeekBar seekBar;


    /**
     * Interface for listening events.
     */
    public interface AdminInterface {
        void onCloseSesion();
    }

    private AdminInterface adminInterface;

    public AdminFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachListener();
        this.getComponent(MainComponent.class).inject(this);
    }

    public void attachListener(){
        try {
            this.adminInterface = (AdminInterface) getActivity();
        } catch (ClassCastException e) {
            Log.e(AdminInterface.class.getName(), e.getLocalizedMessage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_admin, container, false);
        ButterKnife.bind(this, fragmentView);
        inicializeFragment();

        return fragmentView;
    }

    private void inicializeFragment(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textProgress.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @OnClick(R.id.admin_saveButton)
    void saveTask(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.admin_dialog_description)
                .setPositiveButton(R.string.admin_dialog_closesesion, (dialog, id) -> {
                    adminInterface.onCloseSesion();
                })
                .setNegativeButton(R.string.admin_dialog_newTask, (dialog, id) -> dialog.dismiss());

        builder.create().show();
    }

}
