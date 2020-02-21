package com.remote.model.campaigns

import com.google.gson.annotations.SerializedName
import com.remote.model.image.Image

data class Banners(
    @SerializedName("image") val image: Image?
) : ParentCampaign()