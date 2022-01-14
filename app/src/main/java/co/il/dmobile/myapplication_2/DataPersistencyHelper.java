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
            cars.add(new Car(R.drawable.car01,"ford","x4","2019","200000$"));
            cars.add(new Car(R.drawable.car02,"kia","trs4","2010","100000$"));
            cars.add(new Car(R.drawable.car03,"bmw","i5","2020","300000$"));
            cars.add(new Car(R.drawable.car04,"pegeout","108","2019","50000$"));
            cars.add(new Car(R.drawable.car05,"tesla","x","2022","255000$"));
            cars.add(new Car(R.drawable.car06,"alpha","axis","2015","108800$"));
            cars.add(new Car(R.drawable.car07,"toyota","onix","2018","400000$"));
            cars.add(new Car(R.drawable.car08,"chevrolet","malibu","2021","350000$"));

            return cars;
        }
    }

}
