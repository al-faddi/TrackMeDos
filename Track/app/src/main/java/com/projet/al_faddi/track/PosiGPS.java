package com.projet.al_faddi.track;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by al-faddi on 26/08/2016.
 */
public class PosiGPS extends Activity {
    private LocationManager objgps;
    private LocationListener objlistener;
    private TextView mTxtViewlong;
    private TextView mTxtViewlat;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posi_gps_main);
        //---utilisation  de la class LocationManager pour le gps---
        objgps = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //*************ecouteur ou listener*********************
        objlistener = new Myobjlistener();

        objgps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 150, objlistener);
        //**variable qui pointe sur  mes champs d'affichage*************
        mTxtViewlong = (TextView) findViewById(R.id.lon);
        mTxtViewlat = (TextView) findViewById(R.id.lati);

    }

    private class Myobjlistener implements LocationListener
    {



        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }


        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }


        public void onStatusChanged(String provider, int status,
                                    Bundle extras) {
            // TODO Auto-generated method stub
        }


        public void onLocationChanged(Location location) {

            //affichage des valeurs dans la les zone de saisie
            mTxtViewlat.setText(" "+location.getLatitude());
            mTxtViewlong.setText(" "+location.getLongitude());
        }

    }

}
