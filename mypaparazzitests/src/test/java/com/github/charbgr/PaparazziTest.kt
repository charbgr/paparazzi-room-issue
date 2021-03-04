package com.github.charbgr

import android.widget.LinearLayout
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.github.charbgr.mypaparazzitests.R
import com.squareup.burst.BurstJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(BurstJUnit4::class)
class PaparazziTest(config: Config) {

    enum class Config(val deviceConfig: DeviceConfig) {
        NEXUS_4(deviceConfig = DeviceConfig.NEXUS_4),
        NEXUS_5(deviceConfig = DeviceConfig.NEXUS_5),
        NEXUS_5_LAND(deviceConfig = DeviceConfig.NEXUS_5_LAND),
    }

    @get:Rule
    var paparazzi = Paparazzi(deviceConfig = config.deviceConfig)

    @Test
    fun simple() {
        val launch = paparazzi.inflate<LinearLayout>(R.layout.fragment_first)
        paparazzi.snapshot(launch)
    }
}
