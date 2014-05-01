package g0v.ly.lylog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NavigationDrawerAdapter extends BaseAdapter {

	private LayoutInflater inflater;

	public NavigationDrawerAdapter(Activity activity) {
		inflater = LayoutInflater.from(activity);
	}

	@Override
	public int getCount() {
		return 5;
	}

	@Override
	public Object getItem(int i) {
		return null;
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		View 		row 		= view;
		RowHolder 	rowHolder;

		if (row == null) {
			rowHolder = new RowHolder();

			// Apply different xml
			if (position == 1) {
				row = inflater.inflate(R.layout.row_navigation_title, viewGroup, false);
				rowHolder.textView = (TextView) (row != null ? row.findViewById(R.id.tv_title) : null);
			} else {
				row	= inflater.inflate(R.layout.row_navigation_normal, viewGroup, false);
				rowHolder.textView = (TextView) (row != null ? row.findViewById(R.id.tv_normal) : null);
			}
		} else {
			rowHolder = (RowHolder) row.getTag();
		}

		assert row != null;
        rowHolder.textView.setText(position + " : " + R.string.title_1);

        /*
		if (position == 1) {
			rowHolder.textView.setText(R.string.title_1);
		} else {
			rowHolder.textView.setText(position);
		}
        */
		return row;
	}

	private class RowHolder {
		TextView textView;
	}
}
