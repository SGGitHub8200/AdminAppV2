package com.pratham.admin.activities.ui;

import android.annotation.SuppressLint;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.pratham.admin.R;
import com.pratham.admin.activities.ui.assignedToMe.AssignedToMe;
import com.pratham.admin.activities.ui.assignedToMe.AssignedToMe_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;

@SuppressLint("NonConstantResourceId")
@EFragment(R.layout.fragment_first)
public class FirstFrag extends Fragment {

    @ViewById(R.id.assigned_to_me)
    LinearLayout assigendToMe;

    public FirstFrag() {
        // Required empty public constructor
    }

    @AfterViews
    public void init(){

    }

    @Click(R.id.assigned_to_me)
    public void setAssigendToMe(){
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AssignedToMe_()).addToBackStack("d").commit();
    }
}