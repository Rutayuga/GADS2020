package com.example.gads2020.views.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gads2020.R;
import com.example.gads2020.databinding.ActivityHomepageBinding;
import com.example.gads2020.views.activities.fragments.LearningLeadersFragment;
import com.example.gads2020.views.activities.fragments.SkillLeadersFragment;
import com.google.android.material.tabs.TabLayoutMediator;

public class Homepage extends AppCompatActivity {
    ActivityHomepageBinding binding;
    //Tab Titles
    private String[] titles = new String[]{"Learning Leaders", "Skill IQ Leaders"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_homepage);

        initTabs();

        binding.btnSubmit.setOnClickListener(view -> startActivity(new Intent(this, SubmissionActivity.class)));
    }

    public void initTabs() {
        binding.viewPager.setAdapter(new ViewPagerFragmentAdapter(this));

        //Attach Tab Mediator
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            tab.setText(titles[position]);
        }).attach();
    }


    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {

        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new LearningLeadersFragment();
                case 1:
                    return new SkillLeadersFragment();
            }
            return new LearningLeadersFragment();
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }
}