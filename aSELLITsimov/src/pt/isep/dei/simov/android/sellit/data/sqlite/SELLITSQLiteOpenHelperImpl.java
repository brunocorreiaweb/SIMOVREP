/**
 * 
 */
package pt.isep.dei.simov.android.sellit.data.sqlite;

import java.text.MessageFormat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author Bruno Correia 1090543
 * 
 */
public class SELLITSQLiteOpenHelperImpl extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "sellit.db";
	private static final int DATABASE_VERSION = 1;

	/*
	 * ACOUNT TABLE COLUMNS
	 */
	private static final String ACCOUNT_TABLE = "ACCOUNT";
	private static final String ACCOUNT_ID = "ACCOUNT_ID";

	/*
	 * USER TABLE COLUMNS
	 */
	private static final String USER_TABLE = "USER";
	private static final String USER_ID = "USER_ID";

	/*
	 * EXTERNAL_SITE TABLE COLUMNS
	 */
	private static final String EXTERNAL_SITE_TABLE = "EXTERNAL_SITE";
	private static final String EXTERNAL_SITE_ID = "EXTERNAL_SITE_ID";
	private static final String EXTERNAL_SITE_NAME = "EXTERNAL_SITE_NAME";
	private static final String EXTERNAL_SITE_URL = "EXTERNAL_SITE_URL";
	private static final String EXTERNAL_SITE_SOCIAL_NETWORK = "EXTERNAL_SITE_SOCIAL_NETWORK";
	private static final String EXTERNAL_SITE_DESCRIPTION = "EXTERNAL_SITE_DESCRIPTION";

	/*
	 * IMAGE TABLE COLUMNS
	 */
	private static final String IMAGE_TABLE = "IMAGE_SITE";
	private static final String IMAGE_ID = "IMAGE_ID";

	/*
	 * PRODUCT TABLE COLUMNS
	 */
	private static final String PRODUCT_TABLE = "PRODUCT_SITE";
	private static final String PRODUCT_ID = "PRODUCT_ID";

	private static final String DATABASE_DEFAULT_SCRIPT = "create table "
			+ EXTERNAL_SITE_TABLE + "(" + EXTERNAL_SITE_ID
			+ " integer primary key autoincrement, " + EXTERNAL_SITE_NAME
			+ " text not null, " + EXTERNAL_SITE_URL + " text not null, "
			+ EXTERNAL_SITE_SOCIAL_NETWORK + " integer not null, "
			+ EXTERNAL_SITE_DESCRIPTION + " text );";

	private String databaseCreationScript = null;
	private static final String LOG_TAG = SELLITSQLiteOpenHelperImpl.class
			.getName();

	/**
	 * 
	 * Constructor
	 * 
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public SELLITSQLiteOpenHelperImpl(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * Create Database callback
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		if (Log.isLoggable(LOG_TAG, Log.INFO)) {
			Log.i(LOG_TAG, "Creating SellIT Database");
			if (Log.isLoggable(LOG_TAG, Log.DEBUG)) {
				Log.d(LOG_TAG, MessageFormat.format(
						"Database Creating Script=[{0}]",
						getDatabaseCreationScript()));
			}
		}
		db.execSQL(getDatabaseCreationScript());
		if (Log.isLoggable(LOG_TAG, Log.INFO)) {
			Log.i(LOG_TAG, "SellIT Database created");
		}
	}

	/**
	 * 
	 * Upgrade Database callback
	 * 
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(LOG_TAG,
				MessageFormat
						.format("Upgrading database from version [{0}] to [{1}], which will destroy all old data",
								new Object[] { Integer.valueOf(oldVersion),
										Integer.valueOf(newVersion) }));
		// db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	public String getDatabaseCreationScript() {
		if (databaseCreationScript == null) {
			databaseCreationScript = DATABASE_DEFAULT_SCRIPT;
		}
		return databaseCreationScript;
	}

	public void setDatabaseCreationScript(String databaseCreationScript) {
		this.databaseCreationScript = databaseCreationScript;
	}

}
