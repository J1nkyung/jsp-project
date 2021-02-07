package web.controls;

import java.util.Map;

import web.dao.MysqlMemberDao;
import web.vo.Member;

public class MemberJoinController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if(model.get("member") == null) {
			return "/member/MemberForm.jsp";
		}else {
			MysqlMemberDao memberDao = (MysqlMemberDao)model.get("memberDao");
			Member member = (Member)model.get("member");
			memberDao.memberJoin(member);
			
			return "redirect:../index.do";
		}
	}

}
