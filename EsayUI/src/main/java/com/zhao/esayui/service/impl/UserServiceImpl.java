package com.zhao.esayui.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhao.esayui.domain.ResultEntity;
import com.zhao.esayui.domain.User;
import com.zhao.esayui.persistence.UserMapper;
import com.zhao.esayui.service.UserService;
import com.zhao.esayui.util.MessageUtil;
/**
 * �û�������service��
 * @author henry.zhao
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;

	public User getUserByName(String name) {
		return userMapper.getUserByName(name);
	}

	@Override
	public ResultEntity checkLogin(User user) {
		ResultEntity rs = new ResultEntity();
		User u = userMapper.getUserByName(user.getUsername());
		if(u==null){
			rs.setStatus("2");
			rs.setMsg("�û�������");
			return rs;
		}
		if(user.getPassword().equals(u.getPassword())){
			rs.setStatus("0");
			rs.setMsg("��½�ɹ�");
			return rs;
		}else{
			rs.setStatus("1");
			rs.setMsg("��½ʧ��");
			return rs;
		}
	}

	@Override
	public ResultEntity regist(User user) {
		ResultEntity rs = new ResultEntity();
		User u = userMapper.getUserByName(user.getUsername());
		if(u != null){
			rs.setStatus("1");
			rs.setMsg("���û��Ѿ�ע��");
			return rs;
		}
		//��������
		String uuid = MessageUtil.getUUID();
		user.setId(uuid);
		//�������
		String md5_password = MessageUtil.md5(user.getPassword());
		user.setPassword(md5_password);
		userMapper.saveUser(user);//������Ϣ
		
		rs.setStatus("0");
		rs.setMsg("ע��ɹ�");
		return rs;
	}

	@Override
	public Map<String, Object> getUserPages(Map map) {
		Map<String, Object> m =new HashMap<String, Object>();
		int total =userMapper.getUserTotalRows();
		List<User> users= userMapper.getUserPages(map);
		m.put("total", total);
		m.put("rows", users);
		return m;
	}
	
}
