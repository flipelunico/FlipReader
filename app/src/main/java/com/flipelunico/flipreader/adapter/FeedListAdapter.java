package com.flipelunico.flipreader.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flipelunico.flipreader.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by flipelunico on 08-06-17.
 */
public class FeedListAdapter  extends RecyclerView.Adapter<FeedListAdapter.FeedViewHolder> {
    private List<Entry> items;
    private Cursor cItems;
    private Context mContext;

    public static class FeedViewHolder extends RecyclerView.ViewHolder {

        //private final View.OnClickListener mOnClickListener = new MyOnClickListener();

        // Campos respectivos de un item
        public ImageView imgFavicon;
        public TextView txtTitle;
        public TextView txtDescripcion;
        public TextView txtTimestamp;
        public TextView txtPage;
        public TextView txtCanal;

        public FeedViewHolder(View v) {
            super(v);
            imgFavicon = (ImageView) v.findViewById(R.id.item_favicon);
            txtTitle = (TextView) v.findViewById(R.id.item_titulo);
            txtDescripcion = (TextView) v.findViewById(R.id.item_contenido);
            txtTimestamp = (TextView) v.findViewById(R.id.item_timestamp);
            txtPage = (TextView) v.findViewById(R.id.item_page);
        }

    }

    public FeedListAdapter (List<Entry> items) {
        this.items = items;
    }

    public FeedListAdapter (Cursor items, Context context) {
        this.cItems = items;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        //return items.size();
        return cItems.getCount();
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_item, viewGroup, false);
        return new FeedViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder viewHolder, int i) {

        cItems.moveToPosition(i);
        viewHolder.txtTitle.setText(cItems.getString(2));

        String content = cItems.getString(3);
        String summary = cItems.getString(4);
        String visual_url = cItems.getString(13);

        //Log.i("Flipelunico","url de imagen: " + visual_url);

        String descripcion;

        if (summary != ""){
            descripcion = summary;
        }else {
            descripcion = content;
        }

        String noHTML1 = descripcion.replaceAll("\\<.*?>","");
        String noHTML2 = noHTML1.replaceAll("&.*?;","");
        String noHTML3 = noHTML2.replace("{\"content\":\"","");
        String noHTML4 = noHTML3.replaceAll("\\\\n","");
        descripcion = noHTML4;

        int ln =0;
        // Obtener acceso a la descripción y su longitud
        if (descripcion != null) {
            ln = content.length();
        }

        // Acortar descripción a 110 caracteres
        if (ln >= 110)
             viewHolder.txtDescripcion.setText(descripcion.substring(0, 110)+"...");
        else viewHolder.txtDescripcion.setText(descripcion);


        viewHolder.txtPage.setText(cItems.getString(11));

        String v8 = cItems.getString(8);
        //TODO: sacar esto el error es de la bd
        if (v8.length() == 0){
            v8 = "1111111111111";
        }
        Long fecha;
        String formattedDate = "";
        if (v8 != "") {
            fecha = Long.parseLong(v8);
            Date pub_date = new Date(fecha);

            SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm");
            formattedDate = dateFormat.format(pub_date);
        }

        viewHolder.txtTimestamp.setText(formattedDate);

        String url_favicon = "http://www.google.com/s2/favicons?domain_url=" + cItems.getString(12);


        Glide
                .with(mContext)
                .load(visual_url)
                .into(viewHolder.imgFavicon);

    }
}