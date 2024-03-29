package cz.sedlardavid.eventorr.entities

data class Event(
    val access_method: Any? = null,
    val announce_date: String? = null,
    val announcements: Announcements? = null,
    val conditional: Boolean? = null,
    val created_at: String,
    val date_tbd: Boolean? = null,
    val datetime_local: String,
    val datetime_tbd: Boolean,
    val datetime_utc: String,
    val description: String,
    val domain_information: List<Any>? = null,
    val enddatetime_utc: Any? = null,
    val event_promotion: Any? = null,
    val general_admission: Boolean? = null,
    val id: Int,
    val is_open: Boolean? = null,
    val links: List<Any>? = null,
    val performers: List<Performer>,
    val popularity: Double? = null,
    val score: Double? = null,
    val short_title: String,
    val stats: StatsX? = null,
    val status: String? = null,
    val taxonomies: List<TaxonomyX>? = null,
    val themes: List<Any>? = null,
    val time_tbd: Boolean? = null,
    val title: String,
    val type: String,
    val url: String? = null,
    val venue: Venue? = null,
    val visible_until_utc: String
    ? = null
)