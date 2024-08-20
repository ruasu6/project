package com.example.projectdb.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import java.util.Date

class DayMemory: EmbeddedRealmObject {
    @Ignore
    var Date: Date? = null

    var outline: String? = null

    //emo_change是圖檔
    var emo_change: String? = null

    var conversation: RealmList<Message> = realmListOf()
}