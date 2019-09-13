package com.example.darielcruzhdez.tourismapp.main.repos;

import com.example.darielcruzhdez.tourismapp.main.model.Destination;

import io.realm.Realm;

public class DestinationsRepo {

    private Realm mRealm;

    public DestinationsRepo(){
        mRealm = Realm.getDefaultInstance();
    }

    public void addDestination(Destination destination){
        mRealm.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(destination));
    }

    public void deleteDestination(Destination destination){
        mRealm.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(destination));
    }
}
