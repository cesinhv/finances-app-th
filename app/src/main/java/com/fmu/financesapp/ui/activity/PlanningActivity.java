package com.fmu.financesapp.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fmu.financesapp.R;
import com.fmu.financesapp.fragments.GoalsFragment;

public class PlanningActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_goals);
        initTransActionRecyle(savedInstanceState);

    }

    private void initTransActionRecyle(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.rvPlanningCard, GoalsFragment.class, null)
                    .commit();
        }
    }
}