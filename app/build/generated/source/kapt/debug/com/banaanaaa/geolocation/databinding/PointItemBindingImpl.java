package com.banaanaaa.geolocation.databinding;
import com.banaanaaa.geolocation.R;
import com.banaanaaa.geolocation.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PointItemBindingImpl extends PointItemBinding implements com.banaanaaa.geolocation.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.fields, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PointItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private PointItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageButton) bindings[5]
            , (android.widget.ImageButton) bindings[4]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[1]
            );
        this.buttonDelete.setTag(null);
        this.buttonEdit.setTag(null);
        this.latitudeTextView.setTag(null);
        this.longitudeTextView.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nameTextView.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.banaanaaa.geolocation.generated.callback.OnClickListener(this, 2);
        mCallback3 = new com.banaanaaa.geolocation.generated.callback.OnClickListener(this, 3);
        mCallback1 = new com.banaanaaa.geolocation.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.listener == variableId) {
            setListener((com.banaanaaa.geolocation.view.FragmentList.Listener) variable);
        }
        else if (BR.point == variableId) {
            setPoint((com.banaanaaa.geolocation.model.entity.Point) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.banaanaaa.geolocation.view.FragmentList.Listener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setPoint(@Nullable com.banaanaaa.geolocation.model.entity.Point Point) {
        this.mPoint = Point;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.point);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        double pointLatitude = 0.0;
        java.lang.String longitudeTextViewAndroidStringItemLongitudeJavaLangStringPointLongitude = null;
        java.lang.String latitudeTextViewAndroidStringItemLatitudeJavaLangStringPointLatitude = null;
        com.banaanaaa.geolocation.view.FragmentList.Listener listener = mListener;
        com.banaanaaa.geolocation.model.entity.Point point = mPoint;
        java.lang.String nameTextViewAndroidStringItemNameJavaLangStringPointName = null;
        double pointLongitude = 0.0;
        java.lang.String pointName = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (point != null) {
                    // read point.latitude
                    pointLatitude = point.getLatitude();
                    // read point.longitude
                    pointLongitude = point.getLongitude();
                    // read point.name
                    pointName = point.getName();
                }


                // read ((@android:string/item_latitude) + (": ")) + (point.latitude)
                latitudeTextViewAndroidStringItemLatitudeJavaLangStringPointLatitude = ((latitudeTextView.getResources().getString(R.string.item_latitude)) + (": ")) + (pointLatitude);
                // read ((@android:string/item_longitude) + (": ")) + (point.longitude)
                longitudeTextViewAndroidStringItemLongitudeJavaLangStringPointLongitude = ((longitudeTextView.getResources().getString(R.string.item_longitude)) + (": ")) + (pointLongitude);
                // read ((@android:string/item_name) + (": ")) + (point.name)
                nameTextViewAndroidStringItemNameJavaLangStringPointName = ((nameTextView.getResources().getString(R.string.item_name)) + (": ")) + (pointName);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.buttonDelete.setOnClickListener(mCallback3);
            this.buttonEdit.setOnClickListener(mCallback2);
            this.mboundView0.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.latitudeTextView, latitudeTextViewAndroidStringItemLatitudeJavaLangStringPointLatitude);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.longitudeTextView, longitudeTextViewAndroidStringItemLongitudeJavaLangStringPointLongitude);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nameTextView, nameTextViewAndroidStringItemNameJavaLangStringPointName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.banaanaaa.geolocation.view.FragmentList.Listener listener = mListener;
                // point
                com.banaanaaa.geolocation.model.entity.Point point = mPoint;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {



                    listener.rename(point);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.banaanaaa.geolocation.view.FragmentList.Listener listener = mListener;
                // point
                com.banaanaaa.geolocation.model.entity.Point point = mPoint;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {



                    listener.delete(point);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.banaanaaa.geolocation.view.FragmentList.Listener listener = mListener;
                // point
                com.banaanaaa.geolocation.model.entity.Point point = mPoint;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {



                    listener.click(point);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): listener
        flag 1 (0x2L): point
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}