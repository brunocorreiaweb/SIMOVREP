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


	private static final String ACCOUNT_TABLE = "ACCOUNT";

	private static final String EXTERNAL_SITE_TABLE = "EXTERNAL_SITE";
	
	private static final String IMAGE_TABLE = "IMAGE";
	
	private static final String PRODUCT_TABLE = "PRODUCT";
	
	private static final String USER_TABLE = "USER";
	
	private static final String PRODUCT_IMAGE_TABLE = "PRODUCT_IMAGE";
	
	private static final String ACCOUNT_PRODUCT_TABLE = "ACCOUNT_PRODUCT";
	
	private static final String DATABASE_DEFAULT_SCRIPT = "create table EXTERNAL_SITE( 	EXTERNAL_SITE_ID integer primary key autoincrement, 	EXTERNAL_SITE_NAME text not null,	EXTERNAL_SITE_URL text not null,	EXTERNAL_SITE_SOCIAL_NETWORK integer not null,	EXTERNAL_SITE_DESCRIPTION text not null);create table PRODUCT(	PRODUCT_ID integer primary key autoincrement,	PRODUCT_TITLE text not null,	PRODUCT_DESCRIPTION text not null,	PRODUCT_CATEGORY text not null,	PRODUCT_PRICE text not null,	PRODUCT_DATE text not null,	PRODUCT_LOCATION text not null);create table IMAGE( 	IMAGE_ID integer primary key autoincrement,	IMAGE_LOCATION text not null,	IMAGE_DESCRIPTION text not null); create table USER( 	USER_ID integer primary key autoincrement,	NAME text not null,	USERNAME text not null,	PASSWORD text not null,	IMAGE_ID integer,    FOREIGN KEY (IMAGE_ID) REFERENCES IMAGE(IMAGE_ID)); create table ACCOUNT( 	ACCOUNT_ID integer primary key autoincrement,	USER_ID integer,	EXTERNAL_SITE_ID integer,	ACCOUNT_USERNAME text not null,	ACCOUNT_PASSWORD text not null,	FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),    FOREIGN KEY (EXTERNAL_SITE_ID) REFERENCES EXTERNAL_SITE(EXTERNAL_SITE_ID)); create table PRODUCT_IMAGE(	PRODUCT_IMAGE_ID integer primery key autoincrement,	PRODUCT_ID integer,	IMAGE_ID integer,	FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID),	FOREIGN KEY (IMAGE_ID) REFERENCES IMAGE(IMAGE_ID) ); create table ACCOUNT_PRODUCT(	ACCOUNT_PRODUCT_ID integer primery key autoincrement,	ACCOUNT_ID integer,	PRODUCT_ID integer,	FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT(ACCOUNT_ID),	FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT) );";

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
		db.execSQL("DROP TABLE IF EXISTS " + ACCOUNT_PRODUCT_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_IMAGE_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + ACCOUNT_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + IMAGE_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + EXTERNAL_SITE_TABLE);
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
