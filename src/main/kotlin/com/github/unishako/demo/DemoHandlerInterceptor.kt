package com.github.unishako.demo

import org.slf4j.Logger
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class DemoHandlerInterceptor(private val log: Logger): HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        log.info("[START]" +
                "url=[${request.requestURL}] " +
                "method=[${request.method}] " +
                "remoteAddr=[${request.remoteAddr}] " +
                "sessionId=[${request.getSession().id}] " +
                "userAgent=[${request.getHeader("User-Agent")}]")
        return super.preHandle(request, response, handler)
    }

    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
        log.info("[END]" +
                "sessionId=[${request.getSession().id}]"
        )
        super.postHandle(request, response, handler, modelAndView)
    }
}