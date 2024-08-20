package com.example.projectdb.model

import io.realm.kotlin.ext.realmListOf;
import io.realm.kotlin.types.RealmList;
import io.realm.kotlin.types.RealmObject;
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId;

class user : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()

    var AI_image: String? = null

    var pro_pic: String? = null

    var sys_color: String? = null

    var username: String? = null

    var Day_Memory: RealmList<DayMemory> = realmListOf()

    var Month_Memory: RealmList<MonthMemory> = realmListOf()

    var card: RealmList<Cards> = realmListOf()
}