package com.banaanaaa.geolocation.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J:\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/banaanaaa/geolocation/util/FilterNumber;", "Landroid/text/InputFilter;", "min", "", "max", "(II)V", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "isInRange", "", "input", "app_debug"})
public final class FilterNumber implements android.text.InputFilter {
    private final int min = 0;
    private final int max = 0;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.CharSequence filter(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence source, int start, int end, @org.jetbrains.annotations.NotNull()
    android.text.Spanned dest, int dstart, int dend) {
        return null;
    }
    
    private final boolean isInRange(int input) {
        return false;
    }
    
    public FilterNumber(int min, int max) {
        super();
    }
}