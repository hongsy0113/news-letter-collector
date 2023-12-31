package com.yooni.job.tasklet

import com.yooni.service.MailService
import com.yooni.service.NewsLetterDataService
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class FetchNewsLetterTasklet(
    private val mailService: MailService,
    private val newsLetterDataService: NewsLetterDataService,
) : Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        val newsLetterMailIds = mailService.getNotProcessedNewsLetterMailIds()

        for (mailId in newsLetterMailIds) {
            mailService.getNewsLetterMailData(mailId).let {
                newsLetterDataService.saveNewsLetter(it)
            }
            mailService.completeMail(mailId)
        }

        return RepeatStatus.FINISHED
    }
}

