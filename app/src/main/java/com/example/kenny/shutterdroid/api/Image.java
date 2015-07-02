package com.example.kenny.shutterdroid.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kenny on 15-07-01.
 */
public class Image {
    @SerializedName("id")
    private String mID;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("assets")
    private ImageAssets mAssets;

    public String getID() {
        return mID;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getLargeThumb() {
        return mAssets.mLargeThumb.mUrl;
    }

    private class ImageAssets{
        @SerializedName("preview")
        private Thumbnail mPreview;

        @SerializedName("small_thumb")
        private Thumbnail mSmallThumb;

        @SerializedName("large_thumb")
        private Thumbnail mLargeThumb;
    }

    private class Thumbnail{
        @SerializedName("url")
        private String mUrl;
    }
}
