/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.zup.beagle.sample.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;


public class ActivityFinisher2 implements Runnable{

    private ActivityLifecycleMonitor activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance();
    private CountDownLatch latch;
    private List<Activity> activities;

    public ActivityFinisher2(CountDownLatch latch, List<Activity> activities) {
        this.latch = latch;
        this.activities = activities;
    }

    public ActivityFinisher2() {

    }

    public static void finishOpenActivities() {
        new Handler(Looper.getMainLooper()).post(new ActivityFinisher2());
    }
    @Override
    public void run() {
        List<Activity> activities = this.activities != null ? this.activities: new ArrayList<Activity>();

        for (Stage stage : EnumSet.range(Stage.CREATED, Stage.STOPPED)) {
            activities.addAll(activityLifecycleMonitor.getActivitiesInStage(stage));
        }

        if (latch != null) {
            latch.countDown();
        } else {
            for (Activity activity : activities) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }

            }
        }
    }
}
