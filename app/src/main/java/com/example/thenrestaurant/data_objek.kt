package com.example.thenrestaurant

object data_objek {
    private val dataArtist = arrayOf(
        "Rex Orange County",
        "Blackbear",
        "Alessia Cara"
    )

    private val content = arrayOf(
        "This is the first band, i'm not good with words but let me put lorem text here " +
                "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. " +
                "Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet.",

        "This is the second band, i'm not good with words but let me put lorem text here " +
                "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. " +
                "Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet.",

        "This is the thrid band, i'm not good with words but let me put lorem text here " +
                "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. " +
                "Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet.",
    )

    private val dataPerformDate = arrayOf(
        "Saturday, 29 Dec 2020 - 8PM",
        "Saturday, 3 Jan 2021 - 8PM",
        "Sunday, 13 Jan 2021 - 9PM"
    )

    private val bannerArtist = intArrayOf(
        R.drawable.artist1,
        R.drawable.artist2,
        R.drawable.artist3
    )

    private val diningCat = arrayOf(
        "Dining",
        "Dessert",
        "Drink"
    )

    private val bannerCat = intArrayOf(
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3
    )

    private val foodname = arrayOf(
        "Carbonara",
        "Expensive Steak",
        "Chicken Gyoza"

    )

    private val food_price = arrayOf(
        "\$15",
        "\$7",
        "\$23",
        "\$15",
        "\$7",
        "\$23",
        "\$15",
        "\$7",
        "\$23",
        "\$5"
    )

    private val food_time = arrayOf(
        "10m",
        "8m",
        "15m",
        "10m",
        "8m",
        "15m",
        "10m",
        "8m",
        "15m",
        "20m"
    )

    private val food_origin = arrayOf(
        "Westren",
        "Asia",
        "Westren",
        "Westren",
        "Asia",
        "Westren",
        "Westren",
        "Asia",
        "Westren",
        "Westren"
    )

    private val food_rating = doubleArrayOf(
        4.5,
        4.0,
        3.9,
        4.5,
        4.0,
        3.9,
        4.5,
        4.0,
        3.9,
        3.5
    )

    private val food_img = intArrayOf(
        R.drawable.food1,
        R.drawable.food2,
        R.drawable.food3
    )

    private val drinkName = arrayOf(
        "Vesper martini",
        "Hot machiato",
        "Gin"

    )

    private val drink_price = arrayOf(
        "\$9",
        "\$7",
        "\$2",
    )

    private val drink_time = arrayOf(
        "4m",
        "5m",
        "1m",
    )

    private val drinkType = arrayOf(
        "Alcohol",
        "No alcohol",
        "Alcohol",
    )

    private val drink_rating = arrayOf(
        4.5,
        4.0,
        3.9
    )

    private val drink_img = intArrayOf(
        R.drawable.drink1,
        R.drawable.drink2,
        R.drawable.drink3
    )

    private val drink_wine = intArrayOf(
        R.drawable.wine1,
        R.drawable.wine2,
        R.drawable.wine3
    )

    private val asian_food = arrayOf(
        "Indomie Supreme",
        "Marinate Shimp",
        "Dumpling with Oregano",
        "Pumpkin Soup",
        "Grilled Fruit Flatter",
        "Salmon Truffle",
        "Fruit Taco",
        "Avocado Slash",
        "Bacon with Eggg",
        "Ribeye Steak"
    )

    private val asian_img = intArrayOf(
        R.drawable.asian1,
        R.drawable.asian2,
        R.drawable.asian3,
        R.drawable.asian4,
        R.drawable.asian5,
        R.drawable.asian6,
        R.drawable.asian7,
        R.drawable.asian8,
        R.drawable.asian9,
        R.drawable.asian10,
    )
    private val food_desc = Array<String>(asian_food.size
    ) { i ->
        "This is food description number ${asian_food.indices} and another lorem text " +
                "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. " +
                "Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet."
    }

    private val food_alergic = Array<String>(asian_food.size
    ) { i ->
        "This is alergic desc number ${asian_food.indexOf(asian_food.size)} and another lorem text " +
                "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. " +
                "Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet."
    }

    private val wine = arrayOf(
        "A 15 years old white wine",
        "Basic but expensive white wine",
        "Idk man, just wine"
    )

    val foodDetal : ArrayList<DataFoodDetail>
    get() {
        val list = arrayListOf<DataFoodDetail>()
        for (i in asian_food.indices){
            val j = DataFoodDetail()
            j.food_name = asian_food[i]
            j.food_price = food_price[i]
            j.food_time = this.food_time[i]
            j.food_img = asian_img[i]
            j.food_rating = this.food_rating[i]
            j.food_desc =  this.food_desc[i]
            j.food_alergic = this.food_alergic[i]
            list.add(j)
        }
        return list
    }

    val upcomingEvent : ArrayList<DataUpcomingEvent>
    get() {
        val list = arrayListOf<DataUpcomingEvent>()
        for (i in dataArtist.indices){
            val j = DataUpcomingEvent()
            j.artist_name = dataArtist[i]
            j.perform_date = dataPerformDate[i]
            j.banner_img = bannerArtist[i]
            j.detail = content[i]
            list.add(j)
        }
        return list
    }

    val cat : ArrayList<DataBeverage>
    get() {
        val list = arrayListOf<DataBeverage>()
        for (i in diningCat.indices){
            val j = DataBeverage()
            j.dining_category = diningCat[i]
            j.banner_cat = bannerCat[i]
            list.add(j)
        }
        return list
    }

    val newwMenu : ArrayList<DataNewMenu>
        get() {
            val list = arrayListOf<DataNewMenu>()
            for (i in foodname.indices){
                val j = DataNewMenu()
                j.food_name = this.foodname[i]
                j.food_price = this.food_price[i]
                j.food_img = this.food_img[i]
                j.food_time = this.food_time[i]
                j.food_loc = this.food_origin[i]
                j.food_rating = this.food_rating[i]
                list.add(j)
            }
            return list
        }
    val bestDrink : ArrayList<DataFoodDetail>
        get() {
            val list = arrayListOf<DataFoodDetail>()
            for (i in drinkName.indices){
                    val d = DataFoodDetail()
                d.food_name = this.drinkName[i]
                d.food_price = this.drink_price[i]
                d.food_img = this.drink_img[i]
                d.food_time = this.drink_time[i]
                d.food_loc = this.drinkType[i]
                d.food_rating = this.drink_rating[i]
                d.food_alergic = this.food_alergic[i]
                d.food_desc = this.food_desc[i]
                list.add(d)
            }
            return list
        }
    val bestwine : ArrayList<DataFoodDetail>
        get() {
            val list = arrayListOf<DataFoodDetail>()
            for (i in wine.indices){
                val d = DataFoodDetail()
                d.food_name = this.wine[i]
                d.food_price = this.drink_price[i]
                d.food_img = this.drink_wine[i]
                d.food_time = this.drink_time[i]
                d.food_loc = this.drinkType[i]
                d.food_rating = this.drink_rating[i]
                d.food_alergic = this.food_alergic[i]
                d.food_desc = this.food_desc[i]
                list.add(d)
            }
            return list
        }

}