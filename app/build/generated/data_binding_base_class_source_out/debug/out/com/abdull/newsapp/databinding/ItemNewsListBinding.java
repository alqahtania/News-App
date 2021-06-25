// Generated by view binder compiler. Do not edit!
package com.abdull.newsapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.abdull.newsapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemNewsListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivNewsImage;

  @NonNull
  public final TextView tvPublishedAt;

  @NonNull
  public final TextView tvSource;

  @NonNull
  public final TextView tvTitle;

  private ItemNewsListBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView ivNewsImage,
      @NonNull TextView tvPublishedAt, @NonNull TextView tvSource, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.ivNewsImage = ivNewsImage;
    this.tvPublishedAt = tvPublishedAt;
    this.tvSource = tvSource;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemNewsListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemNewsListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_news_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemNewsListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivNewsImage;
      ImageView ivNewsImage = ViewBindings.findChildViewById(rootView, id);
      if (ivNewsImage == null) {
        break missingId;
      }

      id = R.id.tvPublishedAt;
      TextView tvPublishedAt = ViewBindings.findChildViewById(rootView, id);
      if (tvPublishedAt == null) {
        break missingId;
      }

      id = R.id.tvSource;
      TextView tvSource = ViewBindings.findChildViewById(rootView, id);
      if (tvSource == null) {
        break missingId;
      }

      id = R.id.tvTitle;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new ItemNewsListBinding((ConstraintLayout) rootView, ivNewsImage, tvPublishedAt,
          tvSource, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
