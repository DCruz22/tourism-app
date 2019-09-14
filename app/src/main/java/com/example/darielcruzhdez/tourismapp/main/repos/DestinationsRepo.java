package com.example.darielcruzhdez.tourismapp.main.repos;

import android.util.Log;

import com.example.darielcruzhdez.tourismapp.main.model.Destination;

import java.util.List;

import io.realm.Realm;

public class DestinationsRepo {

    private Realm mRealm;

    public DestinationsRepo(){
        mRealm = Realm.getDefaultInstance();
    }

    public Destination find(int id) {
        return mRealm.where(Destination.class).equalTo("id", id).findFirst();
    }

    public List<Destination> findAll()  {
        return mRealm.where(Destination.class).findAll();
    }

    public void addDestination(Destination destination){
        mRealm.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(destination),
                () -> Log.i("good", "All good"),
                error -> Log.e("error", error.getMessage()));
    }

    public void deleteDestination(int id){
        mRealm.executeTransactionAsync(realm -> {
            Destination d = realm.where(Destination.class)
                    .equalTo("id", id)
                    .findFirst();

            if(d != null)
                d.deleteFromRealm();
        });
    }

    public int bookmarkDestination(Destination destination){
        Destination d = this.find(destination.getId());

        if(d != null){
            this.deleteDestination(d.getId());
            return 1;
        }

        this.addDestination(destination);
        return 0;
    }

    public void close(){
            mRealm.close();
    }
}