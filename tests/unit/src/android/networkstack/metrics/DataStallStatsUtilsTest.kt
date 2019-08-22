/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.networkstack.metrics

import android.net.captiveportal.CaptivePortalProbeResult
import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import com.android.networkstack.metrics.DataStallStatsUtils
import com.android.server.connectivity.nano.DataStallEventProto
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class DataStallStatsUtilsTest {
    @Test
    fun testProbeResultToEnum() {
        assertEquals(DataStallStatsUtils.probeResultToEnum(null), DataStallEventProto.INVALID)
        assertEquals(DataStallStatsUtils.probeResultToEnum(CaptivePortalProbeResult.FAILED),
                DataStallEventProto.INVALID)
        assertEquals(DataStallStatsUtils.probeResultToEnum(CaptivePortalProbeResult.SUCCESS),
                DataStallEventProto.VALID)
        assertEquals(DataStallStatsUtils.probeResultToEnum(CaptivePortalProbeResult.PARTIAL),
                DataStallEventProto.PARTIAL)
        assertEquals(DataStallStatsUtils.probeResultToEnum(
                CaptivePortalProbeResult(CaptivePortalProbeResult.PORTAL_CODE)),
                DataStallEventProto.PORTAL)
    }
}
