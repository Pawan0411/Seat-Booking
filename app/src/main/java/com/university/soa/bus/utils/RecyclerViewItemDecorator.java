package com.university.soa.bus.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerViewItemDecorator extends RecyclerView.ItemDecoration {
  private int spaceInPixels;

  public RecyclerViewItemDecorator(int spaceInPixels) {
    this.spaceInPixels = spaceInPixels;
  }

  @Override
  public void getItemOffsets(Rect outRect, View view,
                             RecyclerView parent, RecyclerView.State state) {
    outRect.left = spaceInPixels;
    outRect.right = spaceInPixels;
    outRect.bottom = spaceInPixels;

    if (parent.getChildLayoutPosition(view) == 0) {
        outRect.top = spaceInPixels;
    } else {
        outRect.top = 0;
    }
  }
}