package com.okeanarium.ocean.database_server

class InitDatabase {
    fun InitDatabase(db:AppDatabase){


            val seans = Seans(null,"Шоу Воды","05.04","18:00","https://www.moskvarium.ru/upload/iblock/48f/800kh580.jpg");
            val seans2 = Seans(null,"Океан в городе","06.04","18:00","https://www.moskvarium.ru/upload/iblock/5b0/IMG_9193.jpg");
            db.seansDao().insertSeans(seans)
            db.seansDao().insertSeans(seans2)
    }
}