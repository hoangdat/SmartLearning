package no.ntnu.tdt4240.activities;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.tdt4240.models.Cell;
import no.ntnu.tdt4240.models.GameBoard;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class MineFieldAdapter extends BaseAdapter {

	private Context mContext;
	private GameBoard mGameBoard;
	private Button[] thumbs;

	public MineFieldAdapter(Context context, GameBoard gameBoard) {
		mContext = context;
		mGameBoard = gameBoard;
	}

	public int getCount() {
		return mGameBoard.getNumberOfCols() * mGameBoard.getNumberOfRows();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Button buttonView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			buttonView = new Button(mContext);
			buttonView.setLayoutParams(new GridView.LayoutParams(85, 85));
			buttonView.setPadding(8, 8, 8, 8);
		} else {
			buttonView = (Button) convertView;
		}

		return buttonView;
	}

}
