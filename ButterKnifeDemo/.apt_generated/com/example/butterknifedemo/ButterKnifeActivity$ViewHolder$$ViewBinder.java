// Generated code from Butter Knife. Do not modify!
package com.example.butterknifedemo;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ButterKnifeActivity$ViewHolder$$ViewBinder<T extends com.example.butterknifedemo.ButterKnifeActivity.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131099649, "field 'mTextView'");
    target.mTextView = finder.castView(view, 2131099649, "field 'mTextView'");
  }

  @Override public void unbind(T target) {
    target.mTextView = null;
  }
}
