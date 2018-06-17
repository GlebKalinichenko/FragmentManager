package codelab.android.library.fragmentmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import codelab.android.library.fragmentmanagerlib.FragmentCoordinator;

public class JavaMainActivity extends AppCompatActivity {
    private final FragmentCoordinator coordinator = new FragmentCoordinator();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateFragment();
    }

    private void updateFragment() {
        Fragment javaFragment = JavaSampleFragment.getInstance();
        coordinator.add(JavaMainActivity.class.getCanonicalName(), R.id.container_layout, javaFragment,
                getSupportFragmentManager());
    }
}
