package com.banaanaaa.geolocation.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u001b\u0010\u0013\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0000\u00a2\u0006\u0002\b\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/banaanaaa/geolocation/view/PointListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/banaanaaa/geolocation/view/PointListAdapter$PointViewHolder;", "listener", "Lcom/banaanaaa/geolocation/view/FragmentList$Listener;", "(Lcom/banaanaaa/geolocation/view/FragmentList$Listener;)V", "points", "", "Lcom/banaanaaa/geolocation/model/entity/Point;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setPoints", "", "setPoints$app_debug", "PointViewHolder", "app_debug"})
public final class PointListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.banaanaaa.geolocation.view.PointListAdapter.PointViewHolder> {
    private final java.util.List<com.banaanaaa.geolocation.model.entity.Point> points = null;
    private final com.banaanaaa.geolocation.view.FragmentList.Listener listener = null;
    
    public final void setPoints$app_debug(@org.jetbrains.annotations.NotNull()
    java.util.List<com.banaanaaa.geolocation.model.entity.Point> points) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.banaanaaa.geolocation.view.PointListAdapter.PointViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.view.PointListAdapter.PointViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public PointListAdapter(@org.jetbrains.annotations.NotNull()
    com.banaanaaa.geolocation.view.FragmentList.Listener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/banaanaaa/geolocation/view/PointListAdapter$PointViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/banaanaaa/geolocation/databinding/PointItemBinding;", "(Lcom/banaanaaa/geolocation/view/PointListAdapter;Lcom/banaanaaa/geolocation/databinding/PointItemBinding;)V", "getBinding", "()Lcom/banaanaaa/geolocation/databinding/PointItemBinding;", "app_debug"})
    public final class PointViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.banaanaaa.geolocation.databinding.PointItemBinding binding = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.banaanaaa.geolocation.databinding.PointItemBinding getBinding() {
            return null;
        }
        
        public PointViewHolder(@org.jetbrains.annotations.NotNull()
        com.banaanaaa.geolocation.databinding.PointItemBinding binding) {
            super(null);
        }
    }
}