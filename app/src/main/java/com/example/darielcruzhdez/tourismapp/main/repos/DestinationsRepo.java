package com.example.darielcruzhdez.tourismapp.main.repos;

import com.example.darielcruzhdez.tourismapp.main.model.Destination;

import io.realm.Realm;

public class DestinationsRepo {

    private Realm mRealm;

    public DestinationsRepo(){
        mRealm = Realm.getDefaultInstance();
    }

    public Destination find(int id) {
        return realm.where(Destination.class).equalTo("id", id).findFirst()
    }

    public List<Destination> findAll()  {
        return realm.where(Destination.class).findAll()
    }

    public void addDestination(Destination destination){
        mRealm.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(destination));
    }

    public void deleteDestination(Destination destination){
        mRealm.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(destination));
    }

    public int bookmarkDestination(Destination destination){
        Destination d = this.find(destination.id);

        if(d != null){
            this.deleteDestination(d);
            return 1;
        }

        this.addDestination(d);
        return 0;
    }

    public void close(){
            mRealm.close();
    }
}