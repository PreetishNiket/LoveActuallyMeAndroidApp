package com.example.loveactuallymeandroidapp.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import com.example.loveactuallymeandroidapp.utils.dataClass.Profiles1
import com.google.gson.GsonBuilder
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream


class Utils {
    private val  TAG = "Utils";

    fun loadProfiles(context:Context):List<Profiles1> {
        try{
            val builder = GsonBuilder()
            val  gson = builder.create()
            val  array = JSONArray(loadJSONFromAsset(context, "profiles.json"));
            val  profileList= arrayListOf<Profiles1>()
            var i=0
            while (i<array.length()){
                val profile = gson.fromJson(array.getString(i),Profiles1::class.java)
                profileList.add(profile)
                i++
            }
            return profileList;
        }catch (e:Exception){
            e.printStackTrace();
            return emptyList()
        }
    }

    private fun loadJSONFromAsset(context:Context,jsonFileName:String): String? {
        val json: String?
        val `is`: InputStream?
        try
        {
            val manager = context.assets

            Log.d(TAG, "path $jsonFileName")

            `is` = manager.open(jsonFileName)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, charset("UTF-8"))
            return json
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
    }
    fun getDisplaySize(windowManager: WindowManager): Point? {
        return try {
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display.getMetrics(displayMetrics)
            Point(displayMetrics.widthPixels, displayMetrics.heightPixels)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Point(0, 0)
        }
    }
    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density) as Int
    }

}