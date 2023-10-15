package com.isikkaya.besinlerkitabi.servis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.isikkaya.besinlerkitabi.model.Besin


@Dao
interface BesinDAO {

    //Data Access Object

    @Insert
    suspend fun insertAll(vararg besin : Besin) : List<Long>

    //Insert -> Room'dan geliyor, insert info islemi icin gerekli
    //suspend -> corotine scope'unda cagrılacagı icin
    //vararg -> birden fazla ve istedigimiz sayıda besin objesini buraya vermemiz icin
    //List<Long> -> long döndürmesininin nedeni az önce besin(model) 'de yazdıgımız uuid idler


    @Query("SELECT * FROM besin")
    suspend fun getAllBesin() : List<Besin>

    @Query("SELECT * FROM besin WHERE uuid = :besinId")
    suspend fun getBesin(besinId : Int) : Besin

    @Query("DELETE FROM besin")
    suspend fun deleteAllBesin()


}