package egovframework.com.uat.sso.filter;

import egovframework.com.uat.sso.service.EgovSSOService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 공통서비스 개발팀 서준식
 * @version 1.0
 * @see <pre>
 * 개정이력(Modification Information)
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2011. 8. 29.    서준식        최초생성
 *
 *  </pre>
 * @since 2011. 8. 29.
 */

public class EgovSSOLogoutFilter implements Filter {
    private FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        ApplicationContext act = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        EgovSSOService egovSSOService = (EgovSSOService) act.getBean("egovSSOService");

        String returnURL = config.getInitParameter("returnURL");

        ((HttpServletRequest) request).getSession().setAttribute("loginVO", null);
        egovSSOService.ssoLogout(request, response, ((HttpServletRequest) request).getContextPath() + returnURL);

    }

    public void init(FilterConfig filterConfig) throws ServletException {

        this.config = filterConfig;
    }
}
