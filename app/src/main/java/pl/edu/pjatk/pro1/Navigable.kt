package pl.edu.pjatk.pro1

import android.os.Bundle

interface Navigable {
    enum class Destination {
        List, Add, Detail
    }
    fun navigate(to: Destination)
}