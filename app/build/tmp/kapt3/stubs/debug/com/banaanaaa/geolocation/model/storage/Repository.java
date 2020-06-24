package com.banaanaaa.geolocation.model.storage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\rJ\u0019\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/banaanaaa/geolocation/model/storage/Repository;", "", "pointDao", "Lcom/banaanaaa/geolocation/model/storage/dao/PointDao;", "(Lcom/banaanaaa/geolocation/model/storage/dao/PointDao;)V", "deletePoint", "", "point", "Lcom/banaanaaa/geolocation/model/entity/Point;", "(Lcom/banaanaaa/geolocation/model/entity/Point;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePoints", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPoint", "Landroidx/lifecycle/LiveData;", "id", "", "getPoints", "", "insertPoint", "updatePoint", "app_debug"})
public final class Repository {
    private final com.banaanaaa.geolocation.model.storage.dao.PointDao pointDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.banaanaaa.geolocation.model.entity.Point>> getPoints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.banaanaaa.geolocation.model.entity.Point> getPoint(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertPoint(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updatePoint(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deletePoint(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.entity.Point point, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deletePoints(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    public Repository(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.model.storage.dao.PointDao pointDao) {
        super();
    }
}