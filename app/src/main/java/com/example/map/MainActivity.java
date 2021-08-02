package com.example.map;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private MapView mapView;
    private static NaverMap naverMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //네이버 지도
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

    }

    @Override
    public void onMapReady( NaverMap naverMap)
    {
        this.naverMap = naverMap;

        CameraPosition cameraPosition = new CameraPosition(
                new LatLng(35.88904458858192,
                        128.610331884439),
                14.5
        );

        Marker marker = new Marker();
        marker.setPosition(new LatLng(35.88904458858192, 128.610331884439));
        marker.setMap(naverMap);
        marker.setWidth(70);
        marker.setHeight(100);
        marker.setCaptionText("경북대학교");
        

        naverMap.setCameraPosition(cameraPosition);
    }
}
