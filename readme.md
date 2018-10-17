1. Mengapa perlu menginisiasi object PilotModel, sedangkan yang di test hanya FlightModel?
jawab: karena pada database FlightModel terdapat kolom pilotlicensenumber

2. Jelaskan apa yang akan terjadi jika object PilotModel dihapus dan tidak dilakukan setPilot pada FlightModel?
jawab: maka test assertThat(found.get(), Matchers.equalTo(flightModel)) akan gagal

3. Jelaskan apa yang dilakukan oleh code Mockito.when(flightDb.findByFlightNumber(flight.get().getFlightNumber())).thenReturn(flight);
jawab: mencoba mencari data FlightModel pada database dengan menggunakan parameter flightNumber, lalu akan me-return FlightModel

4. Jelaskan apa yang dilakukan oleh code Mockito.when(flightService.getFlightDetailByFlightNumber(flight.get().getFlightNumber())).thenReturn(flight);
jawab: mencoba mencari FlightModel dengan menggunakan flightService lalu akan me-return FlightModel
        

5. Jelaskan apa yang ditest oleh code .andExpect(MockMvcResultMatchers.status().isOk())
jawab: mengecek status code dari halaman yang diakses
.isOk() mengecek apakah status response halaman adalah 200

6. Jelaskan apa yang ditest oleh code .andExpect(MockMvcResultMatchers.jsonPath("$.flightNumber", Matchers.is(flight.get().getFlightNumber())));
jawab: setelah mendapat response dalam bentuk json kita mengakses key flightNumber dari response tersebut kemudian dicocokan dengan flightNumber pada test

7. Jelaskan anotasi @ResponseBody yang ada pada route "/flight/view"
jawab: mengembalikan response dalam bentuk json
