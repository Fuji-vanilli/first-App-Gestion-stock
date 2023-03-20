package com.gestionStock.stockgestion.service.implementation;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.gestionStock.stockgestion.service.FlickrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FlickrServiceImpl implements FlickrService {

    private final Flickr flickr;

    @Override
    public String savePicture(InputStream picture, String title) throws FlickrException {
        UploadMetaData uploadMetaData= new UploadMetaData();

        uploadMetaData.setTitle(title);

        String pictureId= flickr.getUploader().upload(picture, uploadMetaData);

        return flickr.getPhotosInterface().getPhoto(pictureId).getMedium640Url();
    }
}
