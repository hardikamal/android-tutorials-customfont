package io.futurestud.tutorials.customfont;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by norman on 3/8/15.
 *
 * Code taken from britzl on StackOverflow (slightly modified):
 * http://stackoverflow.com/questions/16901930/memory-leaks-with-custom-font-for-set-custom-font/16902532#16902532
 */
public class FontCache {

    private static Hashtable<String, Typeface> fontCache = new Hashtable<>();

    public static Typeface getTypeface(String fontname, Context context) {
        Typeface typeface = fontCache.get(fontname);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontname);
            } catch (Exception e) {
                return null;
            }

            fontCache.put(fontname, typeface);
        }

        return typeface;
    }
}