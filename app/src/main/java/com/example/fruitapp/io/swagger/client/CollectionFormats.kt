package com.example.fruitapp.io.swagger.client

import com.example.fruitapp.io.swagger.client.CollectionFormats.CSVParams
import java.util.*

class CollectionFormats {
    open class CSVParams {
        var params: List<String>? = null

        constructor() {}
        constructor(params: List<String>?) {
            this.params = params
        }

        constructor(vararg params: String?) {
            this.params = Arrays.asList(*params) as List<String>?
        }

        override fun toString(): String {
            return StringUtil.join(params!!.toTypedArray(), ",")
        }
    }

    class SSVParams : CSVParams {
        constructor() {}
        constructor(params: List<String>?) : super(params) {}
        constructor(vararg params: String?) : super(*params) {}

        override fun toString(): String {
            return StringUtil.join(params!!.toTypedArray(), " ")
        }
    }

    class TSVParams : CSVParams {
        constructor() {}
        constructor(params: List<String>?) : super(params) {}
        constructor(vararg params: String?) : super(*params) {}

        override fun toString(): String {
            return StringUtil.join(params!!.toTypedArray(), "\t")
        }
    }

    class PIPESParams : CSVParams {
        constructor() {}
        constructor(params: List<String>?) : super(params) {}
        constructor(vararg params: String?) : super(*params) {}

        override fun toString(): String {
            return StringUtil.join(params!!.toTypedArray(), "|")
        }
    }
}