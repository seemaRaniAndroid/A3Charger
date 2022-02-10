package `in`.parangat.a3charger.model

import com.google.gson.annotations.SerializedName

data class VenueResponse(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: ArrayList<VenueDataItem>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class VenueDataItem(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("number_of_machines")
	val numberOfMachines: Int? = null,

	@field:SerializedName("create_time")
	val createTime: Int? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("not_delete")
	val notDelete: Int? = null,

	@field:SerializedName("zone_id")
	val zoneId: String? = null,

	@field:SerializedName("update_time")
	val updateTime: Any? = null,

	@field:SerializedName("category_id")
	val categoryId: Int? = null,

	@field:SerializedName("venue_type")
	val venueType: Any? = null,

	@field:SerializedName("number_of_outlets")
	val numberOfOutlets: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("tel")
	val tel: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("subcategory")
	val subcategory: Any? = null,

	@field:SerializedName("meeting_date")
	val meetingDate: Any? = null,

	@field:SerializedName("remarks")
	val remarks: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
