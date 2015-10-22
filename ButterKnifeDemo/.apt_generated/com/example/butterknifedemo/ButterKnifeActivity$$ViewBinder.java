// Generated code from Butter Knife. Do not modify!
package com.example.butterknifedemo;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ButterKnifeActivity$$ViewBinder<T extends com.example.butterknifedemo.ButterKnifeActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131099648, "field 'mListView', method 'onItemClickListener', and method 'onItemLongClickListener'");
    target.mListView = finder.castView(view, 2131099648, "field 'mListView'");
    ((android.widget.AdapterView<?>) view).setOnItemClickListener(
      new android.widget.AdapterView.OnItemClickListener() {
        @Override public void onItemClick(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          target.onItemClickListener(p1, p2);
        }
      });
    ((android.widget.AdapterView<?>) view).setOnItemLongClickListener(
      new android.widget.AdapterView.OnItemLongClickListener() {
        @Override public boolean onItemLongClick(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          return target.onItemLongClickListener(p1, p2);
        }
      });
  }

  @Override public void unbind(T target) {
    target.mListView = null;
  }
}
