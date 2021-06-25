package com.abdull.newsapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abdull.newsapp.util.Constants.ARTICLES_TABLE
import kotlinx.android.parcel.Parcelize


@Entity(
    tableName = ARTICLES_TABLE
)
@Parcelize
data class Article(
    @PrimaryKey(autoGenerate = false)
    var id: Int?,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Parcelable{
    override fun hashCode(): Int {
        return super.hashCode()
    }
}