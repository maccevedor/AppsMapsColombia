package ca.sfu.cmpt276.bfraser;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {
	private final LatLng LOCATION_BURNABY = new LatLng(7.09818,-73.118211);
	private final LatLng LOCATION_SURRREY = new LatLng(7.119344,-73.112392);
	
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		map  = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		map.addMarker(new MarkerOptions().position(LOCATION_SURRREY).title("Find me here!"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick_City(View v) {
//		CameraUpdate update = CameraUpdateFactory.newLatLng(LOCATION_BURNABY);
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_BURNABY, 9);
		map.animateCamera(update);
	}
	public void onClick_Burnaby(View v) {
		map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_BURNABY, 14);
		map.animateCamera(update);
		
	}
	public void onClick_Surrey(View v) {
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_SURRREY, 16);
		map.animateCamera(update);
		
	}

}
