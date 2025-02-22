package com.example.keddit


data class RedditNews(
    val `data`: Data,
    val kind: String
)

data class Data(
    val after: String,
    val before: Any,
    val children: List<Children>,
    val dist: Int,
    val geo_filter: String,
    val modhash: String
)

data class Children(
    val `data`: DataX,
    val kind: String
)

data class DataX(
    val all_awardings: List<Any?>,
    val allow_live_comments: Boolean,
    val approved_at_utc: Any,
    val approved_by: Any,
    val archived: Boolean,
    val author: String,
    val author_flair_background_color: Any,
    val author_flair_css_class: Any,
    val author_flair_richtext: List<Any?>,
    val author_flair_template_id: Any,
    val author_flair_text: Any,
    val author_flair_text_color: Any,
    val author_flair_type: String,
    val author_fullname: String,
    val author_is_blocked: Boolean,
    val author_patreon_flair: Boolean,
    val author_premium: Boolean,
    val awarders: List<Any?>,
    val banned_at_utc: Any,
    val banned_by: Any,
    val can_gild: Boolean,
    val can_mod_post: Boolean,
    val category: Any,
    val clicked: Boolean,
    val content_categories: List<String>,
    val contest_mode: Boolean,
    val created: Double,
    val created_utc: Double,
    val discussion_type: Any,
    val distinguished: Any,
    val domain: String,
    val downs: Int,
    val edited: Boolean,
    val gallery_data: GalleryData,
    val gilded: Int,
    val gildings: Gildings,
    val hidden: Boolean,
    val hide_score: Boolean,
    val id: String,
    val is_created_from_ads_ui: Boolean,
    val is_crosspostable: Boolean,
    val is_gallery: Boolean,
    val is_meta: Boolean,
    val is_original_content: Boolean,
    val is_reddit_media_domain: Boolean,
    val is_robot_indexable: Boolean,
    val is_self: Boolean,
    val is_video: Boolean,
    val likes: Any,
    val link_flair_background_color: String,
    val link_flair_css_class: String,
    val link_flair_richtext: List<LinkFlairRichtext>,
    val link_flair_template_id: String,
    val link_flair_text: String,
    val link_flair_text_color: String,
    val link_flair_type: String,
    val locked: Boolean,
    val media: Media,
    val media_embed: MediaEmbed,
    val media_metadata: MediaMetadata,
    val media_only: Boolean,
    val mod_note: Any,
    val mod_reason_by: Any,
    val mod_reason_title: Any,
    val mod_reports: List<Any?>,
    val name: String,
    val no_follow: Boolean,
    val num_comments: Int,
    val num_crossposts: Int,
    val num_reports: Any,
    val over_18: Boolean,
    val permalink: String,
    val pinned: Boolean,
    val post_hint: String,
    val preview: Preview,
    val pwls: Int,
    val quarantine: Boolean,
    val removal_reason: Any,
    val removed_by: Any,
    val removed_by_category: Any,
    val report_reasons: Any,
    val saved: Boolean,
    val score: Int,
    val secure_media: SecureMedia,
    val secure_media_embed: SecureMediaEmbed,
    val selftext: String,
    val selftext_html: Any,
    val send_replies: Boolean,
    val spoiler: Boolean,
    val stickied: Boolean,
    val subreddit: String,
    val subreddit_id: String,
    val subreddit_name_prefixed: String,
    val subreddit_subscribers: Int,
    val subreddit_type: String,
    val suggested_sort: String,
    val thumbnail: String,
    val thumbnail_height: Int,
    val thumbnail_width: Int,
    val title: String,
    val top_awarded_type: Any,
    val total_awards_received: Int,
    val treatment_tags: List<Any?>,
    val ups: Int,
    val upvote_ratio: Double,
    val url: String,
    val url_overridden_by_dest: String,
    val user_reports: List<Any?>,
    val view_count: Any,
    val visited: Boolean,
    val wls: Int
)

data class GalleryData(
    val items: List<Item>
)

class Gildings

data class LinkFlairRichtext(
    val a: String,
    val e: String,
    val t: String,
    val u: String
)

data class Media(
    val reddit_video: RedditVideo
)

class MediaEmbed

data class MediaMetadata(
    val `0sxs6v9h1zvd1`: Sxs6v9h1zvd1,
    val admtnv9h1zvd1: Admtnv9h1zvd1
)

data class Preview(
    val enabled: Boolean,
    val images: List<Image>
)

data class SecureMedia(
    val reddit_video: RedditVideo
)

class SecureMediaEmbed

data class Item(
    val id: Int,
    val media_id: String
)

data class RedditVideo(
    val bitrate_kbps: Int,
    val dash_url: String,
    val duration: Int,
    val fallback_url: String,
    val has_audio: Boolean,
    val height: Int,
    val hls_url: String,
    val is_gif: Boolean,
    val scrubber_media_url: String,
    val transcoding_status: String,
    val width: Int
)

data class Sxs6v9h1zvd1(
    val e: String,
    val id: String,
    val m: String,
    val p: List<P>,
    val s: S,
    val status: String
)

data class Admtnv9h1zvd1(
    val e: String,
    val id: String,
    val m: String,
    val p: List<P>,
    val s: S,
    val status: String
)

data class P(
    val u: String,
    val x: Int,
    val y: Int
)

data class S(
    val u: String,
    val x: Int,
    val y: Int
)

data class Image(
    val id: String,
    val resolutions: List<Resolution>,
    val source: Source,
    val variants: Variants
)

data class Resolution(
    val height: Int,
    val url: String,
    val width: Int
)

data class Source(
    val height: Int,
    val url: String,
    val width: Int
)

class Variants
