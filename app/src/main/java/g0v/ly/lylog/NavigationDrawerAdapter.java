package g0v.ly.lylog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import g0v.ly.lylog.data.list.DataLists;

public class NavigationDrawerAdapter extends BaseAdapter {
	private LayoutInflater 			inflater;
	private DataLists navigationDrawerList 	= new DataLists();
	private String[]				drawerList 				= navigationDrawerList.getDrawerList();

	public NavigationDrawerAdapter(Activity activity) {
		inflater = LayoutInflater.from(activity);
	}

	@Override
	public int getCount() {
		return 7;
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
			rowHolder = new RowHolder(position);

			// Apply different xml
			if (position == 0 || position == 4) {
				row = inflater.inflate(R.layout.row_navigation_title, viewGroup, false);
				rowHolder.textViewMain = (TextView) (row != null ? row.findViewById(R.id.tv_title) : null);

				// set title clickable = false
				assert rowHolder.textViewMain != null;
				rowHolder.textViewMain.setEnabled(false);
				rowHolder.textViewMain.setOnClickListener(null);

			} else {
				row	= inflater.inflate(R.layout.row_navigation_normal, viewGroup, false);
				rowHolder.textViewMain = (TextView) (row != null ? row.findViewById(R.id.tv_normal) : null);
			}

			//rowHolder.initOnclick();

			assert row != null;
			row.setTag(rowHolder);
		} else {
			rowHolder = (RowHolder) row.getTag();
		}

		rowHolder.textViewMain.setText(drawerList[position]);

		/*
		if (position == 0 || position == 5) {
			rowHolder.rowButton.setText("Title");
		} else {
			rowHolder.rowButton.setText("text");
		}
		*/
		return row;
	}

	private class RowHolder {
		int 		position;
		TextView 	textViewMain;

		RowHolder(int position) {
			this.position = position;
		}
		/*
		public void initOnclick() {
			rowButton.setOnClickListener(new Button.OnClickListener() {
				@Override
				public void onClick(View view) {
					Log.d("NavigationDrawerAdapter", "[" + position + "] row button clicked");
				}
			});
		}
		*/
	}
}
