// Application Fundamentals: http://developer.android.com/guide/topics/fundamentals.html#acttask
// Android Activity Launch Modes: http://www.justinlee.sg/2010/03/13/android-activity-launch-modes/
// Hellow Views: http://developer.android.com/guide/tutorials/views/index.html

package org.doubango.imsdroid.Sevices.Impl;

import java.util.HashMap;

import org.doubango.imsdroid.R;
import org.doubango.imsdroid.Screens.HomeScreen;
import org.doubango.imsdroid.Screens.Screen;
import org.doubango.imsdroid.Screens.Screen.SCREEN_TYPE;
import org.doubango.imsdroid.Services.IScreenService;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class ScreenService extends Service implements IScreenService {

	private ActivityGroup mainActivity;
	private final HashMap<String, Screen> screens;
	private static final HashMap<String, Screen.SCREEN_TYPE> WELL_KNOWN_SCREENS;

	static {
		WELL_KNOWN_SCREENS = new HashMap<String, Screen.SCREEN_TYPE>();
		WELL_KNOWN_SCREENS.put(Screen.SCREEN_ID_HOME, SCREEN_TYPE.HOME);
	}

	public ScreenService() {
		this.screens = new HashMap<String, Screen>();
	}

	public boolean start() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean stop() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setMainActivity(ActivityGroup main) {
		this.mainActivity = main;
	}

	public boolean show(Screen screen) {
		if (screen == null) {
			Log.e(this.getClass().getCanonicalName(), "Null Screen");
			return false;
		}

		// Intent i = new Intent(this.mainActivity, screen.getClass());
		// this.mainActivity.startActivity(i);
		TableRow tlayoutBody = (TableRow) this.mainActivity
				.findViewById(R.id.tlayoutBody);

		Intent intent = new Intent(this.mainActivity, screen.getClass());
		View view = this.mainActivity.getLocalActivityManager().startActivity(screen.getId(), intent).getDecorView();
		// window.setContentView(tlayoutBody, new
		// ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
		// ViewGroup.LayoutParams.FILL_PARENT));
		//int w = view.getWidth();

		tlayoutBody.removeAllViews();
		tlayoutBody.addView(view);

		//		
		// int width = tlayoutBody.getWidth();
		//		
		// tlayoutBody.removeAllViews();
		// View v = window.getDecorView();
		//		
		// //tlayoutBody.setLayoutParams(new
		// TableRow.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
		// LinearLayout.LayoutParams.WRAP_CONTENT));
		// //width = tlayoutBody.getWidth();
		// //tlayoutBody.bringToFront();
		// //tlayoutBody.setMinimumWidth(200);
		// //width = tlayoutBody.getWidth();
		//		
		// //v.setMinimumHeight(50);
		// //v.setLayoutParams(new
		// TableRow.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
		// LinearLayout.LayoutParams.FILL_PARENT));
		// tlayoutBody.addView(v);

		return true;
	}

	public boolean show(String id) {
		Screen screen;

		/* already exist? */
		if ((screen = this.screens.get(id)) == null) {
			/* does not exist: is it a well-known screen? */
			if (ScreenService.WELL_KNOWN_SCREENS.containsKey(id)) {
				Screen.SCREEN_TYPE type = ScreenService.WELL_KNOWN_SCREENS
						.get(id);
				switch (type) {
				case ABOUT:
					break;

				case EAB:
					break;

				case HISTORY:
					break;

				case HOME:
					screen = new HomeScreen();
					break;
				}
				/* adds the newly created well-know screen */
				if (screen != null) {
					this.screens.put(screen.getId(), screen);
				}
			}
		}

		if (screen == null) {
			Log.e(this.getClass().getCanonicalName(), String.format(
					"Failed to retrieve the Screen with id=%s", id));
			return false;
		} else {
			return this.show(screen);
		}
	}

	// public boolean show(Screen screen) {
	// if (screen instanceof Activity && this.mainActivity != null) {
	// Intent intent = new Intent(this.mainActivity, screen.getClass());
	// intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
	// screen.startActivity(intent);
	// return true;
	// }
	// return false;
	// }
	//
	// public boolean show(SCREEN_TYPE type) {
	// Screen screen = this.getScreen(type);
	// if (screen != null) {
	// return this.show(screen);
	// } else {
	// return false;
	// }
	// }
	//	
	// public Screen getScreen(SCREEN_TYPE type) {
	// switch (type) {
	// case ABOUT:
	// break;
	// case EAB:
	// break;
	// case HISTORY:
	// break;
	// case HOME:
	// if (this.homeScreen == null) {
	// this.homeScreen = new HomeScreen();
	// }
	// return this.homeScreen;
	// }
	// return null;
	// }
}