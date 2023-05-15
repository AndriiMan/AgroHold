// Generated by view binder compiler. Do not edit!
package com.example.agrohold.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.agrohold.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEditBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText edDesc;

  @NonNull
  public final EditText edTitle;

  @NonNull
  public final FloatingActionButton fbAddImage;

  @NonNull
  public final FloatingActionButton fbEdit;

  @NonNull
  public final FloatingActionButton fbSave;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final ImageButton imButtonDeleteImage;

  @NonNull
  public final ImageButton imButtonEditeImage;

  @NonNull
  public final ImageView imMainImage;

  @NonNull
  public final ConstraintLayout mainImageLayout;

  private ActivityEditBinding(@NonNull ConstraintLayout rootView, @NonNull EditText edDesc,
      @NonNull EditText edTitle, @NonNull FloatingActionButton fbAddImage,
      @NonNull FloatingActionButton fbEdit, @NonNull FloatingActionButton fbSave,
      @NonNull Guideline guideline2, @NonNull ImageButton imButtonDeleteImage,
      @NonNull ImageButton imButtonEditeImage, @NonNull ImageView imMainImage,
      @NonNull ConstraintLayout mainImageLayout) {
    this.rootView = rootView;
    this.edDesc = edDesc;
    this.edTitle = edTitle;
    this.fbAddImage = fbAddImage;
    this.fbEdit = fbEdit;
    this.fbSave = fbSave;
    this.guideline2 = guideline2;
    this.imButtonDeleteImage = imButtonDeleteImage;
    this.imButtonEditeImage = imButtonEditeImage;
    this.imMainImage = imMainImage;
    this.mainImageLayout = mainImageLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.edDesc;
      EditText edDesc = ViewBindings.findChildViewById(rootView, id);
      if (edDesc == null) {
        break missingId;
      }

      id = R.id.edTitle;
      EditText edTitle = ViewBindings.findChildViewById(rootView, id);
      if (edTitle == null) {
        break missingId;
      }

      id = R.id.fbAddImage;
      FloatingActionButton fbAddImage = ViewBindings.findChildViewById(rootView, id);
      if (fbAddImage == null) {
        break missingId;
      }

      id = R.id.fbEdit;
      FloatingActionButton fbEdit = ViewBindings.findChildViewById(rootView, id);
      if (fbEdit == null) {
        break missingId;
      }

      id = R.id.fbSave;
      FloatingActionButton fbSave = ViewBindings.findChildViewById(rootView, id);
      if (fbSave == null) {
        break missingId;
      }

      id = R.id.guideline2;
      Guideline guideline2 = ViewBindings.findChildViewById(rootView, id);
      if (guideline2 == null) {
        break missingId;
      }

      id = R.id.imButtonDeleteImage;
      ImageButton imButtonDeleteImage = ViewBindings.findChildViewById(rootView, id);
      if (imButtonDeleteImage == null) {
        break missingId;
      }

      id = R.id.imButtonEditeImage;
      ImageButton imButtonEditeImage = ViewBindings.findChildViewById(rootView, id);
      if (imButtonEditeImage == null) {
        break missingId;
      }

      id = R.id.imMainImage;
      ImageView imMainImage = ViewBindings.findChildViewById(rootView, id);
      if (imMainImage == null) {
        break missingId;
      }

      id = R.id.mainImageLayout;
      ConstraintLayout mainImageLayout = ViewBindings.findChildViewById(rootView, id);
      if (mainImageLayout == null) {
        break missingId;
      }

      return new ActivityEditBinding((ConstraintLayout) rootView, edDesc, edTitle, fbAddImage,
          fbEdit, fbSave, guideline2, imButtonDeleteImage, imButtonEditeImage, imMainImage,
          mainImageLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
