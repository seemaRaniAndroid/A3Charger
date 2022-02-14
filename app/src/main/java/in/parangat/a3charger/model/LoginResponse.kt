package `in`.parangat.a3charger.model

data class LoginResponse(
    val code: Int,
    val `data`: Data,
    val msg: String,
    val status: String
)
data class Data(
    val avatar: Any,
    val city: Any,
    val country: Any,
    val create_time: Int,
    val email: Any,
    val gender: Any,
    val id: Int,
    val is_auth: Int,
    val last_login: Any,
    val mobile: Any,
    val nick: String,
    val not_delete: Int,
    val password: String,
    val status: Int,
    val token: Any,
    val update_time: Any,
    val zone_ids: String
)