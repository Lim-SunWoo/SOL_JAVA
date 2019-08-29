package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcImpl;

public class BaseCalcFactory {

	// single-ton
	// 챔플릿: primary -> 메인클래스 네임. primarytypename
	// _single 컨스페 -> 자동으로 입력 가능
	static BaseCalcFactory single = null;

	public static BaseCalcFactory getInstance() {
		if (single == null)
			single = new BaseCalcFactory();
		return single;

	}

	public BaseCalc createBaseCalc() {
		BaseCalc calc = new BaseCalcImpl();
		return calc;
	}

}
