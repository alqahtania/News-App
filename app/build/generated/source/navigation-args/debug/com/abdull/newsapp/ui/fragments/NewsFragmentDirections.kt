package com.abdull.newsapp.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.abdull.newsapp.R
import com.abdull.newsapp.model.Article
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class NewsFragmentDirections private constructor() {
  private data class ActionNewsFragmentToNewsDetailsFragment(
    public val article: Article
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_newsFragment_to_newsDetailsFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Article::class.java)) {
        result.putParcelable("article", this.article as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Article::class.java)) {
        result.putSerializable("article", this.article as Serializable)
      } else {
        throw UnsupportedOperationException(Article::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  public companion object {
    public fun actionNewsFragmentToNewsDetailsFragment(article: Article): NavDirections =
        ActionNewsFragmentToNewsDetailsFragment(article)
  }
}
