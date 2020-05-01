package com.bsrakdg.beginnerdagger2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bsrakdg.beginnerdagger2.car.Car;
import com.bsrakdg.beginnerdagger2.dagger.CarComponent;
import com.bsrakdg.beginnerdagger2.dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1, car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = ((ExampleApp) getApplication())
                .getAppComponent()
                .getCarComponent(new DieselEngineModule(100));
        component.inject(this);

        // Compare engine address at log between car1 and car2
        car1.drive();
        car2.drive();
    }
}
