package com.example.thenrestaurant

data class DataUpcomingEvent(
    var artist_name: String = "Anna",
    var perform_date : String ="soon",
    var banner_img : Int = 0,
    var detail : String = ""
)

data class DataBeverage(
    var dining_category : String = "general",
    var banner_cat : Int = 0
)

open class DataNewMenu(
    var food_name : String = "",
    var food_loc : String ="default",
    var food_rating : Double = 1.0,
    var food_img : Int = 0,
    var food_time : String = "default",
    var food_price : String = "default"
)

open class DataDrink(): DataNewMenu()
class DataFoodDetail(
    var food_alergic : String = "",
    var food_desc : String = "",
) : DataDrink()


