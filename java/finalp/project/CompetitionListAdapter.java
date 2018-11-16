package finalp.project;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Mohammed on 30-Nov-16.
 */
public class CompetitionListAdapter extends ArrayAdapter<Competition> {

    private List<Competition> competitions;

    public CompetitionListAdapter(Context context, int resource, List<Competition> objects) {
        super(context, resource, objects);
        competitions = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }

        Competition competition = competitions.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
        nameText.setText(competition.getName());

        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView);
        Bitmap bitmap = getBitmap(competition.getProductId());
        iv.setImageBitmap(bitmap);

        return convertView;
    }

    private Bitmap getBitmap(String CompId){
        AssetManager assetManager = getContext().getAssets();
        InputStream stream = null;
        try {
            stream = assetManager.open(CompId + ".png");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
