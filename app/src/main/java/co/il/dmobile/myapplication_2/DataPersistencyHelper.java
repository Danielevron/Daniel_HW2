package co.il.dmobile.myapplication_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataPersistencyHelper {

    public static Context Context;

    public static void StoreData(List<Car> cars)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(cars );
        editor.putString("cars", json);
        editor.commit();
    }

    public static List<Car> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("cars",null);
        if (json != null)
        {
            Type type = new TypeToken<List<Car>>(){}.getType();
            return new Gson().fromJson(json,type);
        }
        else
        {
            List<Car> cars = new ArrayList<Car>();
            cars.add(new Car(R.drawable.car01,"brand: ford","model: x4","year: 2019","price: 200000$"));
            cars.add(new Car(R.drawable.car02,"brand: kia","model: trs4","year: 2010","price: 100000$"));
            cars.add(new Car(R.drawable.car03,"brand: bmw","model: i5","year: 2020","price: 300000$"));
            cars.add(new Car(R.drawable.car04,"brand: pegeout","model: 108","year: 2019","price: 50000$"));
            cars.add(new Car(R.drawable.car05,"brand: tesla","model: x","year: 2022","price: 255000$"));
            cars.add(new Car(R.drawable.car06,"brand: alpha","model: axis","year: 2015","price: 108800$"));
            cars.add(new Car(R.drawable.car07,"brand: toyota","model: onix","year: 2018","price: 400000$"));
            cars.add(new Car(R.drawable.car08,"brand: chevrolet","model: malibu","year: 2021","price: 350000$"));

            return cars;
        }
    }

}
