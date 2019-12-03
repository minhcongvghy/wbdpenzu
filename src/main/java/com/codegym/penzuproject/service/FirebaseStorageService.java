package com.codegym.penzuproject.service;

import com.codegym.penzuproject.model.Diary;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract  class FirebaseStorageService<T> {

    private StorageClient getFirebaseStorage() {
        try {
            GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();

//            JSONObject jsonObject = new JSONObject(environment.getProperty("GOOGLE_KEY"));
//            GoogleCredentials credentials = GoogleCredentials.fromStream(new ByteArrayInputStream(environment.getProperty("GOOGLE_KEY").getBytes()));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .setDatabaseUrl("https://penzu500.firebaseio.com")
                    .setStorageBucket("penzu500.appspot.com")
                    .build();

            FirebaseApp fireApp = null;
            List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
            if (firebaseApps != null && !firebaseApps.isEmpty()) {
                for (FirebaseApp app : firebaseApps) {
                    if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME))
                        fireApp = app;
                }
            } else
                fireApp = FirebaseApp.initializeApp(options);
            return StorageClient.getInstance(fireApp);
        } catch (IOException ex) {
            throw new RuntimeException("Could not get admin-sdk json file. Please try again!", ex);
        }
    }

    private String getNewExtension(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        return originalFileName!=null?originalFileName.substring(originalFileName.lastIndexOf(".") + 1):"";
    }

    private String getFileName(Object object, MultipartFile file) {
        String extension = getNewExtension(file);
        if (object instanceof Diary) {
            Diary diary = (Diary) object;
            return diary.getId().toString().concat(" - ").concat(diary.getTitle()).concat(".").concat(extension);
        }

        return null;
    }

    public String saveToFirebaseStorage(Object object, MultipartFile file) throws IOException {
        String fileName = getFileName(object, file);
        StorageClient storageClient = getFirebaseStorage();
        Bucket bucket = storageClient.bucket();

        try {
            InputStream testFile = file.getInputStream();
            String blobString = "";
            if (object instanceof Diary) {
                blobString = "diary/" + fileName;
            }

            Blob blob = bucket.create(blobString, testFile, Bucket.BlobWriteOption.userProject("penzu500"));
            bucket.getStorage().updateAcl(blob.getBlobId(), Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
            String blobName = blob.getName();

            if (object instanceof Diary) {
                ((Diary) object).setBlobString(blobName);
            }
            return blob.getMediaLink();
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public RuntimeException deleteFirebaseStorageFile(Object object) {
        try {
            StorageClient storageClient = getFirebaseStorage();
            String blobString = "";
            if (object instanceof Diary) {
                blobString = ((Diary) object).getBlobString();
            }

            BlobId blobId = BlobId.of(storageClient.bucket().getName(), blobString);
            storageClient.bucket().getStorage().delete(blobId);
        } catch (Exception e) {
            return new RuntimeException("Error when delete file on Firebase" + e);
        }
        return null;
    }

}