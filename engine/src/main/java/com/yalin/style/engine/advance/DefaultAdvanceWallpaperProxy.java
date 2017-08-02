package com.yalin.style.engine.advance;

import android.content.Context;
import android.service.wallpaper.WallpaperService;

import com.yalin.style.engine.GLWallpaperServiceProxy;

/**
 * @author jinyalin
 * @since 2017/7/31.
 */

public class DefaultAdvanceWallpaperProxy extends GLWallpaperServiceProxy {
    public DefaultAdvanceWallpaperProxy(Context host) {
        super(host);
    }

    @Override
    public WallpaperService.Engine onCreateEngine() {
        return new MyEngine();
    }

    private class MyEngine extends GLActiveEngine {
        MyRenderer renderer;

        public MyEngine() {
            super();
            // handle prefs, other initialization
            renderer = new MyRenderer();
            setRenderer(renderer);
            setRenderMode(RENDERMODE_CONTINUOUSLY);
        }

        public void onDestroy() {
            super.onDestroy();
            if (renderer != null) {
                renderer.release();
            }
            renderer = null;
        }
    }
}