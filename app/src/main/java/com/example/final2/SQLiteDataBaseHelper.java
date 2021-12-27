package com.example.final2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper {

    String TableName;

    public SQLiteDataBaseHelper(@Nullable Context context
            , @Nullable String dataBaseName
            , @Nullable SQLiteDatabase.CursorFactory factory, int version, String TableName) {
        super(context, dataBaseName, factory, version);
        this.TableName = TableName;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLTable = "CREATE TABLE IF NOT EXISTS " + TableName + "( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "SeriesName TEXT, " +
                " TypeName TEXT," +
                " DishName TEXT," +
                " Recipe TEXT" +
                ");";
        db.execSQL(SQLTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + TableName;
        db.execSQL(SQL);
    }

    //檢查資料表狀態，若無指定資料表則新增
    public void chickTable(){
        Cursor cursor = getWritableDatabase().rawQuery(
                "select DISTINCT tbl_name from sqlite_master where tbl_name = '" + TableName + "'", null);
        if (cursor != null) {
            if (cursor.getCount() == 0)
                getWritableDatabase().execSQL("CREATE TABLE IF NOT EXISTS " + TableName + "( " +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "SeriesName TEXT, " +
                        " TypeName TEXT," +
                        " DishName TEXT," +
                        " Recipe TEXT" +
                        ");");
            cursor.close();
        }
    }
    //放置資料
    public void putData(String seriesName, String typeName, String dishName, String recipe) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("seriesName", seriesName);
        values.put("typeName", typeName);
        values.put("dishName", dishName);
        values.put("recipe", recipe);
        db.insert(TableName, null, values);
    }
    //篩選資料
    public ArrayList<HashMap<String, String>> searchBySeriesName() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM " + TableName, null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (c.moveToNext()) {
            HashMap<String, String> hashMap = new HashMap<>();

            String id = c.getString(0);
            String seriesName = c.getString(1);
            String typeName = c.getString(2);
            String dishName = c.getString(3);
            String recipe = c.getString(4);

            hashMap.put("id", id);
            hashMap.put("seriesName", seriesName);
            hashMap.put("typeName", typeName);
            hashMap.put("dishName", dishName);
            hashMap.put("recipe", recipe);
            arrayList.add(hashMap);
        }
        return arrayList;
    }
}
