package model

import android.util.EventLog


data class Evento(val name: String?,
                  val address: String?,
                  val description: String?,
                  val dateHour: String?,
                  val price: Int?,
                  val numTickets: Int?,
                  val image: String?,
                  val cordLat: Double,
                  val cordLng: Double,
                  var favorite: Boolean?,
                  val ticket: Long?)




