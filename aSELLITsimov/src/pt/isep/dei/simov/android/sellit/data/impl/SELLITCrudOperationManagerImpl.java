/**
 * 
 */
package pt.isep.dei.simov.android.sellit.data.impl;

import java.text.MessageFormat;

import pt.isep.dei.simov.android.sellit.data.SELLITCrudOperationManager;
import pt.isep.dei.simov.android.sellit.data.factory.SELLITPersistenceFactory;
import pt.isep.dei.simov.android.sellit.data.sqlite.SELLITSQLiteOpenHelperImpl;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author Bruno Correia 1090543
 * 
 */
public class SELLITCrudOperationManagerImpl implements
		SELLITCrudOperationManager {

	private SELLITSQLiteOpenHelperImpl sqliteOpenHelper;
	private SQLiteDatabase database;
	private static final String LOG_TAG = SELLITCrudOperationManagerImpl.class
			.getName();

	public SELLITCrudOperationManagerImpl(Context context) {
		Log.i(LOG_TAG, "Creating SEELITSQLitOpenHelper");
		setSqliteOpenHelper(SELLITPersistenceFactory
				.createSELLITSQLiteOpenHelper(context));
	}

	public SELLITSQLiteOpenHelperImpl getSqliteOpenHelper() {
		return sqliteOpenHelper;
	}

	public void setSqliteOpenHelper(SELLITSQLiteOpenHelperImpl sqliteOpenHelper) {
		this.sqliteOpenHelper = sqliteOpenHelper;
	}

	public SQLiteDatabase getDatabase() {
		return database;
	}

	public void setDatabase(SQLiteDatabase database) {
		this.database = database;
	}

	public void open() {
		setDatabase(getSqliteOpenHelper().getWritableDatabase());
	}

	public void close() {
		getSqliteOpenHelper().close();

	}

	public boolean isOpen() {
		return getDatabase().isOpen();
	}

	public long create(String table, ContentValues params) {
		SQLiteDatabase database = getDatabase();
		long id = -1;
		if (database != null && !database.isOpen()) {
			id = database.insert(table, null, params);
		}
		return id;
	}

	public boolean delete(String table, long id) {
		SQLiteDatabase database = getDatabase();
		int result = 0;
		if (database != null && !database.isOpen()) {
			result = database
					.delete(table, getByIdWhereClause(table, id), null);
		}
		return (result > 0);
	}

	public Cursor readById(String table, long id) {
		SQLiteDatabase database = getDatabase();
		Cursor cursor = null;
		if (database != null && !database.isOpen()) {
			cursor = database.query(table, null, getByIdWhereClause(table, id),
					null, null, null, null);
		}
		return cursor;
	}

	public Cursor readAll(String table) {
		SQLiteDatabase database = getDatabase();
		Cursor cursor = null;
		if (database != null && !database.isOpen()) {
			cursor = database.query(table, null, null, null, null, null, null);
		}
		return cursor;
	}

	public boolean update(String table, long id, ContentValues params) {
		SQLiteDatabase database = getDatabase();
		int result = 0;
		if (database != null && !database.isOpen()) {
			result = database.update(table, params,
					getByIdWhereClause(table, id), null);
		}
		return (result > 0);
	}

	public static String getByIdWhereClause(String table, long id) {
		return MessageFormat.format("{0}_ID = {2}", new Object[] { table, id });
	}
}
