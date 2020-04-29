package com.github.hailouwang.demosforapi.flutter.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.hailouwang.demosforapi.DemosApp;
import com.github.hailouwang.demosforapi.R;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;

/**
 * https://flutter.cn/docs/development/add-to-app/android/add-flutter-screen
 */
public class FlutterDemoFragment1 extends Fragment {

    private Button addFlutterBtn;
    private Button changeRouter;
    private Button useCacheEngine;
    private Button stopDestoryCacheEngine;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flutter_demo1_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addFlutterBtn = view.findViewById(R.id.addFlutter);
        addFlutterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 等同于：
                 * return new Intent(context, activityClass)
                 *           .putExtra(EXTRA_INITIAL_ROUTE, initialRoute)
                 *           .putExtra(EXTRA_BACKGROUND_MODE, backgroundMode)
                 *           .putExtra(EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, true);
                 */
                Intent flutterIntent = FlutterActivity.createDefaultIntent(getContext());
                startActivity(flutterIntent);
            }
        });

        changeRouter = view.findViewById(R.id.addFlutterChangeRouter);
        changeRouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flutterIntent = FlutterActivity
                        .withNewEngine()
                        .initialRoute("/d")
                        .build(getContext());

                startActivity(flutterIntent);
            }
        });

        useCacheEngine = view.findViewById(R.id.cacheFlutterEngine);
        useCacheEngine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flutterIntent = FlutterActivity
                        .withCachedEngine(DemosApp.getCacheEngine())
                        .build(getContext());

                startActivity(flutterIntent);
            }
        });

        stopDestoryCacheEngine = view.findViewById(R.id.stopCacheFlutterEngine);
        stopDestoryCacheEngine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DemosApp.getFlutterEngine().destroy();
            }
        });
    }
}