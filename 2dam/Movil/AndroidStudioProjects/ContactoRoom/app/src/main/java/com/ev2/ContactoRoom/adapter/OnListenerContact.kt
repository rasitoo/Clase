package com.ev2.ContactoRoom.adapter

interface OnListenerContact {
    fun onClick()
    abstract fun deleteContact(position: Int)
}