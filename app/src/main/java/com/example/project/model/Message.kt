package com.example.projectdb.model

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import java.util.Date

class Message: EmbeddedRealmObject {
    var today_pic: String? = null
    var text: String? = null
    @Ignore
    var create_at: Date? = null
    var sender: String? = null
}