package aray.com;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class TeamPic_Activity extends Activity {
	/** Called when the activity is first created. */
	private Gallery gallery;
	private ImageAdapter imageAdapter;

	private int[] resIds = new int[] { R.drawable.item1, R.drawable.item2,
			R.drawable.item3, R.drawable.item4, R.drawable.item5,
			R.drawable.item6, R.drawable.item7, R.drawable.item8,
			R.drawable.item9, R.drawable.item10, R.drawable.item11,
			R.drawable.item12, R.drawable.item13, R.drawable.item14,
			R.drawable.item15, R.drawable.item16, R.drawable.item17,
			R.drawable.item19, R.drawable.item20, R.drawable.item21,
			R.drawable.item22 };

	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Context mContext;

		public ImageAdapter(Context context) {
			mContext = context;
			TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
			mGalleryItemBackground = typedArray.getResourceId(
					R.styleable.Gallery_android_galleryItemBackground, 0);
		}

		public int getCount() {
			return Integer.MAX_VALUE;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(mContext);

			imageView.setImageResource(resIds[position % resIds.length]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			DisplayMetrics dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
			imageView.setLayoutParams(new Gallery.LayoutParams(dm.widthPixels, dm.heightPixels));
			imageView.setBackgroundResource(mGalleryItemBackground);
			return imageView;
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myactivity3);
		gallery = (Gallery) findViewById(R.id.gallery);
		imageAdapter = new ImageAdapter(this);
		gallery.setAdapter(imageAdapter);
		setTitle("«Ú–«∑Á≤…");

	}
}