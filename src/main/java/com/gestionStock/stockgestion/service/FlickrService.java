package com.gestionStock.stockgestion.service;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrService {

    String savePicture(InputStream picture, String title) throws FlickrException;
}
