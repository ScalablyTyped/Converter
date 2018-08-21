package com.olvind.logging

import java.time.Instant

import sourcecode.{Enclosing, File, Line}

final class Metadata(
    val instant:   Instant,
    val logLevel:  LogLevel,
    val line:      Line,
    val file:      File,
    val enclosing: Enclosing,
)
