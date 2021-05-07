package com.okeanarium.ocean.database_server

class InitDatabase {
    fun InitDatabase(db:AppDatabase){

            //Стандартные данные для сеансов

        db.seansDao().insertSeans(Seans(1,"Шоу Воды","05.04","18:00","https://www.moskvarium.ru/upload/iblock/48f/800kh580.jpg"))
        db.seansDao().insertSeans( Seans(2,"Океан в городе","06.04","18:00","https://www.moskvarium.ru/upload/iblock/5b0/IMG_9193.jpg"))
        db.seansDao().insertSeans( Seans(3,"Сон в летнюю ночь","07.04","12:00","https://www.moskvarium.ru/upload/iblock/abc/novost.jpg"))
        db.seansDao().insertSeans( Seans(4,"Плавание с дельфинами","08.04","13:00","https://www.moskvarium.ru/upload/iblock/ef7/ef7358707eb51018727cf42408db59ef.jpg"))
        db.seansDao().insertSeans( Seans(5,"Шоу с акулами","09.04","15:00","https://океанариум.рф/upload/iblock/067/shouakulki.jpg"))
        db.seansDao().insertSeans( Seans(6,"Шоу с тюленями","012.04","13:00","https://океанариум.рф/upload/iblock/3f4/gosha.jpg"))
        db.seansDao().insertSeans( Seans(7,"Выставка морских рыб","13.04","18:00","https://www.felda.ie/wp-content/uploads/2017/06/blog_post_10_content.jpg"))
        db.seansDao().insertSeans( Seans(8,"Дайвинг","015.04","15:00","https://i.ytimg.com/vi/-d87SgdyUJM/maxresdefault.jpg"))

            //Стандартные данные для сувениров
        db.suvenierDao().insertSuvenier(Suvenier(1,"Косатка 30 см","Компактная косатка, с которой не захочется расставаться ни на минуту и удобно взять с собой.\n" +
                "Очаровательные игрушечные копии главных звёзд Москвариума - косаток Нарнии, Норда и Найи станут лучшими друзьями больших и маленьких любителей подводного мира.\n" +
                "Созданы по индивидуальному заказу Москвариума.\n" +
                "\n" +
                "Состав: Ткань – искусственный мех, коротковорсовый плюш; наполнитель - синтепух. Глаза – пластиковая фурнитура\n" +
                "\n" +
                "Товар сертифицирован.\n" +
                "Предварительная ручная стирка обязательна, не гладить.","https://static.tildacdn.com/tild3535-3633-4931-b733-336263373430/__1.jpg"))
        db.suvenierDao().insertSuvenier(Suvenier(2,"Динозавр в яйце","Состав: Ткань – искусственный мех наполнитель – полиэфирное волокно.\n" +
                "\n" +
                "Товар сертифицирован.\n" +
                "Предварительная ручная стирка обязательна, не гладить.\n" +
                "\n" +
                "\n" +
                "Возраст: 3+\n" +
                "\n" +
                "Цвет: Оранжевый\n" +
                "\n" +
                "Производитель: Китай\n" +
                "\n" +
                "Срок годности: Не ограничен","https://static.tildacdn.com/tild3638-3631-4364-a133-366261643232/2541.jpg"))

        db.suvenierDao().insertSuvenier(Suvenier(3,"Кружка Морской чёрт","Объём : 300 мл\n" +
                "\n" +
                "Мытьё в посудомоечной машине разрешено. Срок годности не ограничен.\n" +
                "\n" +
                "Товар не подлежит обязательной сертификации\n" +
                "\n" +
                "Материал: Фаянс\n" +
                "\n" +
                "Производитель: Россия","https://static.tildacdn.com/tild6332-3936-4635-b538-346665376162/ADN_669723.jpg"))

    }
}