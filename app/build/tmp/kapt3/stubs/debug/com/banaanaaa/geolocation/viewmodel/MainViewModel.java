package com.banaanaaa.geolocation.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u00016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\"J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010%\u001a\u00020\u0019J\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000fJ\u000e\u0010\'\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\fJ\u0014\u0010(\u001a\u00020\u001f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u0010J\b\u0010*\u001a\u0004\u0018\u00010\u0006J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0018\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0016\u0010.\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010/\u001a\u00020\u001fJ\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0006J\u000e\u00102\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\fJ\u000e\u00103\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\fJ\u000e\u00104\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\fJ\u000e\u00105\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/banaanaaa/geolocation/viewmodel/MainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "mMarkers", "Ljava/util/HashMap;", "", "Lcom/google/android/gms/maps/model/Marker;", "mPoints", "Lcom/banaanaaa/geolocation/model/entity/Point;", "mSelectedPointName", "points", "Landroidx/lifecycle/LiveData;", "", "repository", "Lcom/banaanaaa/geolocation/model/storage/Repository;", "addPoint", "Lcom/banaanaaa/geolocation/viewmodel/MainViewModel$NameValidationResult;", "point", "checkDistance", "", "accuracy", "", "location", "Landroid/location/Location;", "checkPointName", "name", "deleteMarker", "", "deleteMarkers", "deletePoint", "Lkotlinx/coroutines/Job;", "deletePoints", "getPoint", "id", "getPoints", "insertPoint", "loadList", "list", "loadMap", "moveCamera", "renameMarker", "oldName", "renamePoint", "returnIcon", "saveMap", "map", "saveMarker", "savePoint", "selectMarker", "updatePoint", "NameValidationResult", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.banaanaaa.geolocation.model.storage.Repository repository = null;
    private androidx.lifecycle.LiveData<java.util.List<com.banaanaaa.geolocation.model.entity.Point>> points;
    private java.util.HashMap<java.lang.String, com.google.android.gms.maps.model.Marker> mMarkers;
    private java.util.HashMap<java.lang.String, com.banaanaaa.geolocation.model.entity.Point> mPoints;
    private com.google.android.gms.maps.GoogleMap mMap;
    private java.lang.String mSelectedPointName = "-909";
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.banaanaaa.geolocation.model.entity.Point>> getPoints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.banaanaaa.geolocation.model.entity.Point> getPoint(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertPoint(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updatePoint(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deletePoint(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deletePoints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.banaanaaa.geolocation.viewmodel.MainViewModel.NameValidationResult addPoint(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.banaanaaa.geolocation.viewmodel.MainViewModel.NameValidationResult renamePoint(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.banaanaaa.geolocation.viewmodel.MainViewModel.NameValidationResult checkPointName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    public final void saveMap(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap map) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.maps.GoogleMap loadMap() {
        return null;
    }
    
    public final void loadList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.banaanaaa.geolocation.model.entity.Point> list) {
    }
    
    public final void savePoint(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point) {
    }
    
    public final void saveMarker(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point) {
    }
    
    private final void renameMarker(java.lang.String oldName, com.banaanaaa.geolocation.model.entity.Point point) {
    }
    
    public final void deleteMarker(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point) {
    }
    
    public final void deleteMarkers() {
    }
    
    public final void selectMarker(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point) {
    }
    
    public final void returnIcon() {
    }
    
    private final void moveCamera(com.banaanaaa.geolocation.model.entity.Point point) {
    }
    
    public final boolean checkDistance(int accuracy, @org.jetbrains.annotations.NotNull()
    android.location.Location location) {
        return false;
    }
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/banaanaaa/geolocation/viewmodel/MainViewModel$NameValidationResult;", "", "(Ljava/lang/String;I)V", "TOO_SHORT", "TOO_LONG", "ALREADY_EXISTS", "SUCCESS", "app_debug"})
    public static enum NameValidationResult {
        /*public static final*/ TOO_SHORT /* = new TOO_SHORT() */,
        /*public static final*/ TOO_LONG /* = new TOO_LONG() */,
        /*public static final*/ ALREADY_EXISTS /* = new ALREADY_EXISTS() */,
        /*public static final*/ SUCCESS /* = new SUCCESS() */;
        
        NameValidationResult() {
        }
    }
}