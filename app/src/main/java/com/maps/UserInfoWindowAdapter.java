package com.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by isb on 08/04/2016.
 */
public class UserInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    LayoutInflater inflater=null;

    UserInfoWindowAdapter(LayoutInflater inflater){
        this.inflater=inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View infoWindows=inflater.inflate(R.layout.info_window_layout, null);

        TextView title = (TextView)infoWindows.findViewById(R.id.title);
        TextView description = (TextView)infoWindows.findViewById(R.id.snippet);

        title.setText(marker.getTitle());
        description.setText(marker.getSnippet());

        return(infoWindows);
    }
}
