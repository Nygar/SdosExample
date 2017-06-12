package com.sdos.android.sample.presentation.view.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.sdos.android.sample.presentation.R;
import com.sdos.android.sample.presentation.model.TaskModel;
import com.sdos.android.sample.presentation.presenter.TaskPresenter;
import com.sdos.android.sample.presentation.view.MainView;
import com.sdos.android.sample.presentation.view.di.components.MainComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindArray;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment for login users.
 */
public class AdminFragment extends BaseFragment implements MainView,Validator.ValidationListener {

    @BindView(R.id.admin_text_progress)
    TextView textProgress;

    @BindView(R.id.admin_seekbar)
    SeekBar seekBar;

    @BindView(R.id.admin_type_task_spinner)
    Spinner spinner;

    @NotEmpty(messageResId = R.string.exception_empty_edt)
    @BindView(R.id.task_name)
    EditText taskName;

    @BindArray(R.array.task_type)
    String[] typeTask;

    @Inject
    TaskPresenter taskPresenter;

    private Validator validator;

    /**
     * Interface for listening events.
     */
    public interface AdminInterface {
        void onCloseSesion();
    }

    private AdminInterface adminInterface;

    private TaskModel taskModel;

    public AdminFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachListener();
        this.getComponent(MainComponent.class).inject(this);
        taskPresenter.setView(this);
        taskModel = new TaskModel();
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

        validator = new Validator(this);
        validator.setValidationListener(this);

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

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, typeTask);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                taskModel.setTypeTask(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @OnClick(R.id.admin_saveButton)
    void saveTask(){

        validator.validate();

    }

    @Override
    public void onResume() {
        super.onResume();
        taskPresenter.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        taskPresenter.destroy();
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
    public void renderTaskList(List<TaskModel> taskModels) {

    }

    @Override
    public void responseTask(String response) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.admin_dialog_description)
                .setPositiveButton(R.string.admin_dialog_closesesion, (dialog, id) -> adminInterface.onCloseSesion())
                .setNegativeButton(R.string.admin_dialog_newTask, (dialog, id) -> dialog.dismiss());

        builder.create().show();
    }

    @Override
    public void onValidationSucceeded() {
        taskModel.setEnd(false);
        taskModel.setDuration(Integer.parseInt(textProgress.getText().toString()));
        taskModel.setName(taskName.getText().toString());

        taskPresenter.postTask(taskModel);
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
