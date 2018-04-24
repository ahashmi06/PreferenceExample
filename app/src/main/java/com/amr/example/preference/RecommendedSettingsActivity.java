package com.amr.example.preference;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

public class RecommendedSettingsActivity extends AppCompatActivity
        implements PreferenceFragment.OnPreferenceStartFragmentCallback {
    private static final String BACK_STACK = "back_stack";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommended_settings_activity);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(R.id.root_view, new SettingsActivity.GeneralPreferenceFragment())
                .add(R.id.root_view, new SettingsActivity.NotificationPreferenceFragment())
                .commit();
    }

    @Override
    public boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref) {
        replaceCurrentFragmentsWith(pref.getFragment(), pref.getExtras(), pref.getTitleRes(),
                pref.getTitle());
        return true;
    }

    private void replaceCurrentFragmentsWith(String fragmentClass, Bundle args, @StringRes int titleRes,
                                             CharSequence titleText) {
        Fragment f = Fragment.instantiate(this, fragmentClass, args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.root_view, f);
        if (titleRes != 0) {
            transaction.setBreadCrumbTitle(titleRes);
        } else if (titleText != null) {
            transaction.setBreadCrumbTitle(titleText);
        }
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(BACK_STACK);
        transaction.commitAllowingStateLoss();
    }
}
