package com.projet.al_faddi.track;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by al-faddi on 26/08/2016.
 */

public class SampleGPS extends FragmentActivity  {
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_gps_main);
    }*/
/*    private LocationManager locationManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onResume() {
        super.onResume();

        //Obtention de la référence du service
        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);

        //Si le GPS est disponible, on s'y abonne
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            abonnementGPS();
        }
    }
    @Override
    public void onPause() {
        super.onPause();

        //On appelle la méthode pour se désabonner
        desabonnementGPS();
    }

    /**
     * Méthode permettant de s'abonner à la localisation par GPS.
     */
/*    public void abonnementGPS() {
        //On s'abonne
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
    }

    /**
     * Méthode permettant de se désabonner de la localisation par GPS.
     */
/*    public void desabonnementGPS() {
        //Si le GPS est disponible, on s'y abonne
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(final Location location) {
        //On affiche dans un Toat la nouvelle Localisation
        final StringBuilder msg = new StringBuilder("lat : ");
        msg.append(location.getLatitude());
        msg.append( "; lng : ");
        msg.append(location.getLongitude());

        Toast.makeText(this, msg.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(final String provider) {
        //Si le GPS est désactivé on se désabonne
        if("gps".equals(provider)) {
            desabonnementGPS();
        }
    }

    @Override
    public void onProviderEnabled(final String provider) {
        //Si le GPS est activé on s'abonne
        if("gps".equals(provider)) {
            abonnementGPS();
        }
    }

    @Override
    public void onStatusChanged(final String provider, final int status, final Bundle extras) { }*/

    private GoogleMap GMap;
    private LatLng abidjan=new LatLng(3.881501,11.50818);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_gps_main);

        //on récupère le fragment définit dans le layout qui va contenir la carte
        GMap= ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        //on s'assure que l'objet map n'est pas vide
        if(GMap!=null){
            //mode d'affichage de la carte
            GMap.setTrafficEnabled(true);
            //on autorise l'api à afficher le bouton pour accéder à notre position courante
            GMap.setMyLocationEnabled(true);

            //définition du marqueur qui va se positionner sur le point qu'on désire afficher
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.title("POSITION");
            markerOptions.visible(true);
            markerOptions.position(abidjan);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

            //ajout du marqueur sur la carte
            GMap.addMarker(markerOptions);
            //zoom de la caméra sur la position qu'on désire afficher
            GMap.moveCamera(CameraUpdateFactory.newLatLngZoom(abidjan, 16));
            //animation le zoom toute les 2000ms
            GMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
        }
    }
}


