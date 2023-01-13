package com.example.appmeudiario.Domain

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import com.example.appmeudiario.DiaryDescription
import java.util.Date

class DiaryDomain(
    private var title: String,
    private var description: String,
    private var emoji: String,
    private var day: String,
    private var month: String,
    private var year: String,
    //private var date: Date
) : Parcelable{

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(emoji)
        parcel.writeString(day)
        parcel.writeString(month)
        parcel.writeString(year)
    }

    companion object CREATOR : Parcelable.Creator<DiaryDomain> {
        override fun createFromParcel(parcel: Parcel): DiaryDomain {
            return DiaryDomain(
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
            )
        }

        override fun newArray(size: Int): Array<DiaryDomain?> {
            return arrayOfNulls(size)
        }
    }



    fun getTitle(): String{
        return title
    }

    fun setTitle(title: String){
        this.title = title
    }

    fun getDescription(): String{
        return description
    }

    fun setDescription(description: String){
        this.description = description
    }

    fun getEmoji(): String{
        return emoji
    }

    fun getDay(): String{
        return day
    }

    fun getMonth(): String{
        return month
    }

    fun getYear(): String{
        return year
    }

    override fun toString(): String {
        return "DiaryDomain(title='$title', description='$description', emoji='$emoji', day='$day', month='$month', year='$year')"
    }


}