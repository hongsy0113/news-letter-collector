package com.yooni.newsletter.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/news-letters")
class NewsLetterController {

    @GetMapping("/{external_id}")
    fun getNewsLetter(@PathVariable("external_id") externalId: String) {

    }
}

data class NewsLetterResponse(
    val externalId: String,
    val newsLetterInfoExternalId: String,
    val newsLetterInfoName: String,
    val title: String,
    val snippet: String? = null,
    val content: String,
    val uploadedDate: LocalDate,
    val receivedAt: LocalDateTime,
)