package com.auctech.siprint.services

import com.auctech.siprint.home.response.ResponseDashboard
import com.auctech.siprint.home.response.ResponseDateFilter
import com.auctech.siprint.home.response.ResponseNotification
import com.auctech.siprint.home.response.ResponseSearch
import com.auctech.siprint.home.response.ResponseSearchUser
import com.auctech.siprint.home.response.ResponseSentDoc
import com.auctech.siprint.home.response.ResponseSms
import com.auctech.siprint.initials.response.ResponseEmailOtpVerification
import com.auctech.siprint.initials.response.ResponseLogin
import com.auctech.siprint.initials.response.ResponseOtpVerification
import com.auctech.siprint.initials.response.ResponseSignup
import com.auctech.siprint.profile.response.ReponseUpdateDetail
import com.auctech.siprint.wallet.response.ResponseTransaction
import com.auctech.siprint.wallet.response.ResponseUsage
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiClient {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("userLogin")
    fun userLogin(
        @Field("phone") phone: String
    ): Call<ResponseLogin>

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("userLogin2")
    fun userLogin2(
        @Field("phone") phone: String
    ): Call<ResponseOtpVerification>

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("otpVerification")
    fun otpVerification(
        @Field("otp") otp: String,
        @Field("phone") phone: String
    ): Call<ResponseOtpVerification>

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("updatePdf")
    fun updatePdf(
        @Field("docID") docID: String,
        @Field("user_id") user_id: String,
        @Field("label") label: String,
        @Field("description") description: String,
    ): Call<ResponseSignup>

    @Multipart
    @POST("userRegistration2")
    fun userRegistration2(
        @Part("id") userId: RequestBody,
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody,
        @Part("fcmToken") fcmToken: RequestBody,
        @Part("gender") gender : RequestBody,
        @Part("password") password : RequestBody,
        @Part photo: MultipartBody.Part?
    ): Call<ResponseSignup>

    @Multipart
    @POST("userRegistration")
    fun userRegistration(
        @Part("id") userId: RequestBody,
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody,
        @Part("fcmToken") fcmToken: RequestBody,
        @Part photo: MultipartBody.Part
    ): Call<ResponseSignup>

    @Multipart
    @POST("updateUserDetails")
    fun updateUserDetail(
        @Part("user_id") userId: RequestBody,
        @Part("name") name: RequestBody,
        @Part("email") email: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part photo: MultipartBody.Part?
    ): Call<ReponseUpdateDetail>

    @GET("dashboard")
    fun getDashboardData(
        @Query("user_id") userId: String,
        @Query("offset") offset: Int
    ): Call<ResponseDashboard>

    @GET("pdfFilter")
    fun getPdfFilter(
        @Query("user_id") userId: String,
        @Query("starting") starting: String,
        @Query("ending") ending: String,
        @Query("offset") offset: Int
    ): Call<ResponseDateFilter>


    @Multipart
    @POST("uploadPdf")
    fun uploadPdf(
        @Part("id") userId: RequestBody,
        @Part("owner") name: RequestBody,
        @Part("description") description: RequestBody,
        @Part pdf: MultipartBody.Part
    ): Call<ResponseSignup>

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("searchPdf")
    fun getSearch(
        @Field("user_id") userId: String,
        @Field("search") search: String,
        @Field("offset") offset: Int,
    ): Call<ResponseSearch>

    @POST("updateFcm")
    fun updateFcmToken(@Body fcmBody: JsonObject): Call<ResponseSignup>

    @GET("getNotifications")
    fun getNotifications(@Query("user_id") userId: String): Call<ResponseNotification>

    @POST("searchUser")
    fun searchUser(@Body body: JsonObject): Call<ResponseSearchUser>

    @POST("docShare")
    fun shareDoc(@Body body: JsonObject): Call<ResponseSignup>

    @POST("makeHost")
    fun makeHost(@Body body: JsonObject): Call<ResponseSignup>

    @POST("getTransactions")
    fun getTransactions(@Body body: JsonObject): Call<ResponseTransaction>

    @POST("getCreditByDate")
    fun getLimitUsage(@Body body: JsonObject): Call<ResponseUsage>

    @POST("updatePhone")
    fun updatePhone(@Body body: JsonObject): Call<ResponseSignup>

    @POST("mailsend")
    fun sendMail(@Body body: JsonObject): Call<ResponseSignup>

    @POST("getSentDocs")
    fun getSentDoc(@Body body: JsonObject): Call<ResponseSentDoc>

    @POST("sendOtpForMobileChange")
    fun emailOtpForMobileChange(@Body body: JsonObject): Call<ResponseSignup>

    @POST("verifyOtpForMobileChange")
    fun verifyOtpForMobileChange(@Body body: JsonObject): Call<ResponseEmailOtpVerification>

    //SMS apis
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("getReceivedSms")
    fun getReceivedSms(
        @Field("owner_id") userId: String,
        @Field("offset") offset: Int
    ): Call<ResponseSms>

    @POST("createTicket")
    fun contactUs(@Body body: JsonObject): Call<ResponseSignup>

}

