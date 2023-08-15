package com.example.anonymous_store_sprint6.data.remote

/*
"id": 1,
"name": "Samsung Galaxy A21s 64GB",
"price": 167253,
"image": "https://images.samsung.com/is/image/samsung/es-galaxy-a21s-sm-a217fzkoeub-262755098?$PD_GALLERY_L_JPG$"
},

 */

data class Cell(
    val id: String,
    val name: String,
    val price: Int,
    val image: String
)