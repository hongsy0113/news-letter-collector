package com.yooni.domain.entity

import com.yooni.helper.generateExternalId
import com.yooni.newsletter.domain.AuditEntity
import com.yooni.type.YesNoType
import javax.persistence.*

@Entity
data class NewsLetterInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_letter_info_id")
    val id: Long? = null,
    val externalId: String,
    val labelId: String,
    val name: String,
    val url: String,
    val description: String,
    @Enumerated(EnumType.STRING)
    val monYn: YesNoType,
    @Enumerated(EnumType.STRING)
    val tueYn: YesNoType,
    @Enumerated(EnumType.STRING)
    val wedYn: YesNoType,
    @Enumerated(EnumType.STRING)
    val thuYn: YesNoType,
    @Enumerated(EnumType.STRING)
    val friYn: YesNoType,
    @Enumerated(EnumType.STRING)
    val satYn: YesNoType,
    @Enumerated(EnumType.STRING)
    val sunYn: YesNoType
) : AuditEntity() {
    constructor(
        labelId: String,
        name: String,
        url: String,
        description: String,
        monYn: YesNoType,
        tueYn: YesNoType,
        wedYn: YesNoType,
        thuYn: YesNoType,
        friYn: YesNoType,
        satYn: YesNoType,
        sunYn: YesNoType
    ) : this(
        externalId = generateExternalId(ABBREVIATED_TABLE_NAME),
        labelId = labelId,
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
    )

    companion object {
        private const val ABBREVIATED_TABLE_NAME = "nli"
    }
}