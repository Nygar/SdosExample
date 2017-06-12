package com.sdos.android.sample.presentation;


import com.sdos.android.sample.presentation.data.entity.IntegerRealmObject;
import com.sdos.android.sample.presentation.data.entity.TaskEntity;
import com.sdos.android.sample.presentation.data.entity.UserEntity;

import java.util.ArrayList;

import io.realm.Realm;

public class InitialDataRealm implements Realm.Transaction{

    @Override
    public void execute(Realm realm) {
        realm.executeTransactionAsync(realm1 -> {

            realm1.insert(new UserEntity(1,"Rúben Garcia", "1234", "01", 0, null));
            realm1.insert(new UserEntity(2,"admin", "1234", "05", 0, null));


            ArrayList<IntegerRealmObject> typeTaskUser1 = new ArrayList<>();
            typeTaskUser1.add(new IntegerRealmObject(2));
            realm1.insert(new UserEntity(3,"Rafael Martin", "1234", "02", 1, typeTaskUser1));

            realm1.insert(new UserEntity(4,"prueba", "1234", "04", 1, typeTaskUser1));

            ArrayList<IntegerRealmObject> typeTaskUser2 = new ArrayList<>();
            typeTaskUser2.add(new IntegerRealmObject(1));
            typeTaskUser2.add(new IntegerRealmObject(3));
            realm1.insert(new UserEntity(5,"Sarah López", "1234", "03", 1, typeTaskUser2));

            realm1.insert(new TaskEntity("Recolectar",3, "Recolectar", 4, false, 1, "4"));
            realm1.insert(new TaskEntity("Recolectar2",3, "Recolectar", 4, true, 2, "4"));
            realm1.insert(new TaskEntity("Recolectar3",3, "Recolectar", 4, false, 3, "3"));
            realm1.insert(new TaskEntity("Recolectar4",3, "Recolectar", 4, false, 4, "4"));
        });

        realm.close();
    }
}
