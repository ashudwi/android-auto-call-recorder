package anthonynahas.com.autocallrecorder.providers;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

/**
 * Created by A on 17.04.17.
 */

public class RecordDbHelper {

    /**
     * Update the column isLove using the content resolver
     *
     * @param context - the used context
     * @param id      - the id of the record
     * @param isLove  - whether the recod isLove (favorite)
     * @return the count of updated rows
     */
    public static int updateIsLoveColumn(Context context, long id, int isLove) {
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecordDbContract.RecordItem.COLUMN_IS_LOVE, isLove);
        Uri uri = ContentUris.withAppendedId(RecordDbContract.CONTENT_URL, id);
        String selection = RecordDbContract.RecordItem.COLUMN_ID + "=?";
        String[] selectionArgs = {String.valueOf(id)};
        return contentResolver.update(uri, contentValues, selection, selectionArgs);
    }

}