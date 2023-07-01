package com.yooni.newsletter.controller.operator.v1

import com.yooni.service.NewsLetterService
import com.yooni.type.YesNoType
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/operator/news-letter-info")
class NewsLetterInfoOperationController(
    private val newsLetterService: NewsLetterService
) {

    @GetMapping("/{external_id}")
    fun getNewsLetterInfo(@PathVariable("external_id") externalId: String) =
        newsLetterService.getNewsLetterInfo(externalId)?.let {
            NewsLetterInfoResponse(
                externalId = it.externalId,
                labelId = it.labelId,
                name = it.name,
                url = it.url,
                description = it.description,
                monYn = it.monYn,
                tueYn = it.tueYn,
                wedYn = it.wedYn,
                thuYn = it.thuYn,
                friYn = it.friYn,
                satYn = it.satYn,
                sunYn = it.sunYn,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }

    @PostMapping
    fun registerNewsLetterInfo(@RequestBody request: RegisterNewsLetterInfoRequest) =
        with(request) {
            newsLetterService.addNewsLetterInfo(
                labelId = mailLabelId,
                name = name,
                url = url,
                description = description,
                monYn = monYn,
                tueYn = tueYn,
                wedYn = wedYn,
                thuYn = thuYn,
                friYn = friYn,
                satYn = satYn,
                sunYn = sunYn
            ).let {
                RegisterNewsLetterInfoResponse(
                    name = it.name,
                    externalId = it.externalId
                )
            }
        }
}

data class NewsLetterInfoResponse(
    val externalId: String,
    val labelId: String,
    val name: String,
    val url: String,
    val description: String,
    val monYn: YesNoType,
    val tueYn: YesNoType,
    val wedYn: YesNoType,
    val thuYn: YesNoType,
    val friYn: YesNoType,
    val satYn: YesNoType,
    val sunYn: YesNoType,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)

data class RegisterNewsLetterInfoRequest(
    val mailLabelId: String,
    val name: String,
    val url: String,
    val description: String,
    val monYn: YesNoType = YesNoType.Y,
    val tueYn: YesNoType = YesNoType.Y,
    val wedYn: YesNoType = YesNoType.Y,
    val thuYn: YesNoType = YesNoType.Y,
    val friYn: YesNoType = YesNoType.Y,
    val satYn: YesNoType = YesNoType.N,
    val sunYn: YesNoType = YesNoType.N
)

data class RegisterNewsLetterInfoResponse(
    val name: String,
    val externalId: String
)