package com.example.projectdb.model

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject

class MonthMemory: EmbeddedRealmObject {
    var line_chart: String? = null

    var word_cloud: String? = null

    var Happy_word: String? = null

    var Sad_word: String? = null

    var talk_amount: Int? = null

    var card_amount: Int? = null
}