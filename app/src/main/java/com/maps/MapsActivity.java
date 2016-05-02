package com.maps;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class MapsActivity extends FragmentActivity  {

    private GoogleMap mMap;
    private Marker marker;
    private View infoWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }
    public void onSearch(View view)
    {
        EditText location_tf = (EditText)findViewById(R.id.TFaddress);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;
        if(location != null || !location.equals(""))
        {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location , 1);


            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude() , address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        }
    }
    public void onZoom(View view)
    {
        if(view.getId() == R.id.Bzoomin)
        {
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if(view.getId() == R.id.Bzoomout)
        {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }
    public void changeType(View view)
    {
        if(mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL)
        {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        else
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            mMap.setMyLocationEnabled(true);
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }
    private void setUpMap() {
        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location arg0) {
                // TODO Auto-generated method stub

                mMap.addMarker(new MarkerOptions().position(new LatLng(arg0.getLatitude(), arg0.getLongitude())).title("It's Me!"));
            }
        });

//MANOUBA
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.831990, 10.039964)).title("M. BEN OMRANE MOEZ ").snippet("  ").draggable(true).icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.766289, 10.016595)).title("SAIHI GHAZI  ").snippet("  ").draggable(true).icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));



        mMap.addMarker(new MarkerOptions().position(new LatLng(36.802349, 10.106125)).title("Mme. MAALEJ EP.BEN MUSTAPHA FATHIA  ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.802449, 10.113993)).title("pharmacie de nuit ").snippet("P5 Den Den Tunisia ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.810597, 10.094533)).title("M. ELOUED NEJIB ").snippet(" ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.821649, 10.089607)).title("M. ESSOUSSI BELHASSEN  ").snippet(" ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.826391, 10.096596)).title("M. BEN AOUN ABDESSALEM ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
//ARIANA
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.876601, 10.268064)).title("M. NAJJAR HICHEM  ").snippet(" ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.865337, 10.202206)).title("Mme. AOUIDJ LATIFA ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.858633, 10.188548)).title("M. OUESLATI FATHI ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.879352, 10.185614)).title("M. KOTRANE RIADH").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.887393, 10.182811)).title("M. SARRAI KARIM ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.840318, 10.116788)).title("M. Atallah Hafedh ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.840241, 10.116488)).title("pharmacie de nuit ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.833811, 10.103221)).title("M. BEN YAGHLANE NADHIM  ").snippet(" ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.833627, 10.103436)).title("pharmacie de nuit ").snippet("Detail  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.830767, 10.114651)).title("M. GUIGA MAHER ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));

//BEN AROUS

      marker=  mMap.addMarker(new MarkerOptions().position(new LatLng(36.710252, 10.376659)).title("Mme. GUELLIM EP. LAASSIDI ALIA ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.727220, 10.337068)).title("M. ABDENNADHER MOHAMED ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.727347, 10.337008)).title("pharmacie de nuit ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.740319, 10.302837)).title("Mme. HALIOUI EP.M'HIRSI LAMIA ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.740375, 10.302577)).title("pharmacie de nuit ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.724745, 10.301577)).title("Mme. ANNABI EP.FARAH SAMIA ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.724532, 10.301476)).title("pharmacie de nuit ").snippet("Detail  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.767920, 10.276900)).title("Mme. KSOURI EP.EL OUNI NAZIHA ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.767935, 10.273410)).title("pharmacie de nuit ").snippet("Detail  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.769827, 10.233101)).title("M. ESSAIDI OTHMAN ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.741838, 10.242450)).title("M. BEN HAMOUDA ABERRAOUF ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.768402, 10.270710)).title("Mme. BENZINA EP ESSAIED AZZA ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.721611, 10.215494)).title("M. MBAREK SAMI ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.678932, 10.286226)).title("M. MOHSNI NEBIL ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.679758, 10.288002)).title("pharmacie de nuit ").snippet("Detail ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));

//BEJA
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.653121, 9.610373)).title("Mlle. RIAHI YOSRA ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.458809, 9.248920)).title("M. BOULILA HATEM ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.650918, 8.695761)).title("pharmacie de nuit ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.321890, 9.327475)).title("pharmacie de nuit ").snippet("  ").icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker2)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.8189700, 10.1657900), 8));
        mMap.setInfoWindowAdapter(new UserInfoWindowAdapter(getLayoutInflater()));

    }
    /*public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
}
