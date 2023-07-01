package com.yooni.service

import com.yooni.domain.entity.NewsLetterInfo
import com.yooni.newsletter.domain.repository.NewsLetterInfoRepository
import com.yooni.newsletter.domain.repository.NewsLetterRepository
import com.yooni.type.YesNoType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class NewsLetterService(
    private val newsLetterRepository: NewsLetterRepository,
    private val newsLetterInfoRepository: NewsLetterInfoRepository,
) {
    fun getNewsLetter(externalId: String) =
        newsLetterRepository.findByExternalId(externalId)?.let { newsLetter ->
            getNewsLetterInfo(newsLetter.newsLetterInfoExternalId)?.let {

            }
        }

    @Transactional(readOnly = true)
    fun getNewsLetterInfo(externalId: String) =
        newsLetterInfoRepository.findByExternalId(externalId)

    @Transactional
    fun addNewsLetterInfo(
        labelId: String,
        name: String,
        url: String,
        description: String,
        monYn: YesNoType = YesNoType.Y,
        tueYn: YesNoType = YesNoType.Y,
        wedYn: YesNoType = YesNoType.Y,
        thuYn: YesNoType = YesNoType.Y,
        friYn: YesNoType = YesNoType.Y,
        satYn: YesNoType = YesNoType.N,
        sunYn: YesNoType = YesNoType.N
    ) = newsLetterInfoRepository.save(
        NewsLetterInfo(
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
    )
}