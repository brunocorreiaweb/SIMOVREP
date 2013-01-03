package pt.isep.dei.simov.android.sellit.data.factory;

import pt.isep.dei.simov.android.sellit.data.SELLITCrudOperationManager;
import pt.isep.dei.simov.android.sellit.data.impl.SELLITCrudOperationManagerImpl;
import pt.isep.dei.simov.android.sellit.data.sqlite.SELLITSQLiteOpenHelperImpl;
import android.content.Context;

public class SELLITPersistenceFactory {

	public static SELLITCrudOperationManager createCrudOperationManager(
			Context context) {
		return new SELLITCrudOperationManagerImpl(context);
	}
	
	public static SELLITSQLiteOpenHelperImpl createSELLITSQLiteOpenHelper(Context context)
	{
		return new SELLITSQLiteOpenHelperImpl(context);
	}
	

}
