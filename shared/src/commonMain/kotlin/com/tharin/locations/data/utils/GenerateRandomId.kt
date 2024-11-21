package com.tharin.locations.data.utils

import com.benasher44.uuid.uuid4
import kotlinx.datetime.Clock

fun generateRandomUniqueId(): Long =
    (uuid4().mostSignificantBits + Clock.System.now().toEpochMilliseconds())