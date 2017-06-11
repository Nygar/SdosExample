package com.sdos.android.sample.presentation;


import com.sdos.android.sample.presentation.data.entity.IntegerRealmObject;
import com.sdos.android.sample.presentation.data.entity.UserEntity;

import java.util.ArrayList;

import io.realm.Realm;

public class InitialDataRealm implements Realm.Transaction{

    @Override
    public void execute(Realm realm) {
        realm.executeTransactionAsync(realm1 -> {


            UserEntity userEntity1 = new UserEntity("Rúben Garcia", "1234", "01", 0, null);
            realm1.insert(userEntity1);

            ArrayList<IntegerRealmObject> typeTaskUser1 = new ArrayList<>();
            typeTaskUser1.add(new IntegerRealmObject(2));
            UserEntity userEntity2 = new UserEntity("Rafael Martin", "1234", "02", 1, typeTaskUser1);
            realm1.insert(userEntity2);

            ArrayList<IntegerRealmObject> typeTaskUser2 = new ArrayList<>();
            typeTaskUser2.add(new IntegerRealmObject(1));
            typeTaskUser2.add(new IntegerRealmObject(3));
            UserEntity userEntity3 = new UserEntity("Sarah López", "1234", "03", 1, typeTaskUser2);
            realm1.insert(userEntity3);
        });

        realm.close();
    }
}
