package com.java.user.service;

import java.util.List;

import com.java.common.AppService;
import com.java.user.domain.User;
import com.java.user.repository.UserRepository;
import com.java.view.AppUI;

public class UserService implements AppService {

	
	private final UserRepository userRepository = new UserRepository();
	

	public void start() {
		while(true) {
			AppUI.userManagementScreen();
			int selection = AppUI.inputInteger();
			
			switch (selection) {
			case 1:
				join();
				break;
			case 2:
				showSearchResult();
				break;
			case 3:
				deleteUser();
				break;
			case 4:
				return; //메인 화면으로 돌아가기
				
			default:
				System.out.println("메뉴를 다시 입력하세요.");
				break;
			}
			System.out.println("\n────*** 계속 진행하시려면 ENTER를 눌러주세요.***────");
			AppUI.inputString();
			
		}
	}

	
	
	//회원 추가 비즈니스 로직
	private void join() { //다른 클래스에서 부를 일 없기 때문에 프라이빗으로 선언
		
		System.out.println("\n------- 회원 가입을 진행합니다. -------");
		System.out.print("# 회원명: ");
		String name = AppUI.inputString();
		
		System.out.print("# 전화번호: ");
		String phone = AppUI.inputString();
		
		User user = new User();
		user.setUserName(name);
		user.setPhoneNumber(phone);
		
		userRepository.addUser(user);
	}
	
	
	//회원 이름으로 검색 비즈니스 로직
	private List<User> searchUser() {
		System.out.print("\n# 조회할 회원의 이름을 입력하세요.\n> ");
		String name = AppUI.inputString();
		return userRepository.findByUserName(name); 
	}
	
	private int showSearchResult() {
//		searchUser();
		List<User> users = searchUser();
		
		if(!users.isEmpty()) {
			System.out.println("\n-------------------------- 회원 조회 결과 --------------------------");
			for(User u : users) {
				System.out.println(u);
			}
			System.out.println("\n--------------------------------------------------------------------");
		} else {
			System.out.println("\n# 조회결과가 없습니다.");
		}
		return users.size();
		
	}
	
	
	//회원 탈퇴 로직
	private void deleteUser() {
		
		if(showSearchResult() > 0) {
			System.out.print("\n# 탈퇴할 회원의 번호를 입력하세요 \n>");
			int delUserNum = AppUI.inputInteger();
			userRepository.deleteUser(delUserNum);
		}
		
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
