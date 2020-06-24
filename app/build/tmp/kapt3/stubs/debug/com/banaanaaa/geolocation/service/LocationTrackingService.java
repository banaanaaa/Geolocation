package com.banaanaaa.geolocation.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/banaanaaa/geolocation/service/LocationTrackingService;", "Landroid/app/Service;", "()V", "myMessenger", "Landroid/os/Messenger;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "IncomingHandler", "app_debug"})
public final class LocationTrackingService extends android.app.Service {
    private final android.os.Messenger myMessenger = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    public LocationTrackingService() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/banaanaaa/geolocation/service/LocationTrackingService$IncomingHandler;", "Landroid/os/Handler;", "(Lcom/banaanaaa/geolocation/service/LocationTrackingService;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "app_debug"})
    public final class IncomingHandler extends android.os.Handler {
        
        @java.lang.Override()
        public void handleMessage(@org.jetbrains.annotations.NotNull()
        android.os.Message msg) {
        }
        
        public IncomingHandler() {
            super();
        }
    }
}