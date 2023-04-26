package com.java.main;

import com.java.view.AppUI;
import static com.java.view.AppUI.inputInteger; //스테틱 메서드를 직접 임포트. (클래스명 없이 호출 가능)

public class Main {

	public static void main(String[] args) {
		
		AppController controller = new AppController(); 
		
		while(true) {
			AppUI.startScreen();
			int selectNumber = inputInteger();
			controller.chooseSystem(selectNumber);
		}
		
		
		
		

	}

}
