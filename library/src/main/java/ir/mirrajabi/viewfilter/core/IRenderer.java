package ir.mirrajabi.viewfilter.core;

import android.graphics.Bitmap;

public interface IRenderer {
    Bitmap render(Bitmap sentBitmap, int radius);
}
