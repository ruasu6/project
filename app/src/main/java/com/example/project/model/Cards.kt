//package的databaseconnectionfinal要改成自己的專案名稱
package com.example.projectdb.model

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject

class Cards: EmbeddedRealmObject {
    var card_id: Int? = null

    var own: Boolean? = null
}