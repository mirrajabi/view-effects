package ir.mirrajabi.viewfilter.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;

import ir.mirrajabi.viewfilter.utility.ViewHelper;

public class ViewFilter {
    private Context _context;
    private static ViewFilter _instance = null;
    private IRenderer _renderer;

    public static ViewFilter getInstance(Context context){
        if(_instance == null) {
            _instance = new ViewFilter(context);
        }
        return _instance;
    }
    public ViewFilter(Context context){
        _context = context;
    }

    public ViewFilter setRenderer(IRenderer renderer) {
        this._renderer = renderer;
        return this;
    }
    public IRenderer getRenderer() {
        return _renderer;
    }

    public void applyFilterOnView(View view, View backgroundView){
        BitmapDrawable drawable = new BitmapDrawable(_context.getResources(),getFilteredBackgroundOfView(view,backgroundView));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        }
        else view.setBackgroundDrawable(drawable);
    }
    public Bitmap getFilteredBackgroundOfView(View view,View backgroundView){
        Bitmap screenShot = loadBitmapFromView(view, backgroundView);
        Bitmap cropped = Bitmap.createBitmap(screenShot, ViewHelper.getRelativeLeft(view),ViewHelper.getRelativeTop(view),view.getWidth(),view.getHeight());
        return _renderer.render(cropped);
    }

    private Bitmap loadBitmapFromView(View view, View backgroundView) {
        try {
            if(backgroundView.getWidth() <= 0 || backgroundView.getHeight() <= 0) throw new NotInflatedException();
            Bitmap bitmap = Bitmap.createBitmap(backgroundView.getWidth(), backgroundView.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            backgroundView.layout(-ViewHelper.getRelativeLeft(backgroundView), -ViewHelper.getRelativeTop(backgroundView), view.getLayoutParams().width, view.getLayoutParams().height);
            backgroundView.draw(canvas);
            return bitmap;
        }catch (NotInflatedException e){
            e.printStackTrace();
        }
        return null;
    }
}