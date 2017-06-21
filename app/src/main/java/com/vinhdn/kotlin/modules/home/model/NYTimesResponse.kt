package com.vinhdn.kotlin.modules.home.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

/**
 * Created by vinh on 5/23/17.
 */

class NYTimesResponse(val response: DocsResponse)

class DocsResponse(val docs : List<PostResponse>)

class PostResponse(
        @Json(name = "web_url") @SerializedName("web_url")val webUrl : String,
        val snippet : String?,
        @Json(name = "lead_paragraph") @SerializedName("lead_paragraph")val leadParagraph: String?,
        val multimedia : List<MultimediaResponse>?
)

class MultimediaResponse(val url : String)