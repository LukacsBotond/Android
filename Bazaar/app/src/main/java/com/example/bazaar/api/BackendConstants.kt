package com.example.bazaar.api

object BackendConstants {
    /**
     * Project backend base URL.
     */
    const val BASE_URL = "https://pure-gorge-51703.herokuapp.com/"

    /**
     * Specific URL segments, which will be concatenated with the base URL.
     */
    const val LOGIN_URL = "user/login"
    const val REGISTER_URL = "user/register"
    const val FORGOT_URL = "user/reset"

    const val GET_PRODUCT_URL = "products"
    const val GET_PROFILE_URL = "user/data"
    const val UPDATE_PROFILE_URL = "user/update"
    const val ADD_PRODUCT_URL = "products/add"

    /**
     * Headers.
     */
    const val HEADER_TOKEN = "token"
    const val HEADER_USERNAME = "username"
    const val HEADER_LIMIT = "limit"
    const val HEADER_FILTER = "filter"
}