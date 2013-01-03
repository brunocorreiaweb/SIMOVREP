package pt.isep.dei.simov.android.sellit.data;

import android.content.ContentValues;
import android.database.Cursor;

public interface SELLITCrudOperationManager {
	void open();
	void close();
	boolean isOpen();
	long create(String table,ContentValues params);
	boolean update(String table,long id,ContentValues params);
	boolean delete(String table,long id);
	Cursor readById(String table,long id);
	Cursor readAll(String table);
}
