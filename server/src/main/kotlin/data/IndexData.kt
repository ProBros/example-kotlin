package data

import java.io.Serializable

/**
 * Created by djordje on 08.11.16.
 */
data class IndexData(var content: String) : DataInterface, Serializable {

    override fun getData(): Any {
        content = "Content"
        return this
    }
}
