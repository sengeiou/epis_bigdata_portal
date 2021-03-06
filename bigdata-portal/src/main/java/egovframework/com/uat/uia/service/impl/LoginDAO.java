package egovframework.com.uat.uia.service.impl;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import org.springframework.stereotype.Repository;

/**
 * 일반 로그인, 인증서 로그인을 처리하는 DAO 클래스
 *
 * @author 공통서비스 개발팀 박지욱
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.06  박지욱          최초 생성
 *  2011.08.26  서준식          EsntlId를 이용한 로그인 추가
 *  </pre>
 * @since 2009.03.06
 */
@Repository("loginDAO")
public class LoginDAO extends EgovComAbstractDAO {

    /**
     * 2011.08.26
     * EsntlId를 이용한 로그인을 처리한다
     *
     * @param vo LoginVO
     * @return LoginVO
     * @throws Exception
     */
    public LoginVO actionLoginByEsntlId(LoginVO vo) throws Exception {
        return (LoginVO) select("loginDAO.ssoLoginByEsntlId", vo);
    }

    /**
     * 일반 로그인을 처리한다
     *
     * @param vo LoginVO
     * @return LoginVO
     * @throws Exception
     */
    public LoginVO actionLogin(LoginVO vo) throws Exception {
        return (LoginVO) select("loginDAO.actionLogin", vo);
    }

    /**
     * 인증서 로그인을 처리한다
     *
     * @param vo LoginVO
     * @return LoginVO
     * @throws Exception
     */
    public LoginVO actionCrtfctLogin(LoginVO vo) throws Exception {

        return (LoginVO) select("loginDAO.actionCrtfctLogin", vo);
    }

    /**
     * 아이디를 찾는다.
     *
     * @param vo LoginVO
     * @return LoginVO
     * @throws Exception
     */
    public LoginVO searchId(LoginVO vo) throws Exception {

        return (LoginVO) select("loginDAO.searchId", vo);
    }

    /**
     * 비밀번호를 찾는다.
     *
     * @param vo LoginVO
     * @return LoginVO
     * @throws Exception
     */
    public LoginVO searchPassword(LoginVO vo) throws Exception {

        return (LoginVO) select("loginDAO.searchPassword", vo);
    }

    /**
     * 변경된 비밀번호를 저장한다.
     *
     * @param vo LoginVO
     * @throws Exception
     */
    public void updatePassword(LoginVO vo) throws Exception {
        update("loginDAO.updatePassword", vo);
    }
}
