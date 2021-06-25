package com.abdull.newsapp.datasource.local

import androidx.room.TypeConverter
import com.abdull.newsapp.model.Source

class DbTypeConverter {


    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String) : Source {
        return Source(name, name)
    }
}