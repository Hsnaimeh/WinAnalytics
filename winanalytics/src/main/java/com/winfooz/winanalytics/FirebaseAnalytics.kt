package com.winfooz.winanalytics

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseAnalytics(private val context: Context) : Analytics {

    private val firebase: FirebaseAnalytics by lazy { FirebaseAnalytics.getInstance(context) }

    override fun log(data: Pair<String, MutableMap<String, String>>) {
        val bundle = Bundle()
        data.second.keys.forEach {
            bundle.putString(it, data.second[it])
        }
        firebase.logEvent(data.first, bundle)
    }
}
