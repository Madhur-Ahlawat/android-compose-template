package com.monstarlab.core.data.network

import com.monstarlab.core.data.network.dtos.PostDto
import com.monstarlab.core.data.network.dtos.ResourceDetailsDto
import com.monstarlab.core.data.network.dtos.ResourceDto
import com.monstarlab.core.data.network.responses.ResourcesResponse
import com.monstarlab.core.data.network.responses.TokenResponse
import com.monstarlab.core.data.network.responses.UserResponse
import com.monstarlab.core.pagination.model.Resource
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("posts")
    suspend fun getPosts(): Response<List<PostDto>>

    @FormUrlEncoded
    @POST("login")
    suspend fun postLogin(@Field("email") email: String, @Field("password") password: String): Response<TokenResponse>

    @GET("users/2")
    suspend fun getUser(): Response<UserResponse>

    @GET("beers")
    suspend fun getResources(@Query("page") page: Int, @Query("per_page") limit: Int): Response<List<ResourceDto>>

    @GET("beers/{id}")
    suspend fun getResourcesDetails(@Path("id") id: Int): Response<List<ResourceDetailsDto>>
}