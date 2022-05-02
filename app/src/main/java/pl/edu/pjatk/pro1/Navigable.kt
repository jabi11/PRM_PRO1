package pl.edu.pjatk.pro1

interface Navigable {
    enum class Destination {
        List, Add
    }
    fun navigate(to: Destination)
}