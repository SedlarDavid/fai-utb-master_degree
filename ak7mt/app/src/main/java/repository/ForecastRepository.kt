package repository

import api.Api
import api.ForecastApi
import com.google.gson.Gson
import entities.forecast.Forecast
import serializers.mocks.ForecastMock

class ForecastRepository {
    private val api: ForecastApi = Api.forecast
    private val gson = Gson()

    fun getForecast(): Forecast {

        /* val response = api.getForecast(49.224438, 17.662764)
         val decoded = gson.fromJson(response, Forecast::class.java)
         return decoded*/

        return ForecastMock.forecast
    }

}