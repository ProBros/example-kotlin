package data

import java.util.*

/**
 * Created by djordje on 10.11.16.
 */
data class ProfileData (val showOne: Boolean): DataInterface{

    var profiles: ArrayList<Profile> = ArrayList()
    override fun getData(): Any {
        profiles.add(Profile("Djordje", "Pantelic", "123456"))
        profiles.add(Profile("Jovana", "Kovacevic", "556544"))

        if(showOne) {
            return this.profiles.get(0)
        } else {
            return this.profiles
        }
    }
}

data class Profile (val name: String, val lastName: String, val id: String)